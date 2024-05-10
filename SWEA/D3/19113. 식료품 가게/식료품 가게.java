import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= tc; i++) {
            sb.append("#").append(i).append(" ");
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[2 * n];
            long[] check = new long[2 * n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2 * n; j++) {
                arr[j] = Long.parseLong(st.nextToken());
            }
            for (int j = 0; j < 2 * n; j++) {
                if (check[j] == 1) {
                    continue;
                }
                for (int k = j + 1; k < 2 * n ; k++) {
                    if (arr[k] == arr[j] * 4 / 3 && check[k] == 0) {
                        sb.append(arr[j]).append(" ");
                        check[k] = 1;
                        break;
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
