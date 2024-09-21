class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, target, numbers);
        return answer;
    }
    
    public void dfs(int depth, int curSum, int target, int[] numbers) {
        if(depth == numbers.length) {
            if(curSum == target) {
                answer++;
            }
            return;
        }
        dfs(depth + 1, curSum + numbers[depth], target, numbers);
        dfs(depth + 1, curSum - numbers[depth], target, numbers);
    }
}