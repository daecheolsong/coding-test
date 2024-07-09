import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        // 45 / 3 0
        // 15 / 3 0
        // 5 / 3 2
        // 3 / 3 1
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        String s = sb.toString();
        int t = 1;
        for(int i = s.length() - 1; i >= 0 ; i --) {
            answer += (s.charAt(i) - '0') * t;
            t*=3;
        }
        
        return answer;
    }
}