import java.io.*;
import java.util.*;
class Node implements Comparator<Node>{
  int v;
  long weight;
  public Node(int v, long w) {
  this.v = v;
  this.weight = w;
  }
  public Node(){}
  public int compare(Node n1, Node n2) {
    return (int)(n1.weight-n2.weight);
  }    
  // public long getWeight(){
  //   return this.weight;
  //   }
};
class Graph {
  int vertices;
  HashMap<Integer,ArrayList<Node>> adjList;
  PriorityQueue<Node> pq;
  long dist[];
  public Graph(int vertices) {
    this.vertices = vertices;
    adjList = new HashMap<Integer,ArrayList<Node>>();
    for(int i=1;i<=vertices;i++) {
      adjList.put(i,new ArrayList<Node>());
    }
    dist = new long[vertices+1];
    Arrays.fill(dist, Long.MAX_VALUE);
    // Comparator<Node> NodeComparator= Comparator.comparingLong(Node::getWeight);
    pq = new PriorityQueue<Node>(new Node());
  }

  public void addEdge(int u, int v, long w) {
    adjList.get(u).add(new Node(v,w));
    // adjList.get(v).add(new Node(u,w));
  }

  public void Dijkstra(int src) {
    // dist[src] = 0;
    boolean visited[] = new boolean[vertices+1];
    Arrays.fill(visited,false);
    // visited[src] = 1;
    pq.add(new Node(src,0));
    while(!pq.isEmpty()) {
      Node node = pq.remove();
      if(visited[node.v] == true) continue;
      visited[node.v]=true;
      dist[node.v] = node.weight;
      for(Node neigh: adjList.get(node.v)) {
        // if(dist[node.v]+neigh.weight < dist[neigh.v]) {
        //   dist[neigh.v]=dist[node.v]+neigh.weight;
          pq.add(new Node(neigh.v,node.weight+neigh.weight));
        // }
      }
    }
  }
}
public class FlightCoupon {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int NM[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int N = NM[0];
    int M = NM[1];
    Graph g = new Graph(N);
    Graph b = new Graph(N);
    for(int i=0;i<M;i++) {
      long uvc[] = Arrays.stream(input.readLine().trim().split(" ")).mapToLong(s->Long.parseLong(s)).toArray();
      g.addEdge((int)uvc[0],(int)uvc[1],uvc[2]);
      b.addEdge((int)uvc[1],(int)uvc[0],uvc[2]);
    }
    g.Dijkstra(1);
    b.Dijkstra(N);
    // System.out.println("The shorted path from node :");
    // for (int i = 1; i < g.dist.length; i++)
    // System.out.println(1 + " to " + i + " is "+ g.dist[i]);

    // System.out.println("The shorted path from node :");
    // for (int i = 1; i < g.dist.length; i++)
    // System.out.println(N + " to " + i + " is "+ b.dist[i]);

    long ans=Long.MAX_VALUE;
    for(int i=1;i<=N;i++){
      for(Node it:g.adjList.get(i)){
        long res=(long)((g.dist[i]+b.dist[it.v])+it.weight/2);
        ans=Math.min(ans,res);
      }
    }
    System.out.println(ans);
  }
}
