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

public class Solution {
	static int [] mvr = {0, 0, 1, - 1};
	static int [] mvc = {1, -1, 0, 0};
	static int minVal = Integer.MAX_VALUE;
	static int maxCore = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; tc ++) {
			minVal = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			
			int [][] map = new int[n][n];
			
			for(int i = 0 ; i < n; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			List<int []> list =new ArrayList<>();
			
			for(int i = 0; i < n; i ++) {
				for(int j = 0; j < n; j ++) {
					if(!isEdge(i, j, n) && map[i][j] == 1) {
						list.add(new int[] {i, j});
					}
					
				}
			}
			
			connect(list, 0, 0, n, list.size(), map, 0);
			sb.append(minVal).append("\n");
		}
		System.out.println(sb);
	}
	
	
	private static void connect(List<int[]> list, int curSum, int depth, int n, int maxDepth, int [][] map, int coreCnt) {
		if(depth == maxDepth) {
			if(maxCore < coreCnt) {
				maxCore = coreCnt;
				minVal = curSum;
			} else if(maxCore == coreCnt) {
				minVal = Math.min(minVal, curSum);		
			}
			return;
		}
		
		
		int r = list.get(depth)[0];
		int c = list.get(depth)[1];
		
		for(int i = 0; i < 4; i ++) {
			int sr = r + mvr[i];
			int sc = c + mvc[i];
			int count = 0;
			while(true) {
				if(!isIn(sr, sc, n)) {
					break;
				}
				if(map[sr][sc] == 1) {
					count = 0;
					break;
				}
				count++;
				sr = sr + mvr[i];
				sc = sc + mvc[i];
			}
			
			int fr = r;
			int fc = c;
			
			for(int k = 0; k < count; k ++) {
				fr = fr + mvr[i];
				fc = fc + mvc[i];
				map[fr][fc] = 1;
			}
			
			if(count == 0) {
				connect(list, curSum, depth + 1, n, list.size(), map, coreCnt);
			} else {
				connect(list, curSum + count, depth + 1, n, list.size(), map, coreCnt + 1);
				fr = r;
				fc = c;
				for(int k = 0; k < count; k ++) {
					fr = fr + mvr[i];
					fc = fc + mvc[i];
					map[fr][fc] = 0;
				}
			}
			
		}
	}
	
	
	private static boolean isIn(int r, int c, int n) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
	
	private static boolean isEdge(int r, int c, int n) {
		return r == 0 || c == 0 || r == n - 1 || c == n - 1;
	}
}
