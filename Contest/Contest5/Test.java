import java.io.*;
import java.util.*;

class Graph {
  int vertices;
  ArrayList<ArrayList<Integer>> adjList;
  public Graph(int vertices) {
    this.vertices = vertices;
    adjList = new ArrayList<ArrayList<Integer>>();
    for(int i=0;i<=vertices;i++) {
      adjList.add(new ArrayList<Integer>());
    }
  }

  public void addEdge(int u, int v) {
    adjList.get(u).add(v);
    // adjList.get(v).add(u);
  }

  public void printGraph() {
    System.out.println("This is graph");
    System.out.println();
    for(int i=1;i<=vertices;i++) {
      System.out.print("From vertices "+i+" --> ");
      for(int j:adjList.get(i)) {
        System.out.print(j+" ");
      }
      System.out.println();
    }
  }
}
public class Test {

  static int ans;
  public static int Diameter(int src,Graph g,boolean visited[]) {
    visited[src] = true;
    if(g.adjList.get(src).size() == 0) {
      return 1;
    }
    int max_ = Integer.MIN_VALUE;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    for(int node:g.adjList.get(src)) {
      if(visited[node] == true) {
        pq.add(Diameter(node, g,visited));
      }
    }
    int firstMax= pq.poll();
    int secondMax = Integer.MIN_VALUE;
    if(pq.isEmpty() == false) {
      secondMax = pq.poll();
    }

    ans = (int)Math.min(ans,(firstMax+secondMax)+1);
    return max_+1;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(input.readLine());
    Graph g = new Graph(n);
    for(int i=0;i<n-1;i++) {
      int uv[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      g.addEdge(uv[0], uv[1]);
    }
    // g.printGraph();
    ans =0;
    boolean visited[] = new boolean[n+1];
    Arrays.fill(visited,false);
    int temp = Diameter(1,g,visited);
    System.out.println(ans);
  }
}
