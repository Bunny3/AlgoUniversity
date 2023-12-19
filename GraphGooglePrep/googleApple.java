import java.io.*;
import java.util.*;
class Node implements Comparator<Node> {
 int v;
 int w;
 public Node(int v,int w) {
  this.v = v;
  this.w = w;
 }
 public Node() {
 }
public int compare(Node n1, Node n2) {
  return n1.w - n2.w;
}
}

class Graph {
  int vertices;
  ArrayList<ArrayList<Node>> adjList;
  int dist[];
  PriorityQueue<Node> pq;
  public Graph(int vertices){
    this.vertices=vertices;
    pq = new PriorityQueue<Node>(new Node());
    dist = new int[vertices+1];
    Arrays.fill(dist,Integer.MAX_VALUE);
    adjList = new ArrayList<ArrayList<Node>>();
    for(int i=0;i<vertices+1;i++) {
      adjList.add(new ArrayList<Node>());
    }
  }
  public void addEdge(int u, int v, int w) {
    adjList.get(u).add(new Node(v,w));
  }
  public void printGraph() {
    for(int i=1;i<=vertices;i++) {
      System.out.print("Node "+i+" --> ");
      for(Node neigh:adjList.get(i)) {
        System.out.print("( "+neigh.v+ ","+ neigh.w+" )");
      }
      System.out.println();
    }
  }
  public void Dijkstra(int src) {
    dist[src] = 0;
    pq.add(new Node(src,0));
    while(!pq.isEmpty()) {
      Node node = pq.remove();
      for(Node neigh:adjList.get(node.v)) {
        if(dist[node.v]+neigh.w < dist[neigh.v]) {
          dist[neigh.v] = dist[node.v]+neigh.w;
          pq.add(new Node(neigh.v,dist[neigh.v]));
        }
      }
    }
  }
};
public class googleApple {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int NM[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int N = NM[0];
    int M = NM[1];
    Graph g = new Graph(N);
    Graph a = new Graph(N);
    Graph c = new Graph(N);
    for(int i=0;i<M;i++) {
      int uvga[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      g.addEdge(uvga[0], uvga[1], uvga[2]);
      a.addEdge(uvga[0], uvga[1], uvga[3]);
    }
    // g.printGraph();
    // a.printGraph();
    g.Dijkstra(1);
    a.Dijkstra(1);
    for(int i=1;i<=N;i++) {
      for(int j=0;j<g.adjList.get(i).size();j++) {
        int cry =0;
        int to = g.adjList.get(i).get(j).v;
        int wg = g.adjList.get(i).get(j).w;
        int wa = a.adjList.get(i).get(j).w;
        if(g.dist[to] != wg+g.dist[i]) {
          cry++;
        }
        if(a.dist[to] != wa+a.dist[i]) {
          cry++;
        }
        c.addEdge(i, to, cry);
      }
    }
    c.Dijkstra(1);
    // for(int i=1;i<N+1;i++) {
    //   System.out.print(g.dist[i]+" ");
    // }
    // System.out.println();
    // for(int i=1;i<N+1;i++) {
    //   System.out.print(a.dist[i]+" ");
    // }
    // System.out.println();
    for(int i=1;i<N+1;i++) {
      System.out.print(c.dist[i]+" ");
    }
    System.out.println();
    System.out.println(c.dist[N]);
  }
}
