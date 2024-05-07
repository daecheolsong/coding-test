
import java.util.Scanner;


class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            char[][] m = new char[n][n];
            for (int i = 0; i < n; i++) {
                m[i] = sc.next().toCharArray();
            }

            System.out.println("#" + tc + (isPossible(m, n) ? " YES" : " NO"));
        }

    }

    public static boolean isPossible(char[][] m, int n) {
        for (int i = 0; i <= 100_000; i++) {
            if (isKExist(m, n, i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isKExist(char[][] m, int n, int k) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (gcd(i + 1 + k, j + 1 + k) == 1) {
                        if (m[i][j] != '1') {
                            return false;
                        }
                    } else {
                        if (m[i][j] != '?') {
                            return false;
                        }
                    }
                }
            }
        return true;
    }


    public static int gcd(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}