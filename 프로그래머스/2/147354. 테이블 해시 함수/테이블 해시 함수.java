import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (arr1, arr2) -> arr1[col - 1] - arr2[col - 1] == 0 ? arr2[0] - arr1[0] : arr1[col - 1] - arr2[col - 1]);
        
        for(int i = row_begin; i <= row_end ; i ++) {
            int resSum = 0;
            for(int j = 0; j < data[0].length; j ++) {
                resSum += data[i - 1][j] % i;
            }
            answer ^= resSum;
        }
        return answer;
    }
}