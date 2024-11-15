import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Set<String> set = new HashSet<>();
		for (int k = 1; k <= s.length(); k++) {
			for (int i = 0; i <= s.length() - k; i++) {
				set.add(s.substring(i, i + k));
			}
		}
		System.out.println(set.size());

	}
}