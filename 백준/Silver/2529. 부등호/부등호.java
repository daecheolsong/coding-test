import java.io.*;
import java.util.*;

public class Main {
    static String minVal = "";
	static String maxVal = "";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i <= k; i++) {
			minVal += "9";
			maxVal += "0";
		}
		String[] op = br.readLine().split(" ");

		int rep = 1 << 10;

		for (int i = 1; i <= rep; i++) {
			if (Integer.bitCount(i) == k + 1) {
				StringBuilder sb = new StringBuilder();
				int temp = i;
				int idx = 0;
				while (temp > 0) {
					if ((temp & 1) == 1) {
						sb.append(idx);
					}
					temp = temp >> 1;
					idx++;
				}
				int[] v = new int[sb.length()];
				int[] tArr = new int[v.length];
				dfs(sb.toString().toCharArray(), 0, v, tArr, op);
			}
		}

		System.out.println(maxVal);
		System.out.println(minVal);
	}

	public static void dfs(char[] c, int depth, int[] v, int[] tArr, String[] op) {
		if (depth == c.length) {
			boolean check = true;
			for (int i = 0; i < op.length; i++) {
				int n1 = tArr[i];
				int n2 = tArr[i + 1];
				if (op[i].equals("<") && n1 >= n2) {
					check = false;
					break;
				} else if (op[i].equals(">") && n1 <= n2) {
					check = false;
					break;
				}
			}
			if (check) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < tArr.length; i++) {
					sb.append(tArr[i]);
				}
				if (sb.toString().compareTo(maxVal) > 0) {
					maxVal = sb.toString();
				}
				if (sb.toString().compareTo(minVal) < 0) {
					minVal = sb.toString();
				}
			}
			return;
		}

		for (int i = 0; i < c.length; i++) {
			if (v[i] == 0) {
				v[i] = 1;
				tArr[depth] = c[i] - '0';
				dfs(c, depth + 1, v, tArr, op);
				v[i] = 0;
			}
		}
	}
}