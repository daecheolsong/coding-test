import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int [] mvr = {0, 0, 1, - 1};
	static int [] mvc = {1, -1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		int [][] map = new int[n][m];
		int time = 0;
		
		for(int i = 0; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int []> clearQ = new LinkedList<>();
		
		while(!isAllClear(map, n, m)) {
			fillOuter(map, n, m);
			
			for(int i = 0; i < n; i ++) {
				for(int j = 0; j < m ; j ++) {
					if(map[i][j] == 1) {
						if(isShouldMelt(i, j, n, m, map)) {
							clearQ.add(new int[] {i, j});
						}
					}
				}
			}
			clearCheese(map, clearQ, n, m);
			time++;
			
		}
		
		System.out.println(time);
	}
	
	private static void fillOuter(int [][] map, int n, int m) {
		
		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		int [][] v = new int[n][m];

		while(!q.isEmpty()) {
			int [] pos = q.poll();
			int r = pos[0];
			int c = pos[1];
			
			for(int i = 0; i < 4; i ++) {
				int cr = r + mvr[i];
				int cc = c + mvc[i];
				
				if(isIn(cr, cc, n, m) && v[cr][cc] == 0 && map[cr][cc] != 1) {
					v[cr][cc] = 1;
					map[cr][cc] = 3;
					q.add(new int[] {cr ,cc});
				}
			}	
		}
		
	}
	
	private static boolean isAllClear(int [][] map, int n, int m) {
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m ; j++) {
				if(map[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static void clearCheese(int [][] map, Queue<int[]> clearQ, int n, int m) {
		while(!clearQ.isEmpty()) {
			int [] pos = clearQ.poll();
			map[pos[0]][pos[1]] = 3;
		}
	}
	
	
	private static boolean isShouldMelt(int r, int c, int n, int m, int [][] map) {
		
		int surfaceCnt = 0;
		
		for(int i = 0; i < 4; i ++) {
			int cr = r + mvr[i];
			int cc = c + mvc[i];
			if(isIn(cr, cc, n, m) && map[cr][cc] == 3) {
				surfaceCnt ++;
			}
		}
		if(surfaceCnt >= 2) {
			return true;
		}
		return false;
	}
	
	private static boolean isIn(int r, int c, int n, int m) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}
	
	
}
