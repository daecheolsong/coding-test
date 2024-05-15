import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

			List<List<Pos>> posList = new ArrayList<>();

			for (int i = 0; i <= k; i++) {
				posList.add(new ArrayList<>());
			}

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int num = Integer.parseInt(st.nextToken());
					posList.get(num).add(new Pos(i, j, num == 1 ? 0 : 100_000_000));
				}
			}

			boolean able = true;

			for (int i = 1; i < k; i++) {
				List<Pos> curPosList = posList.get(i);

				if (curPosList.isEmpty()) {
					sb.append("-1\n");
					able = false;
					break;
				}

				List<Pos> nextPosList = posList.get(i + 1);

				for (int l = 0; l < curPosList.size(); l++) {
					Pos curPos = curPosList.get(l);
					for (int m = 0; m < nextPosList.size(); m++) {
						Pos nextPos = nextPosList.get(m);
						int curDist = Math.abs(nextPos.x - curPos.x) + Math.abs(nextPos.y - curPos.y);
						nextPos.minDist = Math.min(curPos.minDist + curDist, nextPos.minDist);
					}
				}
			}

			if (!able) {
				continue;
			}

			List<Pos> result = posList.get(k);

			int minDist = 100_000_000;

			for (Pos pos : result) {
				minDist = Math.min(minDist, pos.minDist);
			}
			sb.append(minDist).append("\n");
		}
		System.out.println(sb);
	}

	private static class Pos {
		int x;
		int y;
		int minDist;

		public Pos(int x, int y, int minDist) {
			this.x = x;
			this.y = y;
			this.minDist = minDist;
		}
	}
}
