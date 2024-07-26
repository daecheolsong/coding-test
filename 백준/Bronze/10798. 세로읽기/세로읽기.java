import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int l = 0;
        String a = br.readLine();
        l = Math.max(l, a.length());
        String b = br.readLine();
        l = Math.max(l, b.length());
        String c = br.readLine();
        l = Math.max(l, c.length());
        String d = br.readLine();
        l = Math.max(l, d.length());
        String e = br.readLine();
        l = Math.max(l, e.length());
        
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < l; i ++) {
            if(a.length() > i) {
                sb.append(a.charAt(i));
            }
            
            if(b.length() > i) {
                sb.append(b.charAt(i));
            }
            
            if(c.length() > i) {
                sb.append(c.charAt(i));
            }
            
            if(d.length() > i) {
                sb.append(d.charAt(i));
            }
            
            if(e.length() > i) {
                sb.append(e.charAt(i));
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        
    }
}