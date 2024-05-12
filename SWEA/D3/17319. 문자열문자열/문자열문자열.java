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
			String s = br.readLine();
			if (n % 2 != 0) {
				sb.append("No").append("\n");
				continue;
			}

			String left = s.substring(0, s.length() / 2);
			String right = s.substring(s.length() / 2);

			sb.append(left.equals(right) ? "Yes\n" : "No\n");

		}
		System.out.println(sb);
	}

}
