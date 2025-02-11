import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int answer = Integer.MAX_VALUE;
	static int [] mvr = {0, 0, 1, - 1};
	static int [] mvc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = 1;
		int n = Integer.parseInt(br.readLine());
		while(n != 0) {
			answer = Integer.MAX_VALUE;
			sb.append("Problem ").append(tc++).append(": ");
			int [][] map = new int[n][n];
			
			
			for(int i = 0; i < n ; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n ; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}	
			}
		
			sb.append(move(0, 0, n, map[0][0], map)).append("\n");	
			n = Integer.parseInt(br.readLine());
			
		}
		System.out.println(sb);
		
	}
	
	public static int move(int r, int c, int n, int sum, int [][] map) {
		PriorityQueue<int []> pq = new PriorityQueue<>((n1, n2) -> n1[2] - n2[2]);
		int [][] d = new int[n][n];
		for(int i = 0; i < n; i ++) {
			Arrays.fill(d[i], Integer.MAX_VALUE);
		}
		
		d[r][c] = map[r][c];
		pq.add(new int[] {r , c, d[r][c]});
		
		while(!pq.isEmpty()) {
			int [] pos = pq.poll();
			r = pos[0];
			c = pos[1];
			int cost = pos[2];
			if(cost > d[r][c]) {
				continue;
			}
			for(int i = 0; i < 4; i ++) {
				int nr = r + mvr[i];
				int nc = c + mvc[i];
				if(isIn(nr , nc, n)) {
					int temp = map[nr][nc] + cost;
					if(temp < d[nr][nc]) {
						d[nr][nc] = temp;
						pq.add(new int[] {nr ,nc, temp});						
					}
				}
			}
		}
		return d[n- 1][n- 1];
		
	}
	
	private static boolean isIn(int r, int c, int n) {
		return c >= 0 && c < n  && r >= 0 && r < n;
	}
	
}
