import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        
        for(int i = 0 ; i < enemy.length; i ++) {
            
            if(k > 0) {
                pq.add(enemy[i]);
                k--;
            } else {
                int pt = enemy[i];
                
                
                if(pq.peek() < enemy[i]) {
                    pt = pq.poll();
                    pq.add(enemy[i]);
                }
                
                
                if(n >= pt) {
                    n-=pt;
                } else {
                    break;
                }
                
            }
            answer++;
        }

        
        
        return answer;
    }
}