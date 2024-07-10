class Solution {
    public long solution(int n, int[] times) {
        
        long s = 0l;
        long e = 100_000_000_000_000l;
        
        while(s < e) {
            long mid = (s + e) / 2;
            
            long count = 0;
            for(int i = 0; i < times.length ; i ++) {
                count += mid / times[i];
            }
            if(count >= n) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}


