import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			Set<Integer> set = new HashSet<Integer>();
			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {

				int a = Integer.parseInt(br.readLine());
				if (set.contains(a)) {
					set.remove(a);
					continue;
				}
				set.add(a);
			}

			sb.append(set.size());
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
