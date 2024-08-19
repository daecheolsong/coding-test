import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long x = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        for(int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long cost = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());
            sum += cost;
        }
       if(x == sum) {
           bw.write("Yes\n");
       } else {
           bw.write("No\n");
       }
        bw.flush();
    } 
}