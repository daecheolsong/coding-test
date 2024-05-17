import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] m = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					m[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = 0;

			for (int i = 0; i < n; i++) {
				int s = 0;
				int length = 0;

				while (s < n) {
					if (m[i][s] == 0) {
						if (length == k) {
							answer++;
						}
						length = 0;
						s++;
						continue;
					}
					length++;
					s++;
				}
				if (length == k) {
					answer++;
				}
			}

			for (int i = 0; i < n; i++) {
				int s = 0;
				int length = 0;

				while (s < n) {
					if (m[s][i] == 0) {
						if (length == k) {
							answer++;
						}
						length = 0;
						s++;
						continue;
					}

					length++;
					s++;
				}

				if (length == k) {
					answer++;
				}

			}
			sb.append(answer).append("\n");

		}
		System.out.println(sb);

	}
}