import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int[][] fm = new int[friends.length][friends.length];
    
        Map<String, Integer> fMap = new HashMap<>();
        
        for(int i = 0; i < friends.length; i ++) {
            fMap.put(friends[i], i);
        }

        
        for(String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            
            int from = fMap.get(st.nextToken());
            int to = fMap.get(st.nextToken());
            
            fm[from][to]++;
        }
        
        
        int[][] results = new int[friends.length][2];
        
        for(int i = 0; i < friends.length; i ++) {
            int give = 0;
            int given = 0;
            for(int j = 0; j < friends.length; j++) {
                give += fm[i][j];
                given += fm[j][i];
            }
            results[i][0] = give;
            results[i][1] = given;
        }
    
        
        for(int i = 0; i < friends.length; i++) {
            int cnt = 0;
            for(int j = 0; j < friends.length; j++ ){
                if(i == j) {
                    continue;
                }
                
                if(fm[i][j] != 0 || fm[j][i] != 0) {
                    if(fm[i][j] > fm[j][i]) {
                        cnt++;
                    } else if(fm[i][j] == fm[j][i]) {
                        if(results[i][0] - results[i][1] > results[j][0] - results[j][1]) {
                            cnt++;
                        }
                    }
                } else {
                    if(results[i][0] - results[i][1] > results[j][0] - results[j][1]) {
                        cnt++;
                    }
                }
            }
            answer = Math.max(cnt, answer);
        }
        
        
        
        return answer;
    }
    
}