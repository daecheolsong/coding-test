import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        List<Point> list = new ArrayList<>();
        
        for(int i = 0; i < wallpaper.length; i ++) {
            for(int j = 0; j < wallpaper[i].length(); j ++) {
                if(wallpaper[i].charAt(j) == '#') {
                    list.add(new Point(i, j));
                }
            }
        }
        
        int minX = 100;
        int minY = 100;
        int maxX = 0;
        int maxY = 0;
        
        for(int i = 0; i < list.size(); i ++) {
            minX = Math.min(minX, list.get(i).x);
            minY = Math.min(minY, list.get(i).y);
            maxX = Math.max(maxX, list.get(i).x);
            maxY = Math.max(maxY, list.get(i).y);
        }
     
        
        return new int [] {minX, minY, maxX + 1, maxY + 1};
    }
    
    private static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}