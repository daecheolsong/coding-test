import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] arsg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t ; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int dist = (int) Math.pow(x1 - x2 , 2) + (int) Math.pow(y1 - y2 , 2);
            if(x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append("-1\n");
            } else if(dist == (int) Math.pow(r1 - r2 ,2) || dist == (int) Math.pow(r1 + r2 , 2)) {
                sb.append("1\n");
            } else if(dist < (int) Math.pow(r1 - r2, 2) || dist > (int) Math.pow(r1 + r2 , 2)) {
                sb.append("0\n");
            } else {
                sb.append("2\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}