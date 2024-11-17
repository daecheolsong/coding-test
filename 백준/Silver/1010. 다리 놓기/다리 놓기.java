import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] dp = new int[m + 1][m + 1];
			// n - 1 C r + n - 1 C r - 1 = n C r
			for (int j = 0; j <= m; j++) {
				dp[j][0] = 1;
			}
			for (int j = 1; j <= m; j++) {
				for (int k = 1; k <= j; k++) {
					dp[j][k] = dp[j - 1][k] + dp[j - 1][k - 1];
				}
			}
			System.out.println(dp[m][n]);
		}
	}
}