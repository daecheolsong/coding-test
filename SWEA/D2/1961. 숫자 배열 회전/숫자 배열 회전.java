import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" \n");
			int n = Integer.parseInt(br.readLine());
			int[][] m = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					m[i][j] = Integer.parseInt(st.nextToken());
				}

			}
			int[][] ninety = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					ninety[i][j] = m[n - 1 - j][i];
				}
			}
			int[][] ninety2 = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					ninety2[i][j] = m[n - 1 - i][n - 1 - j];
				}
			}

			int[][] ninety3 = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					ninety3[i][j] = m[j][n - 1 - i];
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(ninety[i][j]);
				}
				sb.append(" ");

				for (int j = 0; j < n; j++) {
					sb.append(ninety2[i][j]);
				}
				sb.append(" ");

				for (int j = 0; j < n; j++) {
					sb.append(ninety3[i][j]);
				}
				sb.append(" \n");
			}
		}
		System.out.println(sb);

	}

}