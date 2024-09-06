import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[][] sizes) {
        
        int maxW = 0;
        int maxH = 0;
        for(int i = 0; i < sizes.length; i ++) {
            int a = sizes[i][0];
            int b = sizes[i][1];
            
            if(a < b) {
                sizes[i][0] = b;
                sizes[i][1] = a;
            }
            maxW = Math.max(maxW, sizes[i][0]);
            maxH = Math.max(maxH, sizes[i][1]);
        }
        
        
        
        
        return maxW * maxH;
    }
}