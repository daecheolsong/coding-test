import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");

			long answer = Long.MAX_VALUE;

			long n = Long.parseLong(br.readLine());

			for (int i = 1; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					long j = n / i;
					answer = Math.min(j - 1 + i - 1, answer);
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);

	}
}