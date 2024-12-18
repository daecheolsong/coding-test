import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String pattern = br.readLine();
		int[] lps = lps(pattern);
		List<Integer> list = new ArrayList<>();
		int idx = 0;
		int cnt = 0;
		for (int i = 0; i < text.length(); i++) {
			while (idx > 0 && text.charAt(i) != pattern.charAt(idx)) {
				idx = lps[idx - 1];
			}

			if (text.charAt(i) == pattern.charAt(idx)) {
				if (idx == pattern.length() - 1) {
					list.add(i - idx + 1);
					cnt++;
					idx = lps[idx];
				} else {
					idx++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		for (int i : list) {
			sb.append(i).append(" ");
		}
		sb.append("\n");
		System.out.print(sb.toString());
	}

	public static int[] lps(String pattern) {
		int n = pattern.length();
		int[] lps = new int[n];
		int idx = 0;

		for (int i = 1; i < n; i++) {

			while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = lps[idx - 1];
			}

			if (pattern.charAt(i) == pattern.charAt(idx)) {
				idx++;
				lps[i] = idx;
			}
		}
		return lps;
	}

}
