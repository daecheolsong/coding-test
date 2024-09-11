import java.util.*;	
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int s = 1;
        int e = s;
        
        for(int i = 0 ; i < diffs.length; i ++) {
            e = Math.max(e, diffs[i]);
        }
        
        while(s < e) {
            int mid = (s + e) / 2;
            long cost = 0;
            for(int i = 0; i < diffs.length; i ++) {
                cost += mid < diffs[i] ? (diffs[i] - mid) * (times[i] + times[i-1]) + times[i]: times[i];
            }
            if(limit >= cost) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        
        return s;
    }
}