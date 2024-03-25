import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
  
  
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        
        for(int i = 1; i <= order.length; i++) {
            q.add(i);
        }
        
        int pIdx = 0;
        
        while(!q.isEmpty() || !s.isEmpty()) {
            if(q.isEmpty()) {
                while(!s.isEmpty()) {
                    int find = s.pop();
                    if(find == order[pIdx]) {
                        pIdx++;
                        answer++;
                    } else {
                        break;
                    }
                }
                break;
            }
            
            int cur = q.peek();
            
            while(cur < order[pIdx]) {
                s.push(q.poll());
                cur = q.peek();
            }
            
            if(cur == order[pIdx]) {
                answer++;
                pIdx++;
                q.poll();
            } else {
                int find = s.pop();
                if(find == order[pIdx]) {
                    answer++;
                    pIdx++;
                } else {
                    break;
                }
            }
        }
              
      
        return answer;
    }
}