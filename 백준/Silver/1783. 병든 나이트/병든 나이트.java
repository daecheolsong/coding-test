import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        if(n == 1) {
            System.out.println(1);
            return;
        }
        if(n == 2) {
            System.out.println(Math.min((m + 1) / 2, 4));
            return;
        }
        if(m < 7) {
            System.out.println(Math.min(m, 4));
            return;
        }
        System.out.println(m - 7 + 5);
                          
    }
}