import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int [] time = new int[24*60];
        
        int [][] bookInt = new int[book_time.length][2];
        int idx = 0;
        for(String [] book : book_time) {
            int s = Integer.parseInt(book[0].split(":")[0]) * 60 + Integer.parseInt(book[0].split(":")[1]);
            int e = Integer.parseInt(book[1].split(":")[0]) * 60 + Integer.parseInt(book[1].split(":")[1]) + 9;
            if(e >= 24 * 60) {
                e = 24 * 60 - 1;
            }
            bookInt[idx++] = new int[]{s, e};
        }
        
        Arrays.sort(bookInt, (b1, b2) -> b2[1] - b1[1]);
      
        int count = 0;
        
        int [] v = new int[book_time.length];
        
        while(count < v.length) {
            Arrays.fill(time, 0);
            for(int i = 0; i < bookInt.length; i ++) {
                if(v[i] == 1) {
                    continue;
                }
                int s = bookInt[i][0];
                int e = bookInt[i][1];
                
                boolean fill = false;
                for(int j = s; j <= e; j ++) {
                    if(time[j] == 1) {
                        fill = true;
                        break; 
                    }
                }
                if(!fill) {
                    for(int j = s; j <= e ; j ++) {
                        time[j] = 1;
                    }
                    v[i] = 1;
                    count++;
                }
            }
            answer++;
        }
        
        return answer;
    }
}