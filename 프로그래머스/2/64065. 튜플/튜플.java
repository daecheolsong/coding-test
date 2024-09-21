import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        s = s.substring(1);
        s = s.substring(0, s.length() - 1);
        String [] split = s.split("\\},\\{");
      
        split[0] = split[0].replaceAll("\\{", "");
        split[split.length - 1] = split[split.length - 1].replaceAll("\\}", "");
     
        Arrays.sort(split, (s1, s2) -> s1.length() - s2.length());
       
        int n = split[split.length - 1].split(",").length;
        int [] answer = new int[n];
        int idx = 0;
        Set<String> set = new HashSet<>();
        
        for(String sub : split) {
            for(String elem : sub.split(",")) {
                if(!set.contains(elem)) {
                    set.add(elem);
                    answer[idx++] = Integer.parseInt(elem);
                }
            }
        }
        return answer;
    }
}