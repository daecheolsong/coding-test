import java.util.*;
class Solution {
    
    int answer = -1;
    int n;
    int m;
    int [] mvx = {0, 0, 1, -1};
    int [] mvy = {1, -1, 0, 0};
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        char[][] cBoard = new char[n][m];
        int[][] v = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        
        int sx = 0;
        int sy = 0;
        
        for(int i = 0; i < n ; i++) {
            cBoard[i] = board[i].toCharArray();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(cBoard[i][j] == 'R') {
                    sx = j;
                    sy = i;
                    v[sy][sx] = 1;
                    break;
                }
            }
        }
        
        q.add(new int[] {sx, sy, 0});
        
        while(!q.isEmpty()) {
            
            int[] cur = q.poll();
            
            if(cBoard[cur[1]][cur[0]] == 'G') {
                return cur[2];
            }
            
            
            int nx = cur[0];
            int ny = cur[1];
            
            while(ny + mvy[0] < n && !isBlock(cBoard[ny + mvy[0]][nx])) {
                ny = ny + mvy[0];
            }
            
            if(v[ny][nx] == 0) {
                v[ny][nx] = 1;
                q.add(new int[] {nx, ny, cur[2] + 1});
            }
            
            ny = cur[1];
            
            
            while(ny + mvy[1] >= 0 && !isBlock(cBoard[ny + mvy[1]][nx]) ) {
                ny = ny + mvy[1];
            }
            
            if(v[ny][nx] == 0) {
                v[ny][nx] = 1;
                q.add(new int[] {nx, ny, cur[2] + 1});
            }
            
            ny = cur[1];
            
            while(nx + mvx[2] < m && !isBlock(cBoard[ny][nx + mvx[2]])) {
                nx = nx + mvx[2];
            }
            
            if(v[ny][nx] == 0) {
                v[ny][nx] = 1;
                q.add(new int[] {nx, ny, cur[2] + 1});
            }
            
            nx = cur[0];
            
            while(nx + mvx[3] >= 0 && !isBlock(cBoard[ny][nx + mvx[3]]) ) {
                nx = nx + mvx[3];
            }
            
            if(v[ny][nx] == 0) {
                v[ny][nx] = 1;
                q.add(new int[] {nx, ny, cur[2] + 1});
            }
            
        }
        
        return answer;
    }
    
    
    public boolean isIn(int nx, int ny) {
        return nx >= 0 && nx < m && ny >=0 && ny < n;
    }
    
    public boolean isBlock(char c){
        return c == 'D';
    }
    
}