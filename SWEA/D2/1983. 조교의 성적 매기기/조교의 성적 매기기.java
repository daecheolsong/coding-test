import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		String[] score = new String[] { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] students = new int[n][2];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int sum = Integer.parseInt(st.nextToken()) * 35 + Integer.parseInt(st.nextToken()) * 45
						+ Integer.parseInt(st.nextToken()) * 20;
				students[i] = new int[] { sum, i + 1 };
			}
			Arrays.sort(students, (s1, s2) -> s2[0] - s1[0]);

			int rank = 0;

			for (int i = 0; i < n; i++) {
				if (students[i][1] == k) {
					rank = i;
					break;
				}
			}

			int size = n / 10;

			sb.append(score[rank / size]).append("\n");
		}
		System.out.println(sb);

	}

}