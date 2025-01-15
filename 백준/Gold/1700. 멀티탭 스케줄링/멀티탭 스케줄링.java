import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[k];
		
		int [] last = new int[101];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
			last[arr[i]] = Math.max(last[arr[i]], i + 1);
		}
		
		int cnt = 0;
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < k ; i ++) {
			if(set.contains(arr[i])) {
				continue;
			}

			if(set.size() < n) {
				set.add(arr[i]);
				continue;
			}
			
			
			
			int max = -1;
			int exElem = - 1;
			int subListSize = k - (i + 1);
			List<Integer> subList = new ArrayList<>();
			
			for(int e : set) {
				for(int j = i + 1; j < k; j ++) {
					subList.add(arr[j]);
				}
				int tmp = subList.contains(e) ? subList.indexOf(e) + 1 : subListSize;
				if(max < tmp) {
					max = tmp;
					exElem = e;
				}
				subList.clear();
			}
			
			set.remove(exElem);
			set.add(arr[i]);
			cnt++;
		}
		
		System.out.println(cnt);
		
		
		
	}
}
