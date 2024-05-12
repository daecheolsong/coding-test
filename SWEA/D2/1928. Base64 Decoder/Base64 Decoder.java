import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ").append(new String(Base64.getDecoder().decode(br.readLine())))
					.append("\n");
		}
		System.out.println(sb);
	}

}
