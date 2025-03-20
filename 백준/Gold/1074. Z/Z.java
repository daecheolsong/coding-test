import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] arsg) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int answer = 0;
        while(n > 0) {
            n --;
            int mul =  (int) Math.pow(2, n);
            
            if(r < mul && c < mul) {
                answer += mul* mul * 0;
            } else if(r < mul && c >= mul) {
                answer += mul * mul  * 1;
                c -= mul;
            } else if(r >= mul && c < mul) {
                answer += mul * mul * 2;
                r -= mul;
            } else {
                answer += mul * mul * 3;
                r -= mul;
                c -= mul;
            }
        }
        System.out.println(answer);
    }
}