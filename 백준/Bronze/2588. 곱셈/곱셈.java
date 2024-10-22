import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s1 = br.readLine();
        String s2 = br.readLine();
        
        for(int i = s2.length() - 1; i >= 0; i --) {
            bw.write(Integer.parseInt(s1) * (s2.charAt(i) - '0') +"\n");
        }
        bw.write(Integer.parseInt(s1) * Integer.parseInt(s2) + "\n");
        bw.flush();
    }
}