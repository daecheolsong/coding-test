import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] f = new char[26];
		char[] s = br.readLine().toCharArray();

		for (int i = 0; i < s.length; i++) {
			f[s[i] - 'A']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 25; i >= 0; i--) {
			while (f[i] > 1) {
				sb.insert(0, (char) (i + 'A'));
				sb.append((char) (i + 'A'));
				f[i] -= 2;
			}
		}
		int count = 0;
		for (int i = 25; i >= 0; i--) {
			if (f[i] > 0) {
				if (count == 1) {
					System.out.println("I'm Sorry Hansoo");
					return;
				}
				sb.insert(sb.length() / 2, (char) (i + 'A'));
				count++;
			}
		}
		System.out.println(sb);
	}
}