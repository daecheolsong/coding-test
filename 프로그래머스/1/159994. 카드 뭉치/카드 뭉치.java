import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
       
        int idx = 0;
        int c1Idx = 0;
        int c2Idx = 0;
        
        while(idx < goal.length) {
            if(c1Idx < cards1.length) {
                if(cards1[c1Idx].equals(goal[idx])) {
                    idx++;
                    c1Idx++;
                    continue;
                }
            }
            
            if(c2Idx < cards2.length) {
                if(cards2[c2Idx].equals(goal[idx])) {
                    idx++;
                    c2Idx++;
                    continue;
                }
            }
            
            return "No";
        }
        
        
        
        
        return "Yes";
    }
}