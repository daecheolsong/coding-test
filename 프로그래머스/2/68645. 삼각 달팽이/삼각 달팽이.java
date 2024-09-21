class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n + 1) / 2];
        int[][] arr = new int[n][n];
        
        int num = 1;
        int r = -1;
        int c = 0;
        
        for(int i = 0; i < n ; i++) {
            for(int j = i; j < n; j ++) {
                if(i % 3 == 0) {
                    r++;
                } else if(i % 3 == 1) {
                    c++;
                } else {
                    r--;
                    c--;
                }
                arr[r][c] = num++;
            }
        }
        int idx = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j <= i; j ++) {
                answer[idx++] = arr[i][j];
            }
        }
         
        return answer;
    }
}