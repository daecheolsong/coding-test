import java.util.*;

class Solution {

    static int minValue = Integer.MAX_VALUE;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            minValue = Integer.MAX_VALUE;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int [] candies = new int[n];
            for (int i = 0; i < n; i++) {
                candies[i] = sc.nextInt();
            }
            Arrays.sort(candies);
            for (int i = 0; i <= n - k; i++) {
                for (int j = i; j < i + k; j++) {
                    int minV = candies[i];
                    int maxV = candies[i + k - 1];
                    minValue = Math.min(minValue, maxV - minV);
                }
            }

           System.out.println("#" + test_case + " " + minValue);
        }
    }

}