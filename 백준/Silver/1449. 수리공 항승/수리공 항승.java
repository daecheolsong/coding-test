import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] p = new int[1001];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			p[Integer.parseInt(st.nextToken())] = 1;
		}
		int answer = 0;
		for (int i = 0; i < p.length; i++) {
			if (p[i] == 1) {
				int end = Math.min(p.length, i + l);
				for (int j = i; j < end; j++) {
					p[j] = 0;
				}
				answer++;
			}
		}
		System.out.println(answer);

	}
}
