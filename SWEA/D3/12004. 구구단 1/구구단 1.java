import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");

			boolean able = false;
			int n = Integer.parseInt(br.readLine());

			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					if (i * j == n) {
						able = true;
						break;
					}
				}
			}
			sb.append(able ? "Yes\n" : "No\n");
		}
		System.out.println(sb);

	}
}