import java.io.*;
import java.util.*;

class Node implements Comparator<Node> {
  int v;
  long weight;
  public Node(int v, long w) {
    this.v = v;
    this.weight = w;
  }

  public Node() {

  }
  public int compare(Node a, Node b) {
    return (int)(a.weight-b.weight);
  }
}
class Graph {
  int vertices;
  ArrayList<ArrayList<Node>> adjList;
  PriorityQueue<Node> pq;
  long dist[];
  public Graph(int v) {
    this.vertices = v;
    this.dist = new long[vertices];
    Arrays.fill(dist, Integer.MAX_VALUE);
    this.adjList = new ArrayList<ArrayList<Node>>();
    for(int i=0;i<vertices;i++) {
      this.adjList.add(new ArrayList<Node>());
    }
    pq = new PriorityQueue<Node>(vertices,new Node());
  }

  public void addEdge(int u, int v, long w) {
    adjList.get(u).add(new Node(v,w));
  }

  public void Dijkstra(int src) {
    dist[src] = 0;
    pq.add(new Node(src,0));
    while(!pq.isEmpty()) {
      Node node = pq.poll();
      for(Node neigh: adjList.get(node.v)) {
        if(dist[node.v]+neigh.weight < dist[neigh.v]) {
          dist[neigh.v] = dist[node.v]+neigh.weight;
          pq.offer(new Node(neigh.v,dist[neigh.v]));
        }
      }
    }
  }
}
public class FlightCoupons {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int NM[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int N = NM[0];
    int M = NM[1];
    Graph g = new Graph(N+1);
    Graph b = new Graph(N+1);
    for(int i=0;i<M;i++) {
      long uvc[] = Arrays.stream(input.readLine().trim().split(" ")).mapToLong(s->Long.parseLong(s)).toArray();
      g.addEdge((int)uvc[0],(int)uvc[1],uvc[2]);
      b.addEdge((int)uvc[1],(int)uvc[0],uvc[2]);
    }
    g.Dijkstra(1);
    b.Dijkstra(N);

    long ans=Long.MAX_VALUE;
    for(int i=1;i<=N;i++){
      for(Node it:g.adjList.get(i)) {
        long res=(long)((g.dist[i]+b.dist[it.v])+it.weight/2);
        ans=Math.min(ans,res);
      }
    }
    System.out.println(ans);
  }
}