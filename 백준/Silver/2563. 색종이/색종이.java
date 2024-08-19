import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int [][] m = new int[101][101];
        
        int cnt = 0;
        for(int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            for(int j = x; j < x + 10; j ++) {
                for(int k = y; k < y + 10; k ++) {
                    m[k][j] = 1;
                }
            }
        }
        
        for(int i = 0; i < 101; i ++) {
            for(int j = 0; j < 101; j ++) {
                if(m[i][j] == 1) {
                    cnt ++;
                }
            }
        }
        
        bw.write(cnt+"\n");
        bw.flush();
        
        
    }
}