import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int tc = 1; tc <= t; tc ++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String [] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = br.readLine();
            }
            int pL = 0;
            int concatPL = 0;
            for(int i = 0; i < n ; i ++) {
                String src = strings[i];
                if(isP(src)) {
                    pL = m;
                    continue;
                }
                for(int j = i + 1; j < n; j ++) {
                    String target = strings[j];
                    if (src.equals(reverse(sb2, target))) {
                        concatPL += 2 * m;
                    }
                }
            }
            sb.append(pL + concatPL);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static String reverse(StringBuilder sb, String string) {
        sb.setLength(0);
        return sb.append(string).reverse().toString();
    }

    public static boolean isP(String string) {
        char[] chars = string.toCharArray();
        int mid = string.length() / 2;
        for (int i = 0; i <= mid; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
