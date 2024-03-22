import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        Stack<Node> dStack = new Stack<>();
        Stack<Node> pStack = new Stack<>();
        
       
        for(int i = 0; i < n; i ++) {
            if(deliveries[i] != 0) {
                dStack.add(new Node(i + 1, deliveries[i]));                
            }
            if(pickups[i] != 0) {
                pStack.add(new Node(i + 1, pickups[i]));                
            }
        }
        
        while(!dStack.isEmpty() || !pStack.isEmpty()) {
           
            int dDistance = 0;
            int pDistance = 0;
            
            if(!dStack.isEmpty()) {
                dDistance = dStack.peek().idx;
            }
            
            if(!pStack.isEmpty()) {
                pDistance = pStack.peek().idx;
            }
            answer += 2 * Math.max(dDistance, pDistance);
            
            
            int cnt = 0;
            
            while(!dStack.isEmpty() && cnt < cap) {
                Node dNode = dStack.pop();
                if(cnt + dNode.count > cap) {
                    dStack.push(new Node(dNode.idx, cnt + dNode.count - cap));
                    break;
                } else {
                    cnt += dNode.count;
                }
            }
            
            
            cnt = 0;
            
            while(!pStack.isEmpty() && cnt < cap) {
                Node pNode = pStack.pop();
                if(cnt + pNode.count > cap) {
                    pStack.push(new Node(pNode.idx, cnt + pNode.count - cap));
                    break;
                } else {
                    cnt += pNode.count;
                }
            }
        }
        
        return answer;
    }
    
    
    private static class Node {
        int idx;
        int count;
        
        public Node(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }
}