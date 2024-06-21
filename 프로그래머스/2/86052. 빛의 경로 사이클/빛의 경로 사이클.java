import java.util.*;
class Solution {
    public List<Integer> solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        int[][][] v = new int[grid.length][grid[0].length()][4];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                for (int k = 0; k < 4; k++) {
                    
                    Queue<State> q = new LinkedList<>();
                    q.add(new State(k, j, i, 0));
                
                    while(!q.isEmpty()) {
                        State cur = q.poll();
                        char movDir = grid[cur.y].charAt(cur.x);
                        v[cur.y][cur.x][cur.d] = 1;

                        if(movDir == 'S') {
                            if(cur.d == 0) {
                                cur.x -= 1;
                            }
                            if(cur.d == 1) {
                                cur.y -= 1;
                            }
                            if(cur.d == 2) {
                                cur.x += 1;
                            }
                            if(cur.d == 3) {
                                cur.y += 1;
                            }
                        }

                        if(movDir == 'L') {
                            if(cur.d == 0) {
                                cur.y += 1;
                                cur.d = 3;
                            } else if(cur.d == 1) {
                                cur.x -= 1;
                                cur.d = 0;
                            } else if(cur.d == 2) {
                                cur.y -= 1;
                                cur.d = 1;
                            } else if(cur.d == 3) {
                                cur.x += 1;
                                cur.d = 2;
                            }
                        }

                        if(movDir == 'R') {
                            if(cur.d == 0) {
                                cur.y -= 1;
                                cur.d = 1;
                            } else if(cur.d == 1) {
                                cur.x += 1;
                                cur.d = 2;
                            } else if(cur.d == 2) {
                                cur.y += 1;
                                cur.d = 3;
                            } else if(cur.d == 3) {
                                cur.x -= 1;
                                cur.d = 0;
                            }
                        }

                        if(cur.x == grid[0].length()) {
                            cur.x = 0;
                        }
                        if(cur.x < 0) {
                            cur.x = grid[0].length() - 1;
                        }

                        if(cur.y == grid.length) {
                            cur.y = 0;
                        }

                        if(cur.y < 0) {
                            cur.y = grid.length - 1;
                        }

                        if (cur.x == j && cur.y == i && cur.d == k) {
                            answer.add(cur.count + 1);
                            break;
                        }
                        if (v[cur.y][cur.x][cur.d] == 1) {
                            break;
                        }
                        q.add(new State(cur.d, cur.x, cur.y, cur.count + 1));
                    }
                }
            }
        }
        
        Collections.sort(answer);

        return answer;
    }


    private static class State {
        // 0 l 1 t 2 r 3 b
        int d;
        int x;
        int y;
        int count;
        public State(int d, int x, int y, int count) {
            this.d = d;
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}