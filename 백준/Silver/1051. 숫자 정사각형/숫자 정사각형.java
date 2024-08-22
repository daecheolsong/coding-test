import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int [][] arr = new int[N][M];
        
        for(int i = 0; i < N; i ++) {
            String s = br.readLine();
            for(int j = 0; j < M; j ++) {
                arr[i][j] = (int)(s.charAt(j) - '0');
            }
        }
        int answer = 1;
        int L = Math.min(M, N);
        
        for(int k = 0; k < L; k ++) {
            for(int i = 0; i < N - k ; i ++) {
                for(int j = 0; j < M - k ; j ++) {
                    if(arr[i][j] != arr[i][j + k]) {
                        continue;
                    }
                    if(arr[i][j] != arr[i + k][j + k]) {
                        continue;
                    }
                    if(arr[i][j] != arr[i + k][j]) {
                        continue;
                    }
                  
                    answer = k + 1;
                }
            }
        }
        answer *= answer;
        bw.write(answer + "\n");
        bw.flush();
    } 
}