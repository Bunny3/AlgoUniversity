import java.util.*;
import java.io.*;

class Node implements Comparator<Node>{
  int to;
  int weight;
  public Node(){}
  public Node(int to,int weight) {
    this.to = to;
    this.weight = weight;
  }
  public int compare(Node n1,Node n2) {
    return n1.weight-n2.weight;
  }
};
class Graph {
  int vertices;
  int dist[];
  PriorityQueue<Node> pq;
  ArrayList<ArrayList<Node>> adjList;
  public Graph(int vertices) {
    this.vertices = vertices;
    dist = new int[vertices];
    Arrays.fill(dist,Integer.MAX_VALUE);
    pq = new PriorityQueue<Node>(vertices,new Node());
    adjList = new ArrayList<ArrayList<Node>>();
    for(int i=0;i<vertices;i++) {
      adjList.add(new ArrayList<Node>());
    }
  }

  public void addEdge(int u,int v, int w) {
    adjList.get(u).add(new Node(v,w));
    adjList.get(v).add(new Node(u,w));
  }

  public void Dijkstra(int src) {
    dist[src] = 0;
    pq.add(new Node(src,0));
    while(!pq.isEmpty()) {
      Node node = pq.remove();
      for(Node neighNode: adjList.get(node.to)) {
          if(dist[node.to]+neighNode.weight < dist[neighNode.to]) {
            dist[neighNode.to] = dist[node.to]+neighNode.weight;
            pq.add(new Node(neighNode.to,dist[neighNode.to]));
          }
    }
  }
}
}
public class Dijktra1 {
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
// 9
// 14
// 0
// 0 1 4
// 0 7 8
// 1 2 8
// 1 7 11
// 2 3 7
// 2 8 2
// 2 5 4
// 3 4 9
// 3 5 14
// 4 5 10
// 5 6 2
// 6 7 1
// 6 8 6
// 7 8 7