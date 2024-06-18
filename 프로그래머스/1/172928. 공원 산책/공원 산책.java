import java.util.*;
class Solution {
    
    int [] mvx = {0, 0, -1, 1};
    int [] mvy = {-1, 1, 0, 0};
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int sx = 0;
        int sy = 0;
        for(int i = 0; i < park.length; i ++) {
            for(int j = 0; j < park[0].length(); j ++) {
                if(park[i].charAt(j) == 'S') {
                    sx = j;
                    sy = i;
                    break;
                }
            }
        }
        
       for(String r : routes) {
           StringTokenizer st = new StringTokenizer(r);
           String dir = st.nextToken();
           int mov = Integer.parseInt(st.nextToken());
           int movIdx = getMovIdx(dir);
           int nx = sx + mvx[movIdx] * mov;
           int ny = sy + mvy[movIdx] * mov;
           
           if(isIn(nx, ny, park[0].length(), park.length)) {
             boolean can = true;
             if(movIdx == 0) {
                 for(int i = ny; i <= sy; i ++) {
                     if(park[i].charAt(sx) == 'X') {
                         can = false;
                         break;
                     }
                 }
             } else if(movIdx == 1) {
                 for(int i = sy; i <= ny; i ++) {
                     if(park[i].charAt(sx) == 'X') {
                         can = false;
                         break;
                     }
                 }
             } else if(movIdx == 2) {
                 for(int i = nx; i <= sx; i ++) {
                     if(park[sy].charAt(i) == 'X') {
                         can = false;
                         break;
                     }
                 }
             } else if(movIdx == 3) {
                 for(int i = sx; i <= nx; i ++) {
                     if(park[sy].charAt(i) == 'X') {
                         can = false;
                         break;
                     }
                 }
             }
               if(!can) {
                   continue;
               }
               
               sx = nx;
               sy = ny;
           }
           
       }
        answer[0] = sy;
        answer[1] = sx;
        
        return answer;
    }
    
    public int getMovIdx(String dir) {
        if(dir.equals("N")) {
            return 0;
        }
        
        if(dir.equals("S")) {
            return 1;
        }
        
        if(dir.equals("W")) {
            return 2;
        }
        return 3;
    }
    
    public boolean isIn(int x, int y, int mx, int my) {
        return x >= 0 && x < mx && y >=0 && y < my;
    }
    
    
}