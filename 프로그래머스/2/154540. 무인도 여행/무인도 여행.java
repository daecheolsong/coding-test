import java.util.*;
class Solution {
    
    public int [] mvx = { 0, 0, -1, 1};
    public int [] mvy = {1, -1, 0, 0};
    
    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        int [][] im = new int[maps.length][maps[0].length()];
        
        for(int i = 0 ; i < maps.length; i ++) {
            char[] cm = maps[i].toCharArray();
            for(int j = 0; j < cm.length; j ++) {
             
                im[i][j] = (cm[j] == 'X' ? 0 : cm[j] -'0');
            }
        }
        
        int[][] v = new int[im.length][im[0].length];
        
        for(int i = 0; i < im.length; i ++) {
            for(int j = 0; j < im[0].length; j ++) {
                
                if(v[i][j] == 0 && im[i][j] != 0) {
                    answer.add(bfs(j, i, im, v));
                }
            }
        }
        Collections.sort(answer);
        
        return answer.isEmpty() ? List.of(-1) : answer; 
    }
    
    
    public int bfs(int sX, int sY, int [][] im, int[][] v) {
        Queue<int[]> q = new LinkedList<>();

        int cost = im[sY][sX];
        v[sY][sX] = 1;
        
        q.add(new int[] { sX, sY, im[sY][sX]});
        
        while(!q.isEmpty()) {
            int [] m = q.poll();
            for(int i = 0; i < 4; i ++) {
                int nx = m[0] + mvx[i];
                int ny = m[1] + mvy[i];
                
                if(isIn(nx, ny, im[0].length, im.length) && im[ny][nx]!= 0 && v[ny][nx] == 0) {
                    v[ny][nx] = 1;
                    cost += im[ny][nx];
                    q.add(new int[] {nx, ny, im[ny][nx] });
                }
            }
            
        }
        return cost;
        
    }
    public boolean isIn(int nx, int ny, int x, int y) {
        return nx >= 0 && nx < x && ny >=0 && ny < y;
    }
    
}