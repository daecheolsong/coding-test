import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int [] dp = new int[n + 1];
        Arrays.fill(dp, 100_000_00);
        dp[0] = 0;
        for(int i = 2; i <= n; i++) {
            if(i >= 2) {
                dp[i] = Math.min(dp[i - 2], dp[i]);
            }
            if(i >= 5) {
                dp[i] = Math.min(dp[i - 5], dp[i]);
            }
            dp[i] += 1;
        }
      
        if(dp[n] >= 100_000_00) {
            bw.write("-1\n");
            bw.flush();
            return;
        }
        bw.write(dp[n] + "\n");
        bw.flush();
    }
}