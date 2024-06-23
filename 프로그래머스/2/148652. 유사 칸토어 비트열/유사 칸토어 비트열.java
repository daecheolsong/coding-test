class Solution {
    int answer = 0;
    public int solution(int n, long l, long r) {
        
        dfs(n, 0, l, r, 1);
        return answer;
    }
    
    
    public void dfs(int n, int depth, long l, long r, long k) {
        
        
        long e = (long)Math.pow(5, n - depth) * k;
        long s = e - (long)Math.pow(5, n - depth) + 1;
        
        
        if(l <= s && e <= r) {
            answer += (int) Math.pow(4, n - depth);
            return;
        }
        
        if(l > e || r < s) {
            return;
        }
        
        
        long nk = 5 * k;
        
        dfs(n, depth + 1, l, r, nk);
        dfs(n, depth + 1, l, r, nk - 1);
        dfs(n, depth + 1, l, r, nk - 3);
        dfs(n, depth + 1, l, r, nk - 4);
    }
}



