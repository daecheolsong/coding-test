import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());

			// x - y = n

			for (int i = 1; i <= 1_000_000_000; i++) {
				int j = i - n;
				if (j < 1) {
					continue;
				}
				if (!isPrime(i) && !isPrime(j)) {
					sb.append(i).append(" ").append(j).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}

	public static boolean isPrime(int n) {

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;

	}
}
