import java.io.*;
import java.util.*;

class Solution {
    public static int diff = Integer.MAX_VALUE;
    
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb  = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
        	StringTokenizer st= new StringTokenizer(br.readLine());
            sb.append("#").append(i+1).append(" ");
            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[] arr =  new int[N];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
            	arr[j] = Integer.parseInt(st.nextToken());
            }
            diff = Integer.MAX_VALUE;
            for(int j = 1; j <=N; j++) {
            	int [] v= new int[N];
                dfs(v, j, 0, arr, 0, B);
            }
            sb.append(diff).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
    
    public static void dfs(int[] v, int k, int next, int[] arr, int depth, int B) {
        if(depth == k) {
            int sum = 0;
            for(int i = 0; i < arr.length; i ++) {
            	if(v[i] == 1) {
                    sum += arr[i];
                }
            }
            if(sum < B) {
                return;
            }
            diff = Math.min(diff, sum - B);
            return;
        }
        
        for(int i = next; i < arr.length; i++) {
            v[i] = 1;
            dfs(v, k, i+1, arr, depth+1, B);
            v[i] = 0;
        }
        
    }
}