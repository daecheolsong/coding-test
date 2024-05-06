import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (b <= 1 || c <= 2) {
                System.out.println("#" + test_case + " -1");
                continue;
            }
            int answer = 0;
            if(b >= c) {
                answer += b - c + 1;
                b = c - 1;
            }

            if(a >= b) {
                answer += a - b + 1;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}