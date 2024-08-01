import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        long [] arr = new long[1000001];
        
        int answer = 0;
        for(long i = 2; i <= Math.sqrt(max); i ++) {
            long j = (min - 1 + i * i) / (i * i) * (i * i);
            while(j <= max) {
                arr[(int)(j - min)] = 1;
                j += i * i;
            }
        }
        
        for(long i = min; i <= max; i ++) {
            if(arr[(int)(i - min)] == 0) {
                answer++;
            }
        }
        bw.write(answer+"\n");
        bw.flush();
                
    }
}