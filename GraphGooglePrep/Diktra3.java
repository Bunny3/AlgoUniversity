import java.io.*;
import java.util.*;
class Node implements Comparator<Node>{
  int v,weight;
  public Node(int v, int w){
  this.v = v;
  this.weight = w;
  }
  public Node(){}
  public int compare(Node n1, Node n2) {
    return n1.weight-n2.weight;
  }
};
class Graph {
  int vertices;
  ArrayList<ArrayList<Node>> adjList;
  PriorityQueue<Node> pq;
  int dist[];
  public Graph(int vertices) {
    this.vertices = vertices;
    adjList = new ArrayList<ArrayList<Node>>();
    for(int i=0;i<vertices;i++) {
      adjList.add(new ArrayList<Node>());
    }
    dist = new int[vertices];
    Arrays.fill(dist, Integer.MAX_VALUE);
    pq = new PriorityQueue<Node>(vertices,new Node());
  }

  public void addEdge(int u, int v, int w) {
    adjList.get(u).add(new Node(v,w));
    adjList.get(v).add(new Node(u,w));
  }

  public void Dijkstra(int src) {
    dist[src] = 0;
    pq.add(new Node(src,0));
    while(!pq.isEmpty()) {
      Node node = pq.remove();
      for(Node neigh: adjList.get(node.v)) {
        if(dist[node.v]+neigh.weight < dist[neigh.v]) {
          dist[neigh.v]=dist[node.v]+neigh.weight;
          pq.add(new Node(neigh.v,dist[neigh.v]));
        }
      }
    }
  }
}
public class Diktra3 {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(input.readLine());
    int M = Integer.parseInt(input.readLine());
    int src = Integer.parseInt(input.readLine());
    Graph g = new Graph(N);
    for(int i=0;i<M;i++) {
      int uvc[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      g.addEdge(uvc[0],uvc[1],uvc[2]);
    }
    g.Dijkstra(src);
    System.out.println("The shorted path from node :");
    for (int i = 0; i < g.dist.length; i++)
    System.out.println(src + " to " + i + " is "+ g.dist[i]);
  }
}
