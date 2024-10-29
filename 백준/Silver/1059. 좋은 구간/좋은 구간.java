import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] aaaa) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int l = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[l + 1];
        
        for(int i = 0; i < l; i ++) {
            arr[i + 1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 0; i < l; i ++) {
            int s = arr[i];
            int e = arr[i + 1];
            for(int j = s + 1; j < e; j ++) {
                for(int k = j + 1; k < e; k ++) {
                    if(n >= j && n <= k) {
                        answer ++;
                    }
                }
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}