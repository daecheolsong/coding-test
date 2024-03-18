import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int[] pSumArr = new int[sequence.length + 1];
        int pSum = 0;
        
        for(int i = 1 ; i <= sequence.length; i++) {
           pSum += sequence[i - 1];
           pSumArr[i] = pSum; 
        }
        
        for(int m = 1; m <= sequence.length; m ++ ) {
            
            int s = 0;
            int e = sequence.length - m;
            
            if (pSumArr[sequence.length] - pSumArr[sequence.length - m] < k) {                
                continue;
            }
            
            if (pSumArr[m] - pSumArr[0] > k) {
                break;                
            }
            
            while(s < e) {
                int mid = (s + e) / 2;
                
                if(pSumArr[mid + m] - pSumArr[mid] >= k) {
                    e = mid;
                } else {
                    s = mid + 1;
                }
            }
            if(pSumArr[s + m] - pSumArr[s] == k) {
                return new int[] {s, s + m - 1};
            }
        }
        
        
        return answer;
    }
}