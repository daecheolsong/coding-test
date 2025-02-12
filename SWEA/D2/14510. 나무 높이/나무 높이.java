import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc ++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			
			int [] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			int maxHeight = 0;
		
			for(int i = 0; i < n; i ++) {
				arr[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, arr[i]);
			}
			
			int sum = 0;
			int requireOdd = 0; // 실제 홀수의 개수, 홀수가 존재하면 그 개수만큼 홀수날이 필요합니다.
			for(int i = 0; i < n ; i ++) {
				if(arr[i] > 0) {
					int diff = Math.abs(maxHeight - arr[i]);
					sum += diff; 
					if(diff % 2 == 1) {
						requireOdd ++;
					}
				}
			}
	
			int answer = 0;
			int idle = (sum / 3) * 2 + sum % 3;
	
			int idleOdd = idle / 2 + idle % 2;
			
			if(requireOdd <= idleOdd) {
				answer = idle;
			} else {
				answer = requireOdd * 2 - 1;
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		
	}
	
}
