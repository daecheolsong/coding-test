import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());

			char[][] m = new char[8][8];

			for (int i = 0; i < 8; i++) {
				m[i] = br.readLine().toCharArray();
			}

			int answer = 0;

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - n; j++) {
					StringBuilder s = new StringBuilder();
					for (int k = j; k < j + n; k++) {
						s.append(m[i][k]);
					}
					if (isPalindrome(s.toString())) {
						answer++;
					}
				}
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - n; j++) {
					StringBuilder s = new StringBuilder();
					for (int k = j; k < j + n; k++) {
						s.append(m[k][i]);
					}
					if (isPalindrome(s.toString())) {
						answer++;
					}
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb);

	}

	public static boolean isPalindrome(String s) {

		int mid = s.length() / 2;

		for (int i = 0; i < mid; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

}