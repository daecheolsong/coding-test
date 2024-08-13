import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        
        int [] comp = new int[101];
        
        for(int i = 0; i < n; i++) {
            if(comp[arr[i]] == 1) {
                answer++;
                continue;
            }
            comp[arr[i]] = 1;
        }
        
        bw.write(answer+"\n");
        bw.flush();
    }
}