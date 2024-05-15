import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			int result = 0;

			for (int i = 1; i < n; i++) {
				int d = (int) Math.sqrt(n * n - i * i);
				if (d >= 1) {
					result += 4 * d;
				}
			}

			result += 4 * n;
			result += 1;
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
