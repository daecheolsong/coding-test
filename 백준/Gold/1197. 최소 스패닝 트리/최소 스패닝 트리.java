import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] p = new int[v + 1];
        for (int i = 0; i < v; i++) {
            p[i + 1] = i + 1;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(e1, e2, w));
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (find(cur.e1, p) != find(cur.e2, p)) {
                sum += cur.w;
                union(cur.e1, cur.e2, p);
            }
        }
        bw.write(sum+"\n");
        bw.flush();
    }

    public static int find(int n, int[] parent) {
        if (parent[n] == n) {
            return n;
        }
        parent[n] = find(parent[n], parent);
        return parent[n];
    }

    public static void union(int n1, int n2, int[] parent) {
        int n1Parent = find(n1, parent);
        int n2Parent = find(n2, parent);

        if (n1Parent > n2Parent) {
            parent[n1Parent] = n2Parent;
        } else {
            parent[n2Parent] = n1Parent;
        }
    }

    private static class Edge {
        int e1;
        int e2;
        int w;

        public Edge(int e1, int e2, int w) {
            this.e1 = e1;
            this.e2 = e2;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "e1=" + e1 +
                    ", e2=" + e2 +
                    ", w=" + w +
                    '}';
        }
    }

}
