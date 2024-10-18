import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int a = -2;
        int l = 0;
        for(int i = L; i <= 100; i ++) {
            if((2 * N - i * i - i) % (2 * i) == 0) {
                a = (2 * N - i * i - i) / (2 * i);
                l = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
       
        if(a < -1) {
            bw.write(-1 + "\n");
        } else {
            for(int i = 1; i <= l ; i ++) {
                sb.append((a + i) + " ");
            }
            sb.append("\n");
            bw.write(sb.toString());
        }     
        bw.flush();
        
    }
}