import java.util.*;
import java.io.*;

public class Main {
    
   public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int rep = 1 << n;

		int mot = 1;

		for (int i = n; i > n - m; i--) {
			mot *= i;
		}

		int bro = 1;
		for (int i = 1; i <= m; i++) {
			bro *= i;
		}
		String[] cases = new String[mot / bro];
		int sIdx = 0;
		for (int i = 1; i < rep; i++) {
			int bitCount = 0;
			int temp = i;
			while (temp > 0) {
				if (temp % 2 == 1) {
					bitCount++;
				}
				temp = temp >> 1;
			}

			if (bitCount == m) {
				StringBuilder sb = new StringBuilder();
				temp = i;
				int idx = 1;
				int pIdx = 0;
				while (temp > 0) {
					if ((temp & 1) == 1) {
						sb.append(idx).append(" ");
					}
					temp = temp >> 1;
					idx++;
				}
				cases[sIdx++] = sb.toString();
			}
		}

		Arrays.sort(cases);

		for (int i = 0; i < cases.length; i++) {
			System.out.println(cases[i]);
		}
	}
}