class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int n = want.length;
        int answer = 0;
        for(int i = 0; i <= discount.length - 10; i ++) {
            int [] copy = new int[number.length];
            for(int j = 0; j < number.length; j ++) {
                copy[j] = number[j];
            }
            
            boolean can = true;
            
            for(int k = 0; k < n; k ++) {
                for(int j = i; j < i + 10; j ++) {
                    if(want[k].equals(discount[j])) {
                      if(copy[k] > 0) {
                            copy[k]--;
                        }
                    }
                }    
            }
            
            for(int j = 0; j < n; j ++) {
                if(copy[j] > 0) {
                    can = false;
                }
            }
            
            
            if(!can) {
                continue;
            }
          
            answer++;
        }
        
        
        return answer;
    }
}