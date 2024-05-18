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

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int y = 1;

			int curS = 1;
			int curE = 1;
			int curM = 1;

			while (true) {
				if (curS == s && curE == e && curM == m) {
					break;
				}

				curS++;
				curE++;
				curM++;

				curS = (curS > 365) ? 1 : curS;
				curE = (curE > 24) ? 1 : curE;
				curM = (curM > 29) ? 1 : curM;

				y++;
			}
			sb.append(y).append("\n");

		}

		System.out.println(sb);

	}
}