import java.io.*;
import java.util.*;
class Node implements Comparator<Node>{
  int v;
  long w;
  public Node(int v,long w) {
    this.w = w;
    this.v = v;
  }
public Node() {}
  public int compare(Node n1,Node n2) {
    return Long.compare(n1.w, n2.w);
  }
};

class Graph{ 
  int vertices;
  ArrayList<ArrayList<Node>> adjList;
  PriorityQueue<Node> pq;
  long dist[];

  public Graph(int v) {
    vertices = v;
    adjList = new ArrayList<ArrayList<Node>>();
    for(int i=0;i<vertices;i++) {
      adjList.add(new ArrayList<Node>());
    }
    dist = new long[vertices];
    Arrays.fill(dist, Integer.MAX_VALUE);
    pq = new PriorityQueue<Node>(vertices,new Node());
  }
  public void addEdge(int u, int v, int w) {
    adjList.get(u).add(new Node(v,w));
  }
  public void Dijktra(int src) {
    dist[src-1] = 0;
    pq.add(new Node(src-1,0));
    while(!pq.isEmpty()) {
      Node node = pq.remove();
      // System.out.println(node.v+"--"+node.w);
      for(Node neigh: adjList.get(node.v)) {
        if(dist[neigh.v]>dist[node.v]+neigh.w) {
          dist[neigh.v]=dist[node.v]+neigh.w;
          pq.add(new Node(neigh.v,dist[neigh.v]));
        }
      }
    }
  }
  public void printGraph() {
    for(int i=0;i<vertices;i++) {
      System.out.print(i+"===>");
      for(Node n: adjList.get(i)){
        System.out.print(n.v+","+n.w+"||");
      }
      System.out.println();
    }
  }
}
public class ShortestPath1 {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int nm[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int N = nm[0];
    int M = nm[1];
    Graph g = new Graph(N);
    for(int i=0;i<M;i++) {
      int uvc[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      g.addEdge(uvc[0]-1,uvc[1]-1,uvc[2]);
    }
    // g.printGraph();
    g.Dijktra(1);
    // System.out.println("The shorted path from node :");
    for (int i = 0;i < g.dist.length; i++)
      System.out.print(g.dist[i]+" ");
  }
}
