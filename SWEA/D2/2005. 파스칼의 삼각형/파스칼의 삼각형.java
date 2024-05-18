import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tk = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= tk; tc++) {
			sb.append("#").append(tc).append("\n");
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[n + 1][n + 1];
			dp[0][0] = 1;

			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					if (j == 0 || j == n) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					sb.append(dp[i][j]).append(" ");
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}
}