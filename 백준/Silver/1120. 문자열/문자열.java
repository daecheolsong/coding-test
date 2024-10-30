import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] arsg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] a = st.nextToken().toCharArray();
		char[] b = st.nextToken().toCharArray();

		int an = a.length;
		int bn = b.length;
		int answer = an;

		for (int i = 0; i <= bn - an; i++) {
			int cnt = 0;
			for (int j = i; j < i + an; j++) {
				if (a[j - i] != b[j]) {
					cnt++;
				}
			}
			answer = Math.min(answer, cnt);
		}
		bw.write(answer + "\n");
		bw.flush();

	}
}