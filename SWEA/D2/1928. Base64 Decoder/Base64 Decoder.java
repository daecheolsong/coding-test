import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		char[] m = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

		for (int i = 0; i < n; i++) {
			sb.append("#").append(i + 1).append(" ");
			String encodedString = br.readLine();
			int buf = 0;
			int cutIdx = 0;
			for (int j = 0; j < encodedString.length(); j++) {
				char encodedChar = encodedString.charAt(j);
				int mIdx = 0;
				for (int k = 0; k < 64; k++) {
					if (m[k] == encodedChar) {
						mIdx = k;
						break;
					}
				}

				buf = (buf << 6) | mIdx;
				cutIdx += 6;

				if (cutIdx >= 8) {
					cutIdx -= 8;
					char decodeChar = (char) ((buf >> cutIdx) & 0xff);
					sb.append(decodeChar);

				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
