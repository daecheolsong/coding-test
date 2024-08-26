/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String [] kPos = st.nextToken().split("");

		int kX = (int) (kPos[0].charAt(0) - 'A') + 1;
		int kY = Integer.parseInt(kPos[1]);

		String [] rPos = st.nextToken().split("");
		int rX = (int) (rPos[0].charAt(0) - 'A') + 1;
		int rY = Integer.parseInt(rPos[1]);

		int n = Integer.parseInt(st.nextToken());


		for(int i = 0; i < n ; i++) {
			String next = br.readLine();
			int dy = 0;
    		int dx = 0;

			if(next.equals("R")) {
				dx += 1;
			}

			if(next.equals("L")) {
				dx -= 1;
			}

			if(next.equals("B")) {
				dy -= 1;
			}
			if(next.equals("T")) {
				dy += 1;
			}

			if(next.equals("RT")) {
				dx += 1;
				dy += 1;
			}

			if(next.equals("LT")) {
				dx -= 1;
				dy += 1;
			}
			if(next.equals("RB")) {
				dx += 1;
				dy -= 1;
			}
			if(next.equals("LB")) {
				dx -= 1;
				dy -= 1;
			}
			int nkX = kX + dx;
			int nkY = kY + dy;

			if(!isIn(nkY, nkX)) {
				continue;
			}
			int nrX = rX + dx;
			int nrY = rY + dy;
			
			if(nkX == rX && nkY == rY) {
				if(!isIn(nrY, nrX)) {
				    continue;
				}
				rX = nrX;
				rY = nrY;
			}
			
		
			kX = nkX;
			kY = nkY;
			

		}
			StringBuilder sb = new StringBuilder();
			sb.append((char)(kX + 'A' - 1)).append(kY).append("\n")
			.append((char)(rX + 'A' - 1)).append(rY).append("\n");
			bw.write(sb.toString());
			bw.flush();

	}

	public static boolean isIn(int y, int x) {
		return x > 0 && x <= 8 && y > 0 && y <= 8;
	}
}