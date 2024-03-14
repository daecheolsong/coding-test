import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
       int [][] f = new int [friends.length][friends.length];
        int [] rf = new int[friends.length];
        int [] g = new int[friends.length];
        Map<String, Integer> fMap = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            fMap.put(friends[i], i);
        }
        
    /*
     0 1 2 3
   0 2 1 0 
   1
   2
   3
    */
        for(String gift : gifts) {
            String [] lr = gift.split(" ");
            int l = fMap.get(lr[0]);
            int r = fMap.get(lr[1]);
            f[l][r]++;
            rf[l]++; // give
            rf[r]--; // receive
        }
        
        for(int i = 0; i < friends.length; i++) {
            for(int j = i + 1; j < friends.length; j ++) {
                if(f[i][j] > f[j][i]) {
                    g[i] ++;
                    continue;
                }
                if(f[i][j] == f[j][i]) {
                    if(rf[i] > rf[j]) {
                        g[i] ++;
                    } else if(rf[i] < rf[j]){
                        g[j]++;
                    }
                    continue;
                }
                g[j] ++;
            }
        }
        Arrays.sort(g);
        return g[friends.length-1];
        
    }
}