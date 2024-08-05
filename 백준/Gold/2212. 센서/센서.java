import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int [] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());    
        }
        
        Arrays.sort(arr);
        
        Integer [] diff = new Integer[n - 1];
        
        for(int i = 0; i < n - 1; i ++) {
            diff[i] = arr[i + 1] - arr[i];
        }
        
        Arrays.sort(diff, (i1, i2) -> i2 - i1);
        
        int answer = 0;
        
        for(int i = k - 1; i < n - 1; i ++) {
            answer += diff[i];    
        }
        bw.write(answer+"\n");
        bw.flush();
    }
}