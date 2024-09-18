import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        List<List<Pair>> arr = new ArrayList<>();
        
        for(int[] route : routes) {
            List<Pair> list = new ArrayList();
            
            int sr = points[route[0] - 1][0];
            int sc = points[route[0] - 1][1];
            list.add(new Pair(sr, sc));
            int nextRouteIdx = 1;
            
            while(route.length > nextRouteIdx) {
                int tr = points[route[nextRouteIdx] - 1][0];
                int tc = points[route[nextRouteIdx] - 1][1];
                if(tr == sr && tc == sc) {
                    nextRouteIdx++;
                    continue;
                }
                int dr = 0;
                int dc = 0;
                
                if(Math.abs(tr - sr) > 0) {
                    dr = tr > sr ? 1 : -1;
                } else if(Math.abs(tc - sc) > 0){
                    dc = tc > sc ? 1 : -1;
                }
                
                list.add(new Pair(sr + dr, sc + dc));
                sr = sr + dr;
                sc = sc + dc;
                
            }
            arr.add(list);
        }
        int maxTime = 0;
        for(int i = 0 ; i < arr.size(); i++) {
            maxTime = Math.max(arr.get(i).size(), maxTime);
        }
        Map<Integer, Map<Pair, Integer>> map = new HashMap<>();
        for(int i = 1; i <= maxTime; i ++) {
            map.put(i, new HashMap<>());
        }
        for(int i = 0; i < arr.size(); i++) {
            List<Pair> cur = arr.get(i);
            for(int j = 0; j < cur.size(); j ++) {
                Map<Pair, Integer> curMap = map.get(j + 1);
                curMap.put(cur.get(j), curMap.getOrDefault(cur.get(j), 0) + 1);
            }
        }
        
        for(int i = 1; i <= maxTime; i ++) {
            Map<Pair,Integer> curMap = map.get(i);
            for(Pair p : curMap.keySet()) {
                if(curMap.get(p) > 1) {
                    answer ++;
                }
            }
        }
        
        
        return answer;
    }
    private static class Pair {
        int r;
        int c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public boolean equals(Object p) {
            return this.r == ((Pair)p).r && this.c == ((Pair)p).c;
        }
        public int hashCode() {
            return 31 * r + c;
        }
        public String toString() {
            return this.r + " : " + this.c;
        }
    }
}