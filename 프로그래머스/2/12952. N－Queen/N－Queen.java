import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int n) {
        dfs(0, new int[n], n);
        return answer; 
    }
    
    public void dfs(int r, int[] cols, int n) {
        if(r == n) {
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i ++) {
            if(can(cols, r, i)) {
                cols[r] = i;
                dfs(r+1, cols, n);
            }
        }
        
    }
    
    public boolean can(int[] cols, int r, int i) {
         for(int j = 0; j < r; j ++) {
                if(cols[j] == i || Math.abs(cols[j] - i) == r - j) {
                    return false;
                }
        }
        return true;
    }
}