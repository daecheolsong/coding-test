import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = pos;
        
        for(String c : commands) {
            
            int diff = c.equals("next") ? 10 : -10;
            
            int opSint = stoi(op_start);
            int opEint = stoi(op_end);
            
            int posInt = stoi(answer);
            
            if(opSint <= posInt && opEint >= posInt) {
                posInt = opEint;
            }
            
            posInt = diff == 10 ? Math.min(posInt + diff, stoi(video_len)) : Math.max(posInt + diff, 0);
            
            if(opSint <= posInt && opEint >= posInt) {
                posInt = opEint;
            }
            
            answer = itos(posInt);
        }
       
        
        return answer;
    }
    
    public String itos(int i){
     
        int minute = i / 60;
        i %= 60;
       
        String minString = String.valueOf(minute < 10 ? "0"+minute : minute);
        String secString = String.valueOf(i < 10 ? "0"+i : i);
        
        return minString + ":" + secString;
    }
    
    public int stoi(String s) {
        String[] sp = s.split(":");
       
        return Integer.parseInt(sp[0]) * 60 + Integer.parseInt(sp[1]);
    }
}