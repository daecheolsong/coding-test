import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int [] f = new int[10_000_001];
        
        for(int t : tangerine) {
            f[t] ++;
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= 10_000_000; i ++) {
            if(f[i] > 0) {
                list.add(i);
            }
        }
        
        Collections.sort(list, (l1, l2) -> f[l2] - f[l1]);
        
        int answer = 0;
        for(int i : list) {
            k -= f[i];
            answer++;
            if(k <= 0) {
                break;
            }
        }
        
        return answer;
    }
}