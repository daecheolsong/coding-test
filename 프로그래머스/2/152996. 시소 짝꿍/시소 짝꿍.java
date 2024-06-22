import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        int [] wF = new int[1001];
        int [] tF = new int[4001];
        
        for(int i = 0; i < weights.length; i ++) {
            int w = weights[i];
            
            if(wF[w] > 0) {
                answer += wF[w];
                answer += (tF[2*w] - wF[w]);
                answer += (tF[3*w] - wF[w]);
                answer += (tF[4*w] - wF[w]);
            } else {
                answer += tF[2*w];
                answer += tF[3*w];
                answer += tF[4*w]; 
                
            }
            
            wF[w]++;
            tF[2*w]++;
            tF[3*w]++;
            tF[4*w]++;
        }
        return answer;
    }
}