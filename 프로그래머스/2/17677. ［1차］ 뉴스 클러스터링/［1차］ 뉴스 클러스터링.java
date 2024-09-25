import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str1.length() - 1 ; i ++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if(isValid(c1) && isValid(c2)) {
                sb.append(c1).append(c2);
            }
            if(sb.length() == 2) {
                arr1.add(sb.toString());                
            }
            sb.setLength(0);
        }
        
        for(int i = 0; i < str2.length() - 1 ; i ++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            if(isValid(c1) && isValid(c2)) {
                sb.append(c1).append(c2);
            }
            if(sb.length() == 2) {
                arr2.add(sb.toString());                
            }
            sb.setLength(0);
        }
        
        Map<String, Integer> f1 = new HashMap<>();
        Map<String, Integer> f2 = new HashMap<>();
        
        for(int i = 0; i < arr1.size(); i ++) {
            f1.put(arr1.get(i), f1.getOrDefault(arr1.get(i), 0) + 1);
        }
        
        for(int i = 0; i < arr2.size(); i ++) {
            f2.put(arr2.get(i), f2.getOrDefault(arr2.get(i), 0) + 1);
        }
        
        int total = 0;
        int count = 0;
        
        for(String key : f1.keySet()) {
            if(f2.containsKey(key)) {
                total += Math.max(f1.get(key), f2.get(key));
                count += f2.containsKey(key) ? Math.min(f1.get(key), f2.get(key)) : 0;
                f2.remove(key);
            } else {
                total += f1.get(key);
            }
        }
        
        for(String key : f2.keySet()) {
            total += f2.get(key);
        }
        if(total == 0) {
            return 65536;
        }
        double j = (double) count / total;
        return (int)(j * 65536);
    }
    
    public boolean isValid(char c){
        return c >= 'a' && c <='z';
    }
}