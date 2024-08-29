import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] f = new int[N + 2];
        int[] fa = new int[N + 2];
        for(int i = 0; i < stages.length; i ++) {
            for(int j = 1; j <= stages[i] ; j ++) {
                f[j]++;
            }
        }
        
        for(int i = 0; i < stages.length; i ++) {
            fa[stages[i]]++;
        }
        
        D[] Ds = new D[N];
        
        for(int i = 1; i <= N; i++) {
            if(f[i] == 0) {
                Ds[i-1] = new D(0.0, i);
                continue;
            }
            Ds[i-1] = new D((double)fa[i] / f[i], i);
        }
        Arrays.sort(Ds, (d1, d2) -> {
            if(d1.score == d2.score) {
                return d1.idx - d2.idx;
            }
            return d2.score > d1.score ? 1 : -1;
        });
        
        int[] answer = new int[N];
        
        for(int i = 0; i < N; i++) {
            answer[i] = Ds[i].idx;
        }
        return answer;
    }
    
    static class D {
        double score;
        int idx;
        public D (double score, int idx) {
            this.score = score;
            this.idx = idx;
        }
        
    }
}