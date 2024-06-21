class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        int [] alp = new int[26];
        
        for(int i = 0; i < skip.length(); i ++) {
            alp[skip.charAt(i) - 'a'] = 1;
        }
        for(int i = 0; i < s.length(); i ++) {
            int count = 0;
            int idx = s.charAt(i) - 'a';
            
            while(count < index) {
                idx = (idx + 1) % 26;
                if(alp[idx] == 1) {
                    continue;
                }
                count++;
            }
            answer += (char) ('a' + idx);
        }
        return answer;
    }
}