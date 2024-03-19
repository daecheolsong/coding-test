import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        Arrays.sort(plans, (p1, p2) -> p1[1].compareTo(p2[1]));
        Queue<D> pq = new LinkedList<>();
        
        int order = 1;
        for(String [] plan : plans) {
            pq.add(new D(plan[0], convert(plan[1]), Integer.parseInt(plan[2]), order++));
        }
        
        PriorityQueue<D> waitPq = new PriorityQueue<>((d1, d2) -> d2.order - d1.order);
        
        int curTime = 0;
        int idx = 0;
        
        while(!pq.isEmpty()) {
            D cur = pq.poll();
            if(pq.isEmpty()) {
                answer[idx++] = cur.title;
                continue;
            }
            
            D next = pq.peek();
            
            if(cur.time + cur.period > next.time) {
                waitPq.add(new D(cur.title, next.time, cur.time + cur.period - next.time ,cur.order));
                curTime = next.time;
            } else if(cur.time + cur.period == next.time) {
                answer[idx++] = cur.title;
                curTime = next.time;
            } else {
                answer[idx++] = cur.title;
                curTime = cur.time + cur.period;
                while(!waitPq.isEmpty()) {
                    D waitPlan = waitPq.poll();
                    
                    if(curTime + waitPlan.period > next.time) {
                        waitPq.add(new D(waitPlan.title, waitPlan.time - curTime + next.time, curTime + waitPlan.period - next.time, waitPlan.order));
                        curTime = next.time;
                        break;
                    } else if(curTime + waitPlan.period == next.time) {
                        answer[idx++] = waitPlan.title;
                        curTime = next.time;
                        break;
                    } else {
                        answer[idx++] = waitPlan.title;
                        curTime += waitPlan.period;
                    }
                }
            }
            
            
        }
        
        while(!waitPq.isEmpty()) {
            answer[idx++] = waitPq.poll().title;
        }
        
        
        return answer;
    }
    
    
    private int convert(String start) {
        StringTokenizer st = new StringTokenizer(start, ":");
        return Integer.parseInt(st.nextToken())* 60 + Integer.parseInt(st.nextToken());
    }
    
    private static class D {
        String title;
        int time;
        int period;
        int order;
        
        public D(String title, int time, int period, int order) {
            this.title = title;
            this.time = time;
            this.period = period;
            this.order = order;
        }
    }
}