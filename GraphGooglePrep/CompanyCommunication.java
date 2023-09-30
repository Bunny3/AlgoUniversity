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
    adjList.get(v).add(u);
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
};
public class CompanyCommunication {
  public static void dfs(int src,Graph g, boolean visited[]) {
    visited[src] = true;
    for(int node:g.adjList.get(src)) {
      if(visited[node] == false) {
        dfs(node,g,visited);
      }
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int nm[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int n = nm[0];
    int m = nm[1];
    Graph g = new Graph(m+n);
    for(int i=1;i<=n;i++) {
      int nedge[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      for(int j=1;j<nedge.length;j++) {
        g.addEdge(nedge[j]+n,i);
      }
    }

    // g.printGraph();
    boolean visited[] = new boolean[m+n+1];
    dfs(1,g,visited);
    for(int i=1;i<=n;i++) {
      if(visited[i] == false) {
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }
}
