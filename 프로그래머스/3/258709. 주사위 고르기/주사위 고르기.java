import java.util.*;
class Solution {
    int [] maxChoose;
    int maxW = 0;
    public int[] solution (int[][] dice) {
        int [] v = new int[dice.length];
        
        dfs(0, dice, 0, v);
        int [] answer = new int[dice.length/2];
        
        for(int i = 0; i < answer.length; i ++) {
            answer[i] = maxChoose[i] + 1;
        }
        
        return answer;
    }

    public void dfs(int next, int[][] dice, int depth, int [] v) {

        if(depth == dice.length / 2) {
            int[] aChoose = new int[dice.length / 2];
            int[] bChoose = new int[dice.length / 2];
            int aIdx = 0;
            int bIdx = 0;
            for (int i = 0; i < dice.length; i++) {
                if (v[i] == 0) {
                    bChoose[bIdx++] = i;
                    continue;
                }
                aChoose[aIdx++] = i;
            }
            List<Integer> aCaseSum = new ArrayList<>();
            caseFill(aCaseSum, dice, aChoose, 0, 0);
            Collections.sort(aCaseSum);
            List<Integer> bCaseSum = new ArrayList<>();
            caseFill(bCaseSum, dice, bChoose, 0, 0);
            Collections.sort(bCaseSum);


            int w = 0;
           
              for (int i = 0; i < aCaseSum.size(); i++) {
                int aSum = aCaseSum.get(i);
                int s = 0;
                int e = aCaseSum.size() - 1;

                while (s <= e) {
                    int mid = (s + e) / 2;
                    if (bCaseSum.get(mid) >= aSum) {
                        e = mid - 1;
                    } else {
                        s = mid + 1;
                    }
                }
                w += s;

            }
            
            if (maxW < w) {
                maxW = w;
                maxChoose = aChoose;
            }

            return;
        }

        for(int i = next; i < dice.length ; i ++) {
            if (v[i] == 0) {
                v[i] = 1;
                dfs(i + 1, dice, depth + 1, v);
                v[i] = 0;
            }
        }
    }
    
    
     public void caseFill(List<Integer> cases,int[][] dice, int[] chooseIdx, int depth, int sum) {
        if (depth == chooseIdx.length) {
            cases.add(sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            int [] curDice = dice[chooseIdx[depth]];
            sum += curDice[i];
            caseFill(cases, dice, chooseIdx, depth + 1, sum);
            sum -= curDice[i];
        }



    }

}