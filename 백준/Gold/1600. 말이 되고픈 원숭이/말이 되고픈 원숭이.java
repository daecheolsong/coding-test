import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int [] mvr = {1, -1, 0, 0};
	static int [] mvc = {0, 0, 1, -1};
	static int [] mvhr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int [] mvhc = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[h][w];
		
		for(int i = 0; i < h; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int [][][] v = new int[k+1][h][w];
		
		Queue<int []> q = new LinkedList<>();
		// r c k count
		q.add(new int[] {0, 0, 0, 0});
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			int ck = cur[2];
			int count = cur[3];
			
			if(cr == h - 1 && cc == w - 1) {
				answer = Math.min(answer, count);
				break;
			}
			
			if(count > w * h) {
				answer = -1;
				break;
			}
			if(canHorseMove(ck, k)) {
				for(int i = 0; i < 8; i ++) {
					int nr = cr + mvhr[i];
					int nc = cc + mvhc[i];
					if(isIn(nr ,nc, h, w) && !isWall(nr, nc, map) && v[ck + 1][nr][nc] == 0) {
						v[ck + 1][nr][nc] = 1;
						q.add(new int[] {nr, nc, ck + 1, count + 1});
					}
				}
			}
			for(int i = 0 ; i < 4; i ++) {
				int nr = cr + mvr[i];
				int nc = cc + mvc[i];
				if(isIn(nr ,nc, h, w) && !isWall(nr, nc ,map) && v[ck][nr][nc] == 0) {
					v[ck][nr][nc] = 1;
					q.add(new int[] {nr, nc, ck, count + 1});
				}
			}
		}
		System.out.println(answer == Integer.MAX_VALUE ? -1: answer);
		
	}
	private static boolean canHorseMove(int ck , int k) {
		return ck < k;
	}
	
	private static boolean isWall(int r, int c, int [][] map) {
		return map[r][c] == 1;
	}
	
	private static boolean isIn(int r, int c, int h, int w) {
		return r >= 0 && r < h && c >= 0 && c < w; 
	}
	
}
