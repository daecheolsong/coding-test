import java.util.*;
class Solution {
    
    public String solution(int n, int t, int m, int p) {
        String [] alpha = new String[] {"A", "B", "C", "D", "E", "F"};
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        int i = 1;
        while(sb.length() < m * t) {
            int s = i;
            StringBuilder make = new StringBuilder(); 
            while(s != 0) {
                make.append(s % n >= 10 ? String.valueOf(alpha[s % n - 10]) : s % n);
                s /= n;
            }
            sb.append(make.reverse());
            i++;
        }
        
        int count = 0;
        int idx = p - 1;
 
        while(count < t) {
           
            answer.append(sb.charAt(idx));
            idx += m;
            count++;
        }
        return answer.toString();
    }
}