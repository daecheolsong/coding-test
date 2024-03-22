import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        int cnt = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }
        
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i < queue2.length; i++) {
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        
        
        while(cnt <= 2 * (queue1.length + queue2.length)) {
                
            if(sum1 < sum2) {
                int pop = q2.poll();
                q1.add(pop);
                sum1 += pop;
                sum2 -= pop;
                cnt++;
            } else if(sum1 > sum2) {
                int pop = q1.poll();
                q2.add(pop);
                sum1 -= pop;
                sum2 += pop;
                cnt++;
            } else {
                return cnt;
            }
            
            
        }
        
        return answer;
    }
}