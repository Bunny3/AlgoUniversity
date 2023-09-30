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

public class RunCorruptedCity {

  public static int dfs(int src,Graph g, boolean visited[]) {
    visited[src] = true;
    if(g.adjList.get(src).size() == 0) return src;

    int totalCost = 0;
    for(int node:g.adjList.get(src)) {
      if(visited[node] == false) {
        totalCost+=dfs(node,g,visited);
      }
    }
    return (totalCost-(totalCost/10));
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int nx[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int n = nx[0];
    int x = nx[1];
    Graph g = new Graph(n);
    for(int i=0;i<n-1;i++) {
      int uv[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      g.addEdge(uv[0], uv[1]);
    }
    // g.printGraph();
    boolean visited[] = new boolean[n+1];
    Arrays.fill(visited,false);
    int ans = dfs(1,g, visited);
    // System.out.println(ans);
    if(ans < x)
      System.out.println("NO");
    else
      System.out.println("YES");
  }
}
