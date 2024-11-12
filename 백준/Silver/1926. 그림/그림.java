import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;
	static int maxA = 0;
	static int[] mvx = { -1, 1, 0, 0 };
	static int[] mvy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] v = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && v[i][j] == 0) {
					bfs(i, j, v, n, m, map);
					count++;
				}
			}
		}
		System.out.println(count);
		System.out.println(maxA);
	}

	public static void bfs(int r, int c, int[][] v, int n, int m, int[][] map) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		v[r][c] = 1;
		int area = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + mvy[i];
				int nx = cur[1] + mvx[i];
				if (isIn(nx, ny, m, n) && v[ny][nx] == 0 && map[ny][nx] == 1) {
					q.add(new int[] { ny, nx });
					v[ny][nx] = 1;
					area++;
				}
			}

		}
		maxA = Math.max(area, maxA);
	}

	public static boolean isIn(int nx, int ny, int x, int y) {
		return nx >= 0 && nx < x && ny >= 0 && ny < y;
	}
}