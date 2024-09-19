class Solution {
    public long[] solution(long[] numbers) {
        long [] answer = new long[numbers.length];
        int idx = 0;
        for(long num : numbers) {
            if(num % 2 == 0) {
                answer[idx++] = num + 1;
                continue;
            }
            char[] s = ("0" + Long.toBinaryString(num)).toCharArray();
            
            for(int i = s.length - 2; i >= 0; i --) {
                if(s[i] == '0') {
                    s[i] = '1';
                    s[i + 1] = '0';
                    break;
                }
            }
            long a = 0;
            long mul = 1;
            for(int i = s.length - 1; i >= 0; i --) {
                if(s[i] == '1') {
                    a += mul;
                }
                mul *= 2;
            }
            answer[idx++] = a;
        }
        
        return answer;
    }
    
}
