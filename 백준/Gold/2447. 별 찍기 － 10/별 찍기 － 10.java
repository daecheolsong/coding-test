import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char [][] map = new char[n][n];
		
		printStar(0, 0, n, map);
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n ; i ++) {
			for(int j = 0; j < n; j ++) {
				sb.append(map[i][j] == '*' ? '*' : ' ');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void printStar(int r, int c, int n, char [][] map) {
		
		if(n == 1) {
			map[r][c] = '*';
			return;
		}
		
		int size = n / 3;
		int idx = 0;
		for(int i = r; i < r + n; i += size) {
			for(int j = c; j < c + n; j += size) {
				idx++;
				if(idx != 5) {
					printStar(i, j, size, map);
				} 
			}
		}
		
	}
}
