import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int tx = Integer.parseInt(st.nextToken());
			int ty = Integer.parseInt(st.nextToken());

			int n = Integer.parseInt(br.readLine());
			int count = 0;

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int rx = Integer.parseInt(st.nextToken());
				int ry = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				int d1 = (int) Math.pow(rx - sx, 2) + (int) Math.pow(ry - sy, 2);
				int d2 = (int) Math.pow(rx - tx, 2) + (int) Math.pow(ry - ty, 2);
				int rr = (int) Math.pow(r, 2);

				if (rr > d1 && rr > d2) {
					continue;
				}

				if (rr > d1) {
					count++;
				} else if (rr > d2) {
					count++;
				}
			}
			bw.write(count + "\n");
			bw.flush();

		}

	}

}
