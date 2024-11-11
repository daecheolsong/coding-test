import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Set<String> set = new TreeSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.substring(i));
        }

        for (String key : set) {
            System.out.println(key);
        }
    }
}