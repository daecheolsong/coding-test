import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += Integer.parseInt(st.nextToken());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ").append((int) Math.round(sum / 10.0));
            System.out.println(sb);
        }
    }

}