import java.util.*;
class Solution {
    
    public int result = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        
        int[][] table = new int[][]{{1, 1, 1},{5, 1, 1},{25, 5, 1}};

        int[] mIdx = new int[minerals.length];

        for(int i = 0; i < minerals.length; i++) {
            String mineral = minerals[i];

            if(mineral.equals("diamond")) {
                mIdx[i] = 0;
            } else if(mineral.equals("iron")) {
                mIdx[i] = 1;
            } else {
                mIdx[i] = 2;
            }
        }

        dfs(mIdx, picks, table, 0, 0);

        return result;
    }
    
    public void dfs(int [] mIdx, int[] picks, int[][] table, int depth, int cost) {
         boolean isEmpty = true;
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] != 0) {
                isEmpty = false;
            }
        }

        if (depth == mIdx.length || isEmpty) {
            result = Math.min(result, cost);
            return;
        }


        if(picks[0] > 0) {
            picks[0]--;
            int diff = Math.min(5, mIdx.length - depth);
            int dCost = 0;
            for (int i = depth; i < depth + diff; i++) {
                dCost += table[0][mIdx[i]];
            }
            dfs(mIdx, picks, table, depth+ diff, cost + dCost);
            picks[0]++;
        }
        if(picks[1] > 0) {
            picks[1]--;
            int diff = Math.min(5, mIdx.length - depth);
            int dCost = 0;
            for (int i = depth; i < depth + diff; i++) {
                dCost += table[1][mIdx[i]];
            }
            dfs(mIdx, picks, table, depth + diff, cost + dCost);
            picks[1]++;
        }
        if(picks[2] > 0) {
            picks[2]--;
            int diff = Math.min(5, mIdx.length - depth);
            int dCost = 0;
            for (int i = depth; i < depth + diff; i++) {
                dCost += table[2][mIdx[i]];
            }
            dfs(mIdx, picks, table, depth + diff, cost + dCost);
            picks[2]++;
        }
    }
}