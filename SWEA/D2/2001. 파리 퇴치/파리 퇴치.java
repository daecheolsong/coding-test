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
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int [][] map = new int[n][n];

            for(int i = 0; i < n ; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxX = n - m;
            int maxY = n - m;

            int maxValue = 0;

            for(int i = 0; i <= maxY; i ++) {
                for (int j = 0; j <= maxX; j++) {
                    int sum = 0;
                    for(int k = i; k < i + m; k++) {
                        for (int l = j; l < j + m; l++) {
                            sum += map[k][l];
                        }
                    }
                    maxValue = Math.max(maxValue, sum);
                }
            }
            sb.append(maxValue);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
