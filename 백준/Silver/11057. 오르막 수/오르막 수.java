import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int [][] dp = new int[n + 1][10];
        Arrays.fill(dp[1], 1);
        
        for(int i = 2; i <= n ; i++) {
            for(int j = 0; j <= 9; j ++) {
               for(int k = j ; k <= 9; k ++) {
                   dp[i][j] = (dp[i][j] % 10007 + dp[i - 1][k] % 10007) % 10007;
               } 
            }
        }
        int sum = 0;
        for(int i = 0; i <= 9; i ++) {
            sum += dp[n][i];
            sum %= 10007;
        }
        bw.write(sum + "\n");
        bw.flush();
    }    
}