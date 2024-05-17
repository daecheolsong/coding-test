import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n + 1];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			int emptyIdx = n;

			int[] emptyArr = new int[1500];

			for (int i = 0; i < n; i++) {
				if ((arr[i] != i + 1) && emptyIdx != i) {
					int temp = arr[i];
					arr[i] = arr[emptyIdx];
					arr[emptyIdx] = temp;
					emptyIdx = i;
					emptyArr[cnt++] = emptyIdx + 1;
				}

				if (arr[i] != i + 1) {
					int swapIdx = 0;
					for (int j = 0; j <= n; j++) {
						if (arr[j] == i + 1) {
							swapIdx = j;
						}
					}

					int temp = arr[swapIdx];
					arr[swapIdx] = arr[emptyIdx];
					arr[emptyIdx] = temp;
					emptyIdx = swapIdx;
					emptyArr[cnt++] = swapIdx + 1;
				}
			}

			sb.append(cnt).append("\n");

			for (int i = 0; i < cnt; i++) {
				sb.append(emptyArr[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}