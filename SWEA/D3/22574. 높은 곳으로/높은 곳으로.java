import java.util.*;
import java.io.*;
class Solution
{
	 public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            int answer = 0;
            for(int j = 1; j <= n; j ++) {
                answer += j;
                if(answer == p) {
                    answer -= 1;
                }
            }
            System.out.println(answer);
        }
        
    }
}