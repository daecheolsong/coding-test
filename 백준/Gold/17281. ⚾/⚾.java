import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] hitter;
	static int[] cazes;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		hitter = new int[n + 1][10];

		cazes = new int[9];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				hitter[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);

		System.out.println(max);

	}

	public static void dfs(int cnt, int flag) {

		if (cnt == 9) {

			if (cazes[3] != 1) {
				return;
			}

			int startIdx = 0;
			int outCnt = 0;
			int score = 0;
			int curInning = 1;
			boolean[] base = new boolean[4];
			while (curInning <= n) {
				int act = hitter[curInning][cazes[startIdx]];
				if (act == 4) {
					score++;

					for (int i = 1; i < 4; i++) {
						if (base[i]) {
							score++;
							base[i] = false;
						}
					}

				}

				if (act == 0) {
					outCnt++;
					if (outCnt == 3) {
						outCnt = 0;
						curInning++;
						Arrays.fill(base, false);
					}

				}

				if (act == 1) {

					if (base[3]) {
						score++;
						base[3] = false;
					}

					if (base[2]) {
						base[3] = true;
						base[2] = false;
					}

					if (base[1]) {
						base[2] = true;
						base[1] = false;
					}

					base[1] = true;
				}

				if (act == 2) {
					for (int i = 3; i >= 2; i--) {
						if (base[i]) {
							base[i] = false;
							score++;
						}
					}
					if (base[1]) {
						base[3] = true;
						base[1] = false;
					}
					base[2] = true;

				}

				if (act == 3) {
					for (int i = 3; i >= 1; i--) {
						if (base[i]) {
							base[i] = false;
							score++;
						}
					}
					base[3] = true;
				}

				startIdx = (startIdx + 1) % 9;
			}

			max = Math.max(max, score);
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if ((flag & (1 << i)) == 0) {
				cazes[cnt] = i;
				dfs(cnt + 1, flag | (1 << i));
			}
		}

	}

}
