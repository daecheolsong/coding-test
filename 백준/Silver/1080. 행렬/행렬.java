import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] src = new char[N][M];
		char[][] target = new char[N][M];

		for (int i = 0; i < N; i++) {
			src[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			target[i] = br.readLine().toCharArray();
		}

		int answer = 0;

		for (int i = 0; i <= N - 3; i++) {
			for (int j = 0; j <= M - 3; j++) {
				if (src[i][j] == target[i][j]) {
					continue;
				}
				for (int k = i; k < i + 3; k++) {
					for (int l = j; l < j + 3; l++) {
						src[k][l] = src[k][l] == '0' ? '1' : '0';
					}
				}
				answer++;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (src[i][j] != target[i][j]) {
					bw.write("-1\n");
					bw.flush();
					return;
				}
			}
		}
		bw.write(answer + "\n");
		bw.flush();

	}

}