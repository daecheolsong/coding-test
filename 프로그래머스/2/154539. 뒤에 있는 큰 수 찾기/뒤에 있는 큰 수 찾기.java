import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer , -1);
        
        Stack<Integer> s = new Stack<>();
        
        
        for(int i = numbers.length - 1; i >= 0; i --) {
            int num = numbers[i];
            
            while(!s.isEmpty() && num >= s.peek()) {
                s.pop();
            }
            
            if(!s.isEmpty()) {
                answer[i] = s.peek();                
            }

            s.add(num);
            
        }
        return answer;
    }
}