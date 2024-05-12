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

			// 홀 -> 짝 홀 -> 홀 홀 홀
			// 짝 -> 짝 짝 -> 홀 홀 짝 -> 홀 홀 홀 홀
			sb.append(n % 2 == 0 ? "Alice" : "Bob").append("\n");
		}
		System.out.println(sb);
	}

}
