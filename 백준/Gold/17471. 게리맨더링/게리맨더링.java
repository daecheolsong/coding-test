import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Node> nodeList = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i ++) {
			int pop = Integer.parseInt(st.nextToken());
			nodeList.add(new Node(i + 1, pop, new HashSet<>()));
		}
		
		for(int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int areaNum = Integer.parseInt(st.nextToken());
			Node nd = nodeList.get(i);
			
			for(int j = 0; j < areaNum; j ++) {
				int adjIdx = Integer.parseInt(st.nextToken());
				nd.adjList.add(nodeList.get(adjIdx - 1));
				nodeList.get(adjIdx - 1).adjList.add(nd);
			}
		}
		
		for(int i = 1; i <= n / 2; i ++) {
			int [] v = new int[n];
			addCase(v, i, nodeList, 0, 0);
		}
		System.out.println(answer == Integer.MAX_VALUE ? - 1 : answer);
	}
	
	private static void addCase(int [] v, int k, List<Node> nodeList, int next, int depth) {
		if(depth == k) {
			List<Node> part1 = new ArrayList<>();
			List<Node> part2 = new ArrayList<>();
			for(int i = 0; i < nodeList.size(); i ++) {
				if(v[i] == 1) {
					part1.add(nodeList.get(i));
				} else {
					part2.add(nodeList.get(i));
				}
			}
			
			int [] visit = new int[nodeList.size()];			
			Queue<Integer> q = new LinkedList<>();
			
			q.add(part1.get(0).idx);
			visit[part1.get(0).idx - 1] = 1;
			
			int count1 = 1;
			while(!q.isEmpty()) {
				int idx = q.poll();
				for(Node n : nodeList.get(idx - 1).adjList) {
					if(visit[n.idx - 1] == 0 && part1.contains(n)) {
						q.add(n.idx);
						count1++;
						visit[n.idx - 1] = 1;
					}
				}
				
			}
			
			if(count1 != part1.size()) {
				return;
			}
			
			int [] visit2 = new int[nodeList.size()];			
			Queue<Integer> q2 = new LinkedList<>();
			
			q2.add(part2.get(0).idx);
			visit2[part2.get(0).idx - 1] = 1;
			
			int count2 = 1;
			while(!q2.isEmpty()) {
				int idx = q2.poll();
				for(Node n : nodeList.get(idx - 1).adjList) {
					if(visit2[n.idx - 1] == 0 && part2.contains(n)) {
						q2.add(n.idx);
						count2++;
						visit2[n.idx - 1] = 1;
					}
				}
				
			}
			
			if(count2 != part2.size()) {
				return;
			}
			
			int sum1 = 0;
			for(int i = 0; i < part1.size(); i ++) {
				sum1 += part1.get(i).population;
			}
			int sum2 = 0;
			for(int i = 0; i < part2.size(); i ++) {
				sum2 += part2.get(i).population;
			}
			answer = Math.min(answer, Math.abs(sum2 - sum1));
			return;
		}
		for(int i = next; i < nodeList.size(); i ++) {
			v[i] = 1;
			addCase(v, k, nodeList, i + 1, depth + 1);
			v[i] = 0;
		}
		
	}

	private static class Node {
		int idx;
		int population;
		Set<Node> adjList;
		
		public Node(int idx,int p, Set<Node> l) {
			this.idx = idx;
			this.population = p;
			this.adjList = l;
		}
	
		
		@Override
		public int hashCode() {
			return Objects.hash(idx);
		}
		
		@Override
		public boolean equals(Object o) {
			return ((Node)o).idx == this.idx;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder sb= new StringBuilder();
			for(Node n : adjList) {
				sb.append(n.idx).append(" ");
			}
			
			return this.idx + " [ "  + sb.toString() + " ] ";
		}
	}
}
