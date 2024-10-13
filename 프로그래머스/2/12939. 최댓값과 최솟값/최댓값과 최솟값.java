class Solution {
    public String solution(String s) {
        String [] split = s.split(" ");
        int min = Integer.parseInt(split[0]);
        int max = min;
        for(int i = 1; i < split.length; i ++) {
            min = Math.min(min, Integer.parseInt(split[i]));
            max = Math.max(max, Integer.parseInt(split[i]));
        }
        return min + " " + max;
    }
    
}