import java.util.*;
class Solution {
    public int solution(String numbers) {
        Set<Integer> set = new TreeSet<>();

        for (int i = 1; i <= numbers.length(); i++) {
            combi("", numbers, set, i, 0);
        }
        return set.size();
    }

    public void combi(String target, String src, Set<Integer> set, int size, int next) {
        if (target.length() == size) {
            dfs("", target, set, new int[size]);
            return;
        }

        for(int i = next; i < src.length(); i ++) {
            combi(target + src.charAt(i), src, set, size, i + 1);
        }
    }

    public void dfs(String target, String src, Set<Integer> set, int [] v) {
        if(target.length() == src.length()) {
            int n = Integer.parseInt(target);
            if(isPrime(n)) {
                set.add(n);
            }
            return;
        }
        for(int i = 0; i < src.length(); i ++) {
            if (v[i] == 0) {
                v[i] = 1;
                dfs(target + src.charAt(i), src, set, v);
                v[i] = 0;
            }
        }

    }


    public boolean isPrime(int n) {
        if(n == 0 || n == 1) {
            return false;
        }

        for(int i = 2; i * i <= n; i ++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
