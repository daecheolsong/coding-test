import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n ; i++) {
            dq.add(i + 1);
        }

        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            answer += find(dq, arr[i]);
        }

        bw.write(answer + "\n");
        bw.flush();

    }

    public static int find(LinkedList<Integer> dq, int target) {
        int cnt = 0;


        int targetIdx = dq.indexOf(target);
        int halfIdx = dq.size() % 2 == 0 ? dq.size() / 2 - 1 : dq.size() / 2;


        if (targetIdx <= halfIdx) {
            for (int i = 0; i < targetIdx; i++) {
                dq.addLast(dq.poll());
                cnt++;
            }
        } else {
            for (int i = 0; i < dq.size() - targetIdx; i++) {
                dq.addFirst(dq.pollLast());
                cnt++;
            }
        }
        dq.poll();

        return cnt;
    }



}
