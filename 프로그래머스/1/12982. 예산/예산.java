import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int idx = 0;
        while(budget > 0 && idx < d.length) {
            if(budget < d[idx]) {
                break;
            }
            budget -= d[idx++];
        }
        if(idx == d.length) {
            return idx;
        }
        return budget < 0 ? idx - 1 : idx;
    }
}