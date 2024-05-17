import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			answer = 0;
			int n = Integer.parseInt(br.readLine());
			int[] board = new int[n];
			dfs(board, 0);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int[] board, int depth) {

		if (depth == board.length) {
			answer++;
			return;
		}

		for (int i = 0; i < board.length; i++) {
			boolean flag = true;
			for (int j = 0; j < depth; j++) {
				if (board[j] == i || Math.abs(j - depth) == Math.abs(board[j] - i)) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				continue;
			}
			board[depth] = i;
			dfs(board, depth + 1);
		}

	}
}