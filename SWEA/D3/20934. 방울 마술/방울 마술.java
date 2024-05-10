import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= tc; i++) {
            sb.append("#").append(i).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String balls = st.nextToken();
            int cur = 0;
            for (int j = 0; j < balls.length(); j++) {
                if (balls.charAt(j) == 'o') {
                    cur = j;
                    break;
                }
            }

            int count = Integer.parseInt(st.nextToken());

            while (count-- > 0) {
                if (cur == 2) {
                    cur = 1;
                    continue;
                }
                if (cur == 1) {
                    cur = 0;
                    continue;
                }
                if (cur == 0) {
                    cur = 1;
                }
            }
            sb.append(cur);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
