import java.util.*;


class Solution {
    int [] mvx = {0, 0, 1, -1};
    int [] mvy = {1, -1, 0, 0};
    
    public int solution(int[][] land) {
     
        List<G> groups = new ArrayList<>();
        
        int[][] v = new int[land.length][land[0].length];
        
        init(land, v, groups);
        
        int [] ans = new int[land[0].length];
        
        int res = 0;
        
        for(G group : groups) {
            Set<Integer> xs = group.xs;
            
            for(Integer x : xs) {
                ans[x] += group.count;
            }
        }
        
        for(int c : ans) {
            res = Math.max(res, c);
        }
        
        return res;
        
    }
    
    public void init(int[][] land, int[][] v, List<G> groups) {
        
        for(int i =  0; i < land.length; i ++) {
            for(int j = 0; j < land[0].length; j ++) {
                
                if(land[i][j] == 1 && v[i][j] == 0) {
                    v[i][j] = 1;
                    makeGroup(land, v, groups, i, j);
                }
            }
        }
    }
    
    
    public void makeGroup(int[][] land, int [][] v, List<G> groups, int y, int x) {
        
        int [] startPosition = {y, x};
        int count = 1;
        Queue<int []> q = new LinkedList<>();
        q.add(startPosition);
        Set<Integer> xs = new TreeSet<>();
        xs.add(x);
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            
            for(int i = 0; i < 4; i ++ ){
                int nx = cur[1]  + mvx[i];
                int ny = cur[0]  + mvy[i];
                
                if(isIn(nx, ny, land[0].length, land.length) && v[ny][nx] == 0 && land[ny][nx] == 1) {
                    v[ny][nx] = 1;
                    count ++;
                    q.add(new int[] {ny, nx});
                    xs.add(nx);
                } 
            }
        }
        
        groups.add(new G(count, xs));
    }
    
    public boolean isIn(int nx, int ny, int x, int y) {
        return nx >=0 && nx < x && ny >=0 && ny < y;
    }
    
    public static class G {
        int count;
        Set<Integer> xs;
        
        
        public G(int count, Set<Integer> xs) {
            this.count = count;
            this.xs = xs;
        }
    }
}