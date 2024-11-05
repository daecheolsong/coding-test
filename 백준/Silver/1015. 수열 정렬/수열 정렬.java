import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] arr = new int[n][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n ; i ++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a1, a2) -> a1[1] - a2[1]);
        for(int i = 0; i < n ; i++) {
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a1, a2) -> a1[0] - a2[0]);
        for(int i = 0; i < n; i ++) {
            System.out.print(arr[i][2] + " ");
        }
    }
}