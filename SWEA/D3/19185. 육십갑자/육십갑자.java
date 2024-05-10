import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String[] ns = new String[n];
            String[] ms = new String[m];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ns[j] = st.nextToken();
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ms[j] = st.nextToken();
            }
            int q = Integer.parseInt(br.readLine());
            sb.append("#").append(i).append(" ");
            for (int j = 0; j < q; j++) {
                int y = Integer.parseInt(br.readLine());
                int nIdx = y % n == 0 ? n - 1 : y % n - 1;
                int mIdx = y % m == 0 ? m - 1 : y % m - 1;
                sb.append(ns[nIdx]).append(ms[mIdx]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
