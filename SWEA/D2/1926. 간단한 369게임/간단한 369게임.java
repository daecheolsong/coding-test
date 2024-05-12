import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String cur = String.valueOf(i + 1);
			if (!cur.contains("3") && !cur.contains("6") && !cur.contains("9")) {
				sb.append(cur).append(" ");
				continue;
			}

			for (int j = 0; j < cur.length(); j++) {
				if (cur.charAt(j) == '3' || cur.charAt(j) == '6' || cur.charAt(j) == '9') {
					sb.append('-');
				}
			}
			sb.append(" ");
		}
		System.out.println(sb);

	}

}