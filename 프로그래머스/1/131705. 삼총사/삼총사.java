class Solution {
    int answer = 0;
    public int solution(int[] number) {
        
        int [] v = new int[number.length];
        dfs(number, 0, 0, v);
        return answer;
    }
    
    
    public void dfs(int[] number, int depth, int next, int [] v) {
        if(depth == 3) {
            int sum = 0;
            for(int i = 0; i < number.length; i++) {
                if(v[i] == 1) {
                    sum += number[i];
                }
            }
            if(sum == 0) {
                answer++;
            }
            return;
        }
        
        
        for(int i = next; i < number.length; i ++) {
            v[i] = 1;
            dfs(number, depth + 1, i + 1, v);            
            v[i] = 0;
        }
    }
    
}