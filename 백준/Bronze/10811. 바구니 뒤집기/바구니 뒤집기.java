import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] b = new int[n + 1];

        for (int i = 0; i < n; i++) {
            b[i + 1] = i + 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            int diff = i2 - i1 + 1;
            int[] temp = new int[diff];
            for (int j = 0; j < diff; j++) {
                temp[j] = b[i2 - j];
            }
            for (int j = 0; j < diff; j++) {
                b[i1 + j] = temp[j];
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(b[i + 1] + " ");
        }
        bw.flush();
    }

}