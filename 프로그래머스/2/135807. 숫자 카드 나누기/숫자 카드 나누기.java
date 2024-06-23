import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int minNum = Math.max(arrayA[0], arrayB[0]);
        
        for(int i = 2; i <= minNum; i ++) {
            if((divide(arrayA, i, true) && divide(arrayB, i, false)) || (divide(arrayB, i, true) && divide(arrayA, i, false))) {
                answer = i;
            }
        }
        
        return answer;
    }
    
    
    public boolean divide(int [] arr, int num, boolean can) {
        if(can) {
            
            for(int i = 0; i < arr.length; i ++) {
                if(arr[i] % num != 0) {
                    return false;
                }   
            }
            return true;
        }
        
        for(int i = 0; i < arr.length; i ++) {
            if(arr[i] % num == 0) {
                return false;
            }
        }
        return true;
    }
}