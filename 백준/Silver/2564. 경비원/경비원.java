import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int offset = Integer.parseInt(st.nextToken());
		int answer = 0;
		for (int i = 0; i < n; i++) {
			int nd = arr[i][0];
			int nOffset = arr[i][1];
			if (d == 1 || d == 2) {
				if (nd == 3) {
					answer += offset;
					answer += d == 1 ? nOffset : r - nOffset;
				} else if (nd == 4) {
					answer += (c - offset);
					answer += d == 1 ? nOffset : r - nOffset;
				} else if (nd == d) {
					answer += Math.abs(nOffset - offset);
				} else {
					answer += Math.min(offset + r + nOffset, c - offset + r + c - nOffset);
				}
			} else {
				if (nd == 1) {
					answer += offset;
					answer += d == 3 ? nOffset : r - nOffset;
				} else if (nd == 2) {
					answer += (c - offset);
					answer += d == 3 ? nOffset : r - nOffset;
				} else if (nd == d) {
					answer += Math.abs(nOffset - offset);
				} else {
					answer += Math.min(offset + c + nOffset, r - offset + c + r - nOffset);
				}
			}

		}
		System.out.println(answer);
	}
}