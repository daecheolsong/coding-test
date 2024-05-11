import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc ++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if(a > b) {
                sb.append("-1\n");
                continue;
            }
            if(a == b) {
                sb.append("0\n");
                continue;
            }
            long diff = b - a;
            if (b - a == 1) {
                sb.append("-1\n");
                continue;
            }
            if (b - a <= 3) {
                sb.append("1\n");
                continue;
            }
            sb.append(diff / 2);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
