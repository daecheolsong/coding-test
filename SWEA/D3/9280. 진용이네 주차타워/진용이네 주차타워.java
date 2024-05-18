import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] r = new int[n + 1];
			int[] w = new int[m + 1];

			for (int i = 1; i <= n; i++) {
				r[i] = Integer.parseInt(br.readLine());
			}

			for (int i = 1; i <= m; i++) {
				w[i] = Integer.parseInt(br.readLine());
			}

			int[] f = new int[n + 1];

			int sum = 0;

			int e = -1;
			int s = 0;
			int[] wait = new int[m];

			for (int i = 0; i < 2 * m; i++) {
				int car = Integer.parseInt(br.readLine());
				if (car > 0) {
					boolean push = false;
					for (int j = 1; j <= n; j++) {
						if (f[j] == 0) {
							sum += r[j] * w[car];
							f[j] = car;
							push = true;
							break;
						}
					}
					if (!push) {
						wait[++e] = car;
					}
					continue;
				}

				int popIdx = 0;

				for (int j = 1; j <= n; j++) {
					if (f[j] == -car) {
						f[j] = 0;
						popIdx = j;
						break;
					}
				}

				if (s <= e) {
					int waitCar = wait[s++];
					f[popIdx] = waitCar;
					sum += w[waitCar] * r[popIdx];
				}
			}

			sb.append(sum).append("\n");
		}
		System.out.println(sb);

	}
}