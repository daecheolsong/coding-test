import java.util.*;
class Solution {
    public int solution(int[] topping) {
        
        int answer = 0;
        
        int [] c = new int[10001];
        int [] cd = new int[10001];

        int cType = 0;
        
        for(int t : topping) {
            c[t]++;
            if(c[t] == 1) {
                cType++;
            }
        }
        
        int cdType = 0;
        
        for(int t : topping) {
            if(cd[t] == 0) {
                cdType++;
            }
            cd[t]++;
            c[t]--;
            if(c[t] == 0) {
                cType--;
            }
            
            if(cdType == cType) {
                answer++;
            }
        }
        return answer;
    }
}