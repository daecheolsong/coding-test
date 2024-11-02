import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		char[] l = st.nextToken().toCharArray();
		char[] r = st.nextToken().toCharArray();

		if (l.length != r.length) {
			bw.write("0\n");
			bw.flush();
			return;
		}
		int answer = 0;
		for (int i = 0; i < l.length; i++) {
			if (l[i] == r[i]) {
                if(l[i] == '8') {
                    answer++;   
                }
			} else {
				break;
			}
		}
		bw.write(answer + "\n");
		bw.flush();

	}

}
