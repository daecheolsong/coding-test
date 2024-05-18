import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tk = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= tk; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			int[] t = new int[n];
			int[] k = new int[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				t[i] = Integer.parseInt(st.nextToken());
				k[i] = Integer.parseInt(st.nextToken());
			}

			int[][] dp = new int[n + 1][l + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= l; j++) {
					if (j - k[i - 1] >= 0) {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k[i - 1]] + t[i - 1]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}

			sb.append(dp[n][l]).append("\n");

		}
		System.out.println(sb);
	}
}