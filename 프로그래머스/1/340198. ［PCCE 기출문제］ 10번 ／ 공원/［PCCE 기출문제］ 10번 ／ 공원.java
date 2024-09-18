import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        for(int mat : mats) {
            for(int i = 0 ; i <= park.length - mat; i ++) {
                for(int j = 0; j <= park[0].length - mat; j ++) {
                    boolean able = true;
                    for(int k = i ; k < i + mat; k ++) {
                        for(int l = j; l < j + mat; l ++) {
                            if(!park[k][l].equals("-1")) {
                                able = false;
                                break;
                            }
                        }
                    }
                    if(able) {
                        answer = Math.max(answer, mat);
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}