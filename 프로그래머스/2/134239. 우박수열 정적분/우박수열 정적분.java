import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> arr = getArray(k);
        
        int idx = 0;
        for(int [] range : ranges) {
            
            int x1 = range[0];
            int x2 = arr.size() + range[1] - 1;
            boolean neg = false;
            if(x1 > x2) {
                answer[idx++] = -1;
                continue;
            }
            double sum = 0; 
            for(int i = x1; i < x2; i ++) {
                sum += ((double)arr.get(i) + arr.get(i + 1)) / 2;
            }
            answer[idx++] = sum;
        }
        
        
        return answer;
    }
    
    public List<Integer> getArray(int k) {
        List<Integer> arr = new ArrayList<>();
        arr.add(k);
        while(k != 1) {
           if(k % 2== 0) {
               arr.add(k / 2);
               k /= 2;
           } else {
               arr.add(k * 3 + 1);
               k = k * 3 + 1;
           }
            
        }
        return arr;
    }
}