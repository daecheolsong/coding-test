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

			int[][] map = new int[9][9];

			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean able = true;

			for (int i = 0; i < 9; i++) {
				int[] f = new int[10];
				for (int j = 0; j < 9; j++) {
					if (f[map[i][j]] > 0) {
						able = false;
					}
					f[map[i][j]]++;
				}
			}

			for (int i = 0; i < 9; i++) {
				int[] f = new int[10];
				for (int j = 0; j < 9; j++) {
					if (f[map[j][i]] > 0) {
						able = false;
					}
					f[map[j][i]]++;
				}
			}

			for (int i = 0; i < 9; i += 3) {
				for (int j = 0; j < 9; j += 3) {
					int[] f = new int[10];
					for (int k = i; k < i + 3; k++) {
						for (int l = j; l < j + 3; l++) {
							if (f[map[k][l]] > 0) {
								able = false;
							}
							f[map[k][l]]++;
						}
					}
				}
			}

			sb.append(able ? "1\n" : "0\n");
		}
		System.out.println(sb);

	}
}