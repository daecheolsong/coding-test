import java.util.*;

class Solution {

    public static int MAX_TMR = 50;
    public static int INITIAL = Integer.MAX_VALUE / 2;
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int answer = Integer.MAX_VALUE;

        // 0 ~ 50
        temperature += 10;
        t1 += 10;
        t2 += 10;

        int dt = temperature < t1 ? 1 : -1;

        int[][] dp = new int[MAX_TMR + 1][onboard.length + 1];

        for (int i = 0; i <= MAX_TMR; i++) {
            Arrays.fill(dp[i], INITIAL);
        }

        dp[temperature][0] = 0;

        int s = Math.min(t1, temperature);
        int e = Math.max(t2, temperature);

        for (int i = 0; i < onboard.length; i++) {
            int minTmr = s;
            int maxTmr = e;

            if (onboard[i] == 1) {
                minTmr = t1;
                maxTmr = t2;
            }
            for (int j = minTmr; j <= maxTmr; j++) {

                // on
                int nextTmr = j + dt;
                if (isIn(nextTmr)) {
                    dp[nextTmr][i + 1] = Math.min(dp[nextTmr][i + 1], dp[j][i] + a);
                }

                if (j != temperature) {
                    dp[j][i + 1] = Math.min(dp[j][i + 1], dp[j][i] + b);
                } else {
                    dp[j][i + 1] = Math.min(dp[j][i + 1], dp[j][i]);
                }

                // off
                nextTmr = j - dt;
                if (isIn(nextTmr)) {
                    dp[nextTmr][i + 1] = Math.min(dp[nextTmr][i + 1], dp[j][i]);
                }
            }
        }

        for (int i = s; i <= e; i++) {
            answer = Math.min(answer, dp[i][onboard.length]);
        }

        return answer;
    }

    public boolean isIn(int nt) {
        return nt >= 0 && nt <= MAX_TMR;
    }
}