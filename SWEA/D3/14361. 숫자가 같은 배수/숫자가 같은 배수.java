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

			long n = Integer.parseInt(br.readLine());

			boolean possible = false;

			for (int i = 2; i < 10; i++) {
				char[] ns = String.valueOf(n).toCharArray();
				char[] s = String.valueOf(i * n).toCharArray();
				if (ns.length != s.length) {
					continue;
				}
				Arrays.sort(ns);
				Arrays.sort(s);

				int cnt = 0;
				for (int j = 0; j < s.length; j++) {
					if (s[j] == ns[j]) {
						cnt++;
					}
				}

				if (cnt == s.length) {
					possible = true;
					break;
				}
			}

			sb.append(possible ? "possible\n" : "impossible\n");

		}
		System.out.println(sb);

	}
}