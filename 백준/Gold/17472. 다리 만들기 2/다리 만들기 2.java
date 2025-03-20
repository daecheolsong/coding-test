import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[][] map;
	static int[] mvr = { -1, 1, 0, 0 };
	static int[] mvc = { 0, 0, 1, -1 };
	static int area = 1;
	static Map<String, Integer> dp = new HashMap<>();
	static int answer = Integer.MAX_VALUE;
	static int[] p;
	static int[] con;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] = -1;
				}
			}
		}

		makeArea();

		StringBuilder sb = new StringBuilder();
		fill(1, sb, 0);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				connect(i, j);
			}
		}
		p = new int[area];
		con = new int[area];

		for (int i = 1; i < area; i++) {
			p[i] = i;
		}

		PriorityQueue<E> pq = new PriorityQueue<>(
				(e1, e2) -> e1.cost == e2.cost ? (e1.e == e2.e ? e1.s - e2.s : e1.e - e2.e) : e1.cost - e2.cost);

		for (String key : dp.keySet()) {
			int num = Integer.parseInt(key);
			if (dp.get(key) == Integer.MAX_VALUE) {
				continue;
			}
			pq.add(new E(num / 10, num % 10, dp.get(key)));
		}
//		System.out.println(pq);
		int cost = 0;
		int put = 0;
		while (!pq.isEmpty()) {
			E edge = pq.poll();
			if (find(edge.s) != find(edge.e)) {
				put++;
				union(edge.s, edge.e);
				cost += edge.cost;
			}

		}

		if (put != area - 2 || cost == 0) {
			System.out.println(-1);
		} else {
			System.out.println(cost);
		}
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b) {
			p[a] = b;
		} else {
			p[b] = a;
		}
	}

	private static int find(int x) {
		if (p[x] == x)
			return x;
		else
			return find(p[x]);
	}

	static class E {
		int s;
		int e;
		int cost;

		public E(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "E [s=" + s + ", e=" + e + ", cost=" + cost + "]";
		}

	}

	private static void fill(int next, StringBuilder sb, int cnt) {
		if (cnt == 2) {
			dp.put(sb.toString(), Integer.MAX_VALUE);
			return;
		}

		for (int i = next; i < area; i++) {
			sb.append(i);
			fill(i + 1, sb, cnt + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static void connect(int r, int c) {

		for (int i = 0; i < 4; i++) {
			int nr = r;
			int nc = c;
			int count = 0;
			while (true) {
				nr = nr + mvr[i];
				nc = nc + mvc[i];

				if (!isIn(nr, nc)) {
					count = 0;
					break;
				}

				if (map[r][c] == map[nr][nc]) {
					count = 0;
					break;
				}

				if (map[r][c] != map[nr][nc] && map[nr][nc] != 0) {
					if (count == 1) {
						count = 0;
						break;
					}
					int from = map[r][c];
					int to = map[nr][nc];

					if (to < from) {
						int temp = to;
						to = from;
						from = temp;
					}
					String key = String.valueOf(10 * from + to);

					dp.put(key, Math.min(dp.get(key), count));
					break;
				}

				count++;
			}
		}

	}

	private static void makeArea() {
		int[][] v = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == -1) {
					bfs(i, j, v);
					area++;
				}
			}
		}
	}

	private static void bfs(int r, int c, int[][] v) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		v[r][c] = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			map[cur[0]][cur[1]] = area;
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + mvr[i];
				int nc = cur[1] + mvc[i];
				if (isIn(nr, nc) && map[nr][nc] != 0 && v[nr][nc] == 0) {
					v[nr][nc] = 1;
					q.add(new int[] { nr, nc });
				}
			}

		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}
}
