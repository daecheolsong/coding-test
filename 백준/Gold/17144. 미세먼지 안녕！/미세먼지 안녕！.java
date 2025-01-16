import java.io.*;
import java.util.*;

public class Main {

	private static int SPREAD_CNT = 5;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		
		int [][] map = new int[r][c];
		int cnt = 0;
		
		int airPurifierR = -1;
		
		for(int i = 0; i < r; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					airPurifierR = i;
				}
			}
		}
		
		int fR = airPurifierR - 1;
		
		while(t-- > 0) {
			int [][] updateMap = new int[r][c];	
			diffusion(map, updateMap);
			
			Queue<Integer> q1 = new LinkedList<>();
			
			for(int i = 1; i < c; i++) {
				q1.add(map[fR][i]);
			}
			
			for(int i = fR - 1; i > 0; i --) {
				q1.add(map[i][c - 1]);
			}
			
			for(int i = c - 1; i >= 0; i --) {
				q1.add(map[0][i]);
			}
			
			for(int i = 1; i < fR; i ++) {
				q1.add(map[i][0]);
			}
			map[fR][1] = 0;
			
			//
			for(int i = 2; i < c; i++) {
				map[fR][i] = q1.poll();
			}
			
			for(int i = fR - 1; i > 0; i --) {
				map[i][c - 1] = q1.poll();
			}
			
			for(int i = c - 1; i >= 0; i --) {
				map[0][i] = q1.poll();
			}
			
			for(int i = 1; i < fR; i ++) {
				map[i][0] = q1.poll();
			}
			
			
			Queue<Integer> q2 = new LinkedList<>();
			
			for(int i = 1; i < c; i++) {
				q2.add(map[fR + 1][i]);
			}
			
			for(int i = fR + 2; i < r; i ++) {
				q2.add(map[i][c - 1]);
			}
			
			for(int i = c - 2; i > 0; i --) {
				q2.add(map[r - 1][i]);
			}
			
			for(int i = r - 1; i > fR + 1; i --) {
				q2.add(map[i][0]);
			}
			
			map[fR + 1][1] = 0;
			
			for(int i = 2; i < c; i++) {
				map[fR + 1][i] = q2.poll();
			}
			
			for(int i = fR + 2; i < r; i ++) {
				map[i][c - 1] = q2.poll();
			}
			
			for(int i = c - 2; i > 0; i --) {
				map[r - 1][i] = q2.poll();
			}
			
			for(int i = r - 1; i > fR + 1; i --) {
				map[i][0] = q2.poll();
			}
			
			
			
		}
		
		
		for(int i = 0; i < map.length; i ++) {
			for(int j = 0; j < map[i].length; j ++) {
				if(map[i][j] > 0) {
					cnt += map[i][j];
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	
	public static void diffusion(int[][] map, int[][] updateMap) {
		for(int i = 0; i < map.length; i ++) {
			for(int j = 0; j < map[i].length; j ++) {
				if(map[i][j] <= 0 ) {
					continue;
				}
				spread(map, updateMap, i, j);
			}
		}
		
		for(int i = 0; i < map.length; i ++) {
			for(int j = 0; j < map[i].length; j ++) {
				map[i][j] += updateMap[i][j];
			}
		}
		
	}
	
	private static void spread(int[][] map, int[][] updateMap, int r, int c) {
		int [] mvr = {-1, 1, 0, 0};
		int [] mvc = {0, 0, 1, -1};
		
		int total = map[r][c];
		int spreadAmount = total / SPREAD_CNT;
		int spreadCnt = 0;
		
		for(int i = 0; i < 4; i ++) {
			int nr = r + mvr[i];
			int nc = c + mvc[i];
			if(isIn(map, nr, nc)) {
				if(map[nr][nc] == -1) {
					continue;
				}
				updateMap[nr][nc] += spreadAmount;
				spreadCnt ++;
			}
		}
		updateMap[r][c] -= spreadCnt * spreadAmount;
		
	}
	
	private static boolean isIn(int[][] map, int r, int c) {
		return r >= 0 && r < map.length && c >= 0 && c < map[0].length;
	}
}