public class Solution {

	public static void main(String[] args) throws Exception {
	}

	public int solution(String[] board) {

		Result result = makeResult(board);

		if (result.xCount > result.oCount) {
			return 0;
		}

		if (result.oCount - result.xCount > 1) {
			return 0;
		}

		if (result.xLine == 0 && result.oLine == 0) {
			return 1;
		}

		if (result.xLine == 1 && result.oLine == 0) {
			if ((result.xCount == 3 && result.oCount == 3) || (result.xCount == 4 && result.oCount == 4)) {
				return 1;
			}
		}

		if (result.oLine == 1 && result.xLine == 0) {
			if ((result.oCount == 3 && result.xCount == 2) || (result.oCount == 4 && result.xCount == 3)) {
				return 1;
			}
		}

		if (result.xLine == 2 && result.oLine == 0) {
			if (result.xCount == 5 && result.oCount == 4) {
				return 1;
			}
		}

		if (result.oLine == 2 && result.xLine == 0) {
			if (result.oCount == 5 && result.xCount == 4) {
				return 1;
			}
		}

		return 0;

	}

	private Result makeResult(String[] board) {
		char[][] cBoard = new char[board.length][board.length];

		for (int i = 0; i < cBoard.length; i++) {
			cBoard[i] = board[i].toCharArray();
		}

		Result result = new Result();

		for (int i = 0; i < cBoard.length; i++) {
			for (int j = 0; j < cBoard.length; j++) {
				if (cBoard[i][j] == 'O') {
					result.oCount++;
				}

				if (cBoard[i][j] == 'X') {
					result.xCount++;
				}
			}
		}

		if (cBoard[0][0] == cBoard[0][1] && cBoard[0][1] == cBoard[0][2]) {
			if (cBoard[0][0] == 'O') {
				result.oLine++;
			}
			if (cBoard[0][0] == 'X') {
				result.xLine++;
			}
		}

		if (cBoard[1][0] == cBoard[1][1] && cBoard[1][1] == cBoard[1][2]) {
			if (cBoard[1][0] == 'O') {
				result.oLine++;
			}
			if (cBoard[1][0] == 'X') {
				result.xLine++;
			}
		}

		if (cBoard[2][0] == cBoard[2][1] && cBoard[2][1] == cBoard[2][2]) {
			if (cBoard[2][0] == 'O') {
				result.oLine++;
			}
			if (cBoard[2][0] == 'X') {
				result.xLine++;
			}
		}

		if (cBoard[0][0] == cBoard[1][0] && cBoard[1][0] == cBoard[2][0]) {
			if (cBoard[0][0] == 'O') {
				result.oLine++;
			}
			if (cBoard[0][0] == 'X') {
				result.xLine++;
			}
		}

		if (cBoard[0][1] == cBoard[1][1] && cBoard[1][1] == cBoard[2][1]) {
			if (cBoard[0][1] == 'O') {
				result.oLine++;
			}
			if (cBoard[0][1] == 'X') {
				result.xLine++;
			}
		}

		if (cBoard[0][2] == cBoard[1][2] && cBoard[1][2] == cBoard[2][2]) {
			if (cBoard[0][2] == 'O') {
				result.oLine++;
			}
			if (cBoard[0][2] == 'X') {
				result.xLine++;
			}
		}

		if (cBoard[0][0] == cBoard[1][1] && cBoard[1][1] == cBoard[2][2]) {
			if (cBoard[1][1] == 'O') {
				result.oLine++;
			}
			if (cBoard[1][1] == 'X') {
				result.xLine++;
			}
		}

		if (cBoard[0][2] == cBoard[1][1] && cBoard[1][1] == cBoard[2][0]) {
			if (cBoard[1][1] == 'O') {
				result.oLine++;
			}
			if (cBoard[1][1] == 'X') {
				result.xLine++;
			}
		}

		return result;

	}

	private static class Result {
		int xCount;
		int oCount;
		int xLine;
		int oLine;
	}
}
