class Solution {
    public int solution(int left, int right) {
        return get(left, right);
    }
    public int get(int left, int right){
        int count = 0;
        for(int i = left; i <= right; i ++) {
            int divCount = 1;
            for(int j = 2; j <= i; j ++) {
                if(i % j == 0) {
                    divCount++;
                }
            }
            if(divCount % 2 == 0) {
                count += i;
            } else {
                count -= i;
            }
        }
        return count;
    }
}