import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for(int i = 0; i < s.length(); i ++) {
            Stack<Character> stack = new Stack<>();
      
            for(char c : sb.toString().toCharArray()) {
                if(stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                if(stack.peek() == '(' && c == ')') {
                    stack.pop();
                    continue;
                }
                
                if(stack.peek() == '{' && c == '}') {
                    stack.pop();
                    continue;
                }
                
                if(stack.peek() == '[' && c == ']') {
                    stack.pop();
                    continue;
                }
                stack.push(c);
            }
            if(stack.isEmpty()) {
                answer += 1;
            }
            
            
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
        }
        return answer;
    }
}