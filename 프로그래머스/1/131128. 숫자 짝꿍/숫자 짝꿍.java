import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        char [] cX = X.toCharArray();
        char [] cY = Y.toCharArray();
        
        int [] fX = new int[10];
        int [] fY = new int[10];
        
        for(int i = 0; i < cX.length; i ++) {
            fX[cX[i] - '0'] ++;
        }
        
        for(int i = 0; i < cY.length; i ++) {
            fY[cY[i] - '0'] ++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 9; i >= 0; i --) {
            if(fX[i] == 0 || fY[i] == 0) {
                continue;
            }
              
            while(fX[i] > 0 && fY[i] > 0) {
                sb.append((char)(i + '0'));
                fX[i]--;
                fY[i]--;
            }
        }
        if(sb.length() == 0) {
            return "-1";
        }
        
        String answer = sb.toString();
        
        if(answer.startsWith("0")) {
            answer = "0";   
        }
        
        return answer;
    }
}