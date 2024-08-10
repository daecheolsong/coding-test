import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int [score.length];
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(score[0]);
        answer[idx++] = pq.peek();
        for(int i = 1; i < score.length; i ++) {
            int cur = pq.peek();
            
            if(pq.size() == k) {
                if(cur < score[i]) {
                    pq.poll();
                    pq.add(score[i]);
                }
            } else {
                pq.add(score[i]);
            }
            
            answer[idx++] = pq.peek();
            
        }
        return answer;
    }
}