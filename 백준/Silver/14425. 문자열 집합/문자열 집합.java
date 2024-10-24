import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
     
        for(int i = 0; i < n; i ++) {
            set.add(br.readLine());
        }
        String[] tars = new String[m];
        
        for(int i = 0; i < m ; i++) {
            tars[i] = br.readLine();
        }
        int answer = 0;
        for(int i = 0; i < m ; i++) {
            if(set.contains(tars[i])) {
                answer++;
            }
        }
        
        bw.write(answer + "\n");
        bw.flush();
    }
}