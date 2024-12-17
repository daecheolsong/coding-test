import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] arsg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Set<Integer> set = new TreeSet<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i ++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i ++) {
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num)) {
                set.remove(num);
            }
        }
        
        if(set.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(set.size());
            for(Integer a : set) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}