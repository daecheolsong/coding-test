import java.util.*;

class Solution
{
    public static int[] mvx = {1, 0, -1, 0};
    public static int[] mvy = {0, 1, 0, -1};
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int [][] map = new int[n][n];
            dfs(map, n, 0, 0, 1, 0);
            System.out.println("#" + test_case);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void dfs(int[][] map, int n, int x, int y, int count, int d) {
        if (isAllVisit(map)) {
            return;
        }
        map[y][x] = count;
        int nx = x + mvx[d];
        int ny = y + mvy[d];

        if (isIn(nx, ny, n) && map[ny][nx] == 0) {
            dfs(map, n, nx, ny, count + 1, d);
        } else {
            dfs(map, n, x, y, count, (d + 1) % 4);
        }

    }

    public static boolean isAllVisit(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isIn(int nx, int ny, int n) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }
}