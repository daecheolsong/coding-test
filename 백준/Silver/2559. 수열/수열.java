import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int [] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < n ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxSum = 0;
        
        for(int i = 0; i < k; i ++) {
            maxSum += arr[i];
        }
        int temp = maxSum;
        
        for(int i = k; i < n; i ++) {
            temp -= arr[i-k];
            temp += arr[i];
            maxSum = Math.max(maxSum, temp);
        }
        
        bw.write(maxSum+"\n");
        bw.flush();
        
    }
}