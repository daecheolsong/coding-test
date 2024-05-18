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

			int answer = 1;
			for (int i = 1; i * i <= n; i++) {
				if (n % (i * i) == 0) {
					answer = n / (i * i);
				}
			}
			sb.append(answer).append("\n");
		}

		System.out.println(sb);

	}
}