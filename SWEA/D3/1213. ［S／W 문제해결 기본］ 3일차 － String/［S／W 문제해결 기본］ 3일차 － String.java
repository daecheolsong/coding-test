import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 10; i++) {
			sb.append("#").append(br.readLine()).append(" ");

			String src = br.readLine();
			String target = br.readLine();

			int count = 0;

			for (int j = 0; j <= target.length() - src.length(); j++) {
				if (target.substring(j, j + src.length()).equals(src)) {
					count++;
				}
			}
			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}

}
