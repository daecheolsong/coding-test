import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int[] mvx = { 1, -1, 0, 0 };
	public int[] mvy = { 0, 0, 1, -1 };
	public int leverLength = Integer.MAX_VALUE;
	public int answer = Integer.MAX_VALUE;

	public int solution(String[] maps) {

		int[][] v = new int[maps.length][maps[0].length()];

		int mx = maps[0].length();
		int my = maps.length;

		int sx = 0;
		int sy = 0;

		int lx = 0;
		int ly = 0;

		int ex = 0;
		int ey = 0;

		for (int i = 0; i < my; i++) {
			for (int j = 0; j < mx; j++) {
				if (maps[i].charAt(j) == 'S') {
					sx = j;
					sy = i;
				}

				if (maps[i].charAt(j) == 'L') {
					lx = j;
					ly = i;
				}

				if (maps[i].charAt(j) == 'E') {
					ex = j;
					ey = i;
				}
			}
		}

		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { sx, sy, 0 });
		v[sy][sx] = 1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			if (x == lx && y == ly) {
				leverLength = Math.min(leverLength, cur[2]);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + mvx[i];
				int ny = y + mvy[i];
				if (isIn(nx, ny, mx, my) && v[ny][nx] == 0 && maps[ny].charAt(nx) != 'X') {
					v[ny][nx] = 1;
					q.add(new int[] { nx, ny, cur[2] + 1 });
				}
			}
		}

		if (leverLength == Integer.MAX_VALUE) {
			return -1;
		}

		v = new int[maps.length][maps[0].length()];
		v[ly][lx] = 1;

		q = new LinkedList<>();
		q.add(new int[] { lx, ly, leverLength });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			if (x == ex && y == ey) {
				answer = Math.min(answer, cur[2]);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + mvx[i];
				int ny = y + mvy[i];
				if (isIn(nx, ny, mx, my) && v[ny][nx] == 0 && maps[ny].charAt(nx) != 'X') {
					v[ny][nx] = 1;
					q.add(new int[] { nx, ny, cur[2] + 1 });
				}
			}
		}

		if (answer == Integer.MAX_VALUE) {
			return -1;
		}

		return answer;
	}

	public boolean isIn(int x, int y, int mx, int my) {
		return x >= 0 && x < mx && y >= 0 && y < my;
	}
}