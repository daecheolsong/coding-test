import java.util.*;
class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= elements.length; i ++) {
            for(int j = 0; j < elements.length; j ++) {
                int sum = 0;
                for(int k = j; k < j + i; k ++) {
                    int idx = k % elements.length;
                    sum += elements[idx];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}