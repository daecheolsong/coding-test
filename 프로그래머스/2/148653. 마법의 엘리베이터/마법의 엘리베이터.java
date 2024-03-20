import java.util.*;
class Solution {
    public int solution(int storey) {
        
        int answer = 0;
        while(storey > 0) {
            
            int res = storey % 10;
            
            storey/=10;
            
            
            if(res > 5) {
                answer += 10 - res;
                storey++;
            } else if(res < 5) {
                answer += res;
            } else {
                answer += 5;                
                if(storey % 10 > 4) {
                    storey += 1;
                }
                
            }
            
        }
        return answer;
    }
}