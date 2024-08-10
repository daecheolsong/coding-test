import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 1;
        int [] v = new int[cards.length + 1];
        List<Integer> g = new ArrayList<>();
        
        for(int i = 0; i < cards.length; i ++) {            
            if(v[cards[i]] == 1) {
                continue;
            }
            v[cards[i]] = 1;
            
            Queue<Integer> q = new LinkedList<>();
            q.add(cards[i]);
            
            int count = 1;
            while(true) {
                int c = q.poll();
                if(v[cards[c - 1]] == 1) {
                    break;
                }
                v[cards[c - 1]] = 1;
                q.add(cards[c - 1]);
                count++;
            }
            g.add(count);
        }
        
        if(g.size() == 1) {
            return 0;
        }
        Collections.sort(g, (s1, s2) -> s2 - s1);
        
        for(int i = 0; i < 2; i ++) {
            answer *= g.get(i);
        }
        return answer;
    }
}