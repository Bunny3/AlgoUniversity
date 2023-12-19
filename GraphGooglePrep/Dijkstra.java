import java.io.*;
import java.util.*;
class Graph {
  int vertices;
  int dist[];
  PriorityQueue<Node> pq;
  Set<Integer> settled;
  List<List<Node>> adjList;
  public Graph(int vertices) {
    this.vertices = vertices;
    dist = new int[this.vertices];
    settled = new HashSet<Integer>();
    pq = new PriorityQueue<Node>(vertices,new Node());
  }

  public void Dijkstra(List<List<Node>> adjList, int src) {
    this.adjList = adjList;
    for(int i=0; i< vertices;i++) {
      dist[i] = Integer.MAX_VALUE;
    }
    pq.add(new Node(src, 0));

    dist[src] = 0;
    while(settled.size()!=vertices) {
      if(pq.size() == 0) return;
      int u = pq.remove().node;
      if(settled.contains(u))
        continue;
      settled.add(u);
      e_Neighbours(u);
    }

  }

  public void e_Neighbours(int u) {
    int edgeDistance = -1;
    int newDistance = -1;
    for(int i=0;i<adjList.get(u).size();i++) {
      Node v = adjList.get(u).get(i);
      if(!settled.contains(v.node)) {
        edgeDistance = v.cost;
        newDistance = dist[u]+edgeDistance;
        if(newDistance<dist[v.node]){
          dist[v.node] = newDistance;
        }
        pq.add(new Node(v.node, dist[v.node]));
      }
    }
  }
};

class Node implements Comparator<Node> {
  public int node;
  public int cost;
  public Node() {}
  public Node(int node,int cost) {
    this.node = node;
    this.cost = cost;
  }

  public int compare(Node node1, Node node2) {
    return node1.cost-node2.cost;
  }
};
public class Dijkstra {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(input.readLine());
    List<List<Node>> adj = new ArrayList<List<Node>>();
    for(int i=0;i<N;i++) {
      adj.add(new ArrayList<Node>());
    }

    for(int i=0;i<6;i++) {
      int uvc[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      adj.get(uvc[0]).add(new Node(uvc[1],uvc[2]));
    }

    Graph g = new Graph(N);
    g.Dijkstra(adj,0);
    System.out.println("The shorted path from node :");
    for (int i = 0; i < g.dist.length; i++)
    System.out.println(0 + " to " + i + " is "+ g.dist[i]);
  }
}
