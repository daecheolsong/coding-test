import java.util.Scanner;


class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] table = new int[1051][1051];

        for (int i = 1; i <= 1050; i++) {
            for (int j = i; j <= 1050; j++) {
                if (gcd(i, j) == 1) {
                    table[i][j] = 1;
                    table[j][i] = 1;
                }
            }
        }

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            char[][] m = new char[n][n];
            for (int i = 0; i < n; i++) {
                m[i] = sc.next().toCharArray();
            }

            System.out.println("#" + tc + (isPossible(m, n, table) ? " YES" : " NO"));
        }

    }

    public static boolean isPossible(char[][] m, int n, int[][] table) {
        for (int i = 0; i <= 1000; i++) {
            if (isKExist(m, n, i, table)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isKExist(char[][] m, int n, int k, int [][] table) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (table[i + 1 + k][j + 1 + k] == 1) {
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