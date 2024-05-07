import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            String s = sc.next();
            // 3 -> 1 ,4 -> 2, 5 -> 2, 6 -> 3
            // 0 1 2 3 4
            // 0 1 2 3
            // (n - 1) / 2
            String left = s.substring(0, s.length() / 2);
            int rightIdx = s.length() % 2 == 0 ? s.length() / 2 : s.length() / 2 + 1;
            String right = s.substring(rightIdx);
            String result;
            if (isP(left) && left.equals(right)) {
                result = "YES";
            } else {
                result = "NO";
            }
            System.out.println("#" + tc + " " + result);
        }
    }

    public static boolean isP(String str) {
        int s = 0;
        int e = str.length() - 1;

        while(s < e) {
            if(str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}