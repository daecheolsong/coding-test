import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int idx = 0;
        int [] minIdxs = new int[26];
        
        Arrays.fill(minIdxs, Integer.MAX_VALUE);
        
        for(int i = 0 ; i < keymap.length; i ++) {
            String key = keymap[i];
            for(int j = 0; j < key.length(); j ++) {
                char c = key.charAt(j);
                minIdxs[c - 'A'] = Math.min(minIdxs[c - 'A'], j + 1);
            }
        }
        
        for(String target : targets) {
            for(int i = 0; i < target.length(); i ++) {
                char c = target.charAt(i);
                if(minIdxs[c - 'A'] == Integer.MAX_VALUE) {
                    answer[idx] = -1;
                    break;
                }
                answer[idx] += minIdxs[c - 'A'];
            }
            idx++;
        }
        
        
        return answer;
    }
    
}