class Solution {


    int maxDiff = 0;
    
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int[] lionInfo = new int[11];

        dfs(info, lionInfo, n, 0, 0, answer);

        if (maxDiff == 0) {
            return new int[]{-1};
        }
        return answer;
    }


    public void dfs(int[] info, int[] lionInfo, int n, int idx, int depth, int[] answer) {

        if(depth == n) {
            int appeach = 0;
            int lion = 0;

            for(int i = 0; i < 11; i++) {
                
                
                if(info[i] >= lionInfo[i]) {
                    if(info[i] != 0)
                    appeach += 10 - i;
                } else {
                    lion += 10 - i;
                }
            }
            if(lion <= appeach) {
                return;
            }

            int diff = lion - appeach;
          

            if(maxDiff == diff) {
            
                for(int i = 0; i < 11; i++) {
                    if(answer[10-i] > lionInfo[10-i]) {
                        return;
                    }
                    if (answer[10 - i] < lionInfo[10 - i]) {
                        for (int j = 0; j < 11; j++) {
                            answer[j] = lionInfo[j];
                        }
                        return;
                    }
                }

            } else if(diff > maxDiff) {
                for(int i = 0; i < 11; i++) {
                    answer[i] = lionInfo[i];
                }
                maxDiff = diff;
            }
            return;
        }


        for(int i = idx; i < 11; i++) {
            lionInfo[i]++;
            dfs(info, lionInfo, n, i,depth + 1, answer);
            lionInfo[i]--;
        }
    }

}