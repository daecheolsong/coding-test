import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int n = p.length();
        String s = t.substring(0,n);
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        for(int i = 0; i < n ; i ++) {
            if(p.charAt(i) < sb.toString().charAt(i)) {
                break;
            }
            if(p.charAt(i) == sb.toString().charAt(i)) {
                if(i == n - 1) {
                    answer++;
                }
                continue;
            }
            
            answer++;
            break;
        }
        
        for(int i = n ; i < t.length(); i ++) {
            sb.append(t.charAt(i));
            sb.delete(0, 1);
 
            if(sb.toString().charAt(0) == '0') {
                answer++;
                continue;
            }
            
            for(int j = 0; j < n ; j ++) {
                if(p.charAt(j) < sb.toString().charAt(j)) {
                    break;
                }
                if(p.charAt(j) == sb.toString().charAt(j)) {
                    if(j == n - 1) {
                        answer++;
                    }
                    continue;
                }
                answer++;
                break;
            }
        }
            
        
        return answer;
    }
}