class Solution {

	public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
		int[] answer = new int[balls.length];

		Pos startPos = new Pos(startX, startY);

		int idx = 0;
		for (int[] ballPos : balls) {
			Pos targetPos = new Pos(ballPos[0], ballPos[1]);

			int minDis = Integer.MAX_VALUE;

			if (!(startPos.x == targetPos.x && startPos.y < targetPos.y)) {
				int dx = startPos.x - targetPos.x;
				int dy = (2 * n - targetPos.y) - startPos.y;
				int dis = dx * dx + dy * dy;
				minDis = Math.min(minDis, dis);
			}

			if (!(startPos.x == targetPos.x && startPos.y > targetPos.y)) {
				int dx = startPos.x - targetPos.x;
				int dy = targetPos.y + startPos.y;
				int dis = dx * dx + dy * dy;
				minDis = Math.min(minDis, dis);
			}

			if (!(startPos.x > targetPos.x && startPos.y == targetPos.y)) {
				int dx = startPos.x + targetPos.x;
				int dy = targetPos.y - startPos.y;
				int dis = dx * dx + dy * dy;
				minDis = Math.min(minDis, dis);
			}

			if (!(startPos.x < targetPos.x && startPos.y == targetPos.y)) {
				int dx = (2 * m - targetPos.x) - startPos.x;
				int dy = targetPos.y - startPos.y;
				int dis = dx * dx + dy * dy;
				minDis = Math.min(minDis, dis);
			}
			answer[idx++] = minDis;
		}

		return answer;
	}

	private static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}