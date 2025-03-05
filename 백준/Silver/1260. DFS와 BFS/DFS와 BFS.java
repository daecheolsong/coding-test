import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Comparator;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input= br.readLine().split(" ");
		int n_count=Integer.parseInt(input[0]);
		int addEdge=Integer.parseInt(input[1]);
		int start_node=Integer.parseInt(input[2]);
		Graph g = new Graph(n_count);
		Graph g2= new Graph(n_count);
		while(addEdge>0)
		{
			String [] add= br.readLine().split(" ");
			g.addEdge(Integer.parseInt(add[0]), Integer.parseInt(add[1]));
			g2.addEdge(Integer.parseInt(add[0]), Integer.parseInt(add[1]));
		addEdge--;
		}
		
		g.dfsR(start_node);
		System.out.println();
		g2.bfs(start_node);
		
		

	}

}

class Graph{
	Node [] nodes;
		
	Graph(int n_count){
		nodes= new Node[n_count];
		for(int i=0;i<n_count;i++) // 노드 번호 개수만큼 추가
		{
			nodes[i]=new Node(i+1);
		}
	}
	public void visit(Node n1) {
		System.out.print(n1.data+" ");
		
	}
	
	public void addEdge(int n1, int n2) // 인접노드 관계 정의
	{
		Node a = nodes[n1-1];
		Node b = nodes[n2-1];
		
		if(!b.adjacent.contains(a))
		{
			b.adjacent.add(a);
		}
		if(!a.adjacent.contains(b))
		{
			a.adjacent.add(b);
		}
	}
	public void bfs()
	{
		bfs(0);
	}
	public void bfs(int start_node)
	{
		Node root = nodes[start_node-1];
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		root.marked=true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			LinkedList<Node>sort=n.adjacent;
			sort.sort(new Comparator<Node>() { // 인접노드가 여러개인경우
												// 작은노드부터 방문하기위해
												// 내림차순으로 정렬 -> stack
				public int compare(Node n1, Node n2)
				{
					return n1.data-n2.data;
				}
			});
			
			Iterator<Node>itr=sort.iterator();
			while(itr.hasNext()) // 인접노드가 없을때까지
			{
				Node adj = itr.next(); // 인접노드를 받아서
				if(adj.marked==false) { // 그 인접노드가 방문하지 않은것이라면
					adj.marked=true; // 방문표시하고
					q.add(adj); // 큐에 추가한다.
				}
			}
			visit(n);
		}
		
	}

	public void dfs()
	{
		dfs(0);
	}
	
	public void dfs(int start_node)
	{
		Stack<Node> s= new Stack<Node>();
		Node root = nodes[start_node-1];
		s.push(root);
		root.marked=true;
		while(!s.isEmpty())
		{
			Node n= s.pop();
			LinkedList<Node>sort=n.adjacent;
			sort.sort(new Comparator<Node>() {
				public int compare(Node n1, Node n2)
				{
					return n2.data-n1.data;
				}
			});
			
			Iterator<Node>itr=sort.iterator();
			
			while(itr.hasNext())
			{
				Node adj= itr.next();
				if(adj.marked==false)
				{
					adj.marked=true;
					s.add(adj);
				}
			}
			visit(n);
		}
	}
	

public void dfsR(Node r) {
	if(r==null)
		return;
	r.marked=true;
	visit(r);
	LinkedList<Node>sort=r.adjacent;
	sort.sort(new Comparator<Node>() {
		public int compare(Node n1,Node n2)
		{
			return n1.data-n2.data;
		}
	});
	Iterator<Node>itr=sort.iterator();

	while(itr.hasNext())
	{
		Node adj= itr.next();
		if(adj.marked==false)
		{
			dfsR(adj);
		}
	}
}
public void dfsR(int start_node)
{
	Node n = nodes[start_node-1];
	dfsR(n);
	}
}

class Node {
	boolean marked; // 노드 방문여부
	int data; // 노드 번호
	LinkedList<Node>adjacent; // 인접한 노드 저장
	
	Node(int data)
	{
		this.data=data;
		this.marked=false;
		adjacent= new LinkedList<Node>();
	}

	
	
	
}