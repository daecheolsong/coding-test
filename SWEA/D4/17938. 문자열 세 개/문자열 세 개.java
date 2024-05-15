import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			String a = "";
			String b = "";
			String c = "";
			for (int i = 0; i < x; i++) {
				a += "0";
				b += "0";
			}

			for (int i = 0; i < y; i++) {
				b += "1";
				c += "1";
			}

			for (int i = 0; i < z; i++) {
				c += "0";
				a += "0";
			}
			sb.append(a).append(" ").append(b).append(" ").append(c).append("\n");

		}
		System.out.println(sb);
	}
}
