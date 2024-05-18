import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());

			int[][] m = new int[n][n];

			for (int i = 0; i < n; i++) {
				String[] line = br.readLine().split("");
				for (int j = 0; j < n; j++) {
					m[i][j] = Integer.parseInt(line[j]);
				}
			}

			int mid = n / 2;

			int sum = 0;
			for (int i = 0; i < n; i++) {
				int offset = Math.abs(mid - i);
				for (int j = offset; j < n - offset; j++) {
					sum += m[i][j];
				}
			}

			sb.append(sum).append("\n");

		}
		System.out.println(sb);
	}
}