import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			char[] s = br.readLine().toCharArray();
			char[] init = new char[s.length];
			Arrays.fill(init, '0');
			int count = 0;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == init[i]) {
					continue;
				}

				for (int j = i; j < s.length; j++) {
					init[j] = init[j] == '0' ? '1' : '0';
				}
				count++;

			}
			sb.append(count).append("\n");

		}
		System.out.println(sb);

	}

}