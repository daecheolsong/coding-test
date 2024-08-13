import java.io.*;
import java.util.*;

public class Main {
    
    // e s w n
    public static int[] mvy = {0, 1, 0, -1};
    public static int[] mvx = {1, 0, -1, 0};
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        int [][] map = new int[n + 1][n + 1];
        
        for(int i = 0; i < k ; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;    
        }
        
        Queue<int[]> rotateQ = new LinkedList<>();
        int l = Integer.parseInt(br.readLine());
        
        // D = 1, L = 2;
        for(int i = 0; i < l; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int r = st.nextToken().equals("D") ? 1 : 2;
            rotateQ.add(new int[]{t, r});
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{1, 1, 0});
        map[1][1] = 2;
        int time = 0;
        int y = 1;
        int x = 1;
        int curD = 0;
        while(true) {
           
            int ny = y + mvy[curD];
            int nx = x + mvx[curD];
            time ++;
            
            if(ny <= 0 || ny > n || nx <= 0 || nx > n) {
                break;
            }
            if(map[ny][nx] == 2) {
                break;
            }
            if(map[ny][nx] == 0) {
                int[] bState = q.poll();
                map[bState[0]][bState[1]] = 0;
            }
            
            if(!rotateQ.isEmpty()) {
                int[] rState = rotateQ.peek();
                if(rState[0] == time) {
                    rotateQ.poll();
                    int nD = rState[1];
                    
                    if(nD == 1) {
                        curD = curD + 1 > 3 ? 0 : curD + 1;
                    }
                    
                    if(nD == 2) {
                        curD = curD - 1 < 0 ? 3 : curD - 1;
                    }
                }
                
            }
            map[ny][nx] = 2;
            q.add(new int[]{ny, nx, curD});
            y = ny;
            x = nx;
           
        }
        bw.write(time+"\n");
        bw.flush();
    }
}