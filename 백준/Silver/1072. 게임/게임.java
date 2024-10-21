import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] arsg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        int answer = - 1;
        int Z = (int) (Y * 100 / X);
        bw.write((Z < 99 ? (int) Math.ceil((100 * Y - X * (Z + 1)) / (double) (Z - 99)) : -1) + "\n");
        bw.flush();
    }
}