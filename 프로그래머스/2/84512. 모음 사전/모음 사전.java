import java.util.*;
class Solution {
    String[] w = {"A", "E", "I", "O", "U"};
    int answer = 0;
    List<String> words = new ArrayList<>();
    
    public int solution(String word) {
            
        for(int i = 0; i < 5; i ++) {
            dfs(w[i]);
        }
        
        for(int i = 0; i < words.size(); i ++) {
            if(words.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
    
    public void dfs(String src) {
        if(src.length() > 5) {
            return;
        }
        words.add(src);
        for(int i = 0; i < w.length; i++) {
            dfs(src + w[i]);
        }
    }
    
}