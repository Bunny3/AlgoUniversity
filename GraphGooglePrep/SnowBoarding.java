import java.io.*;
import java.util.*;
class Graph {
  int vertices;
  ArrayList<ArrayList<Integer>> adjList;
  public Graph(int vertices) {
    this.vertices = vertices;
    adjList = new ArrayList<ArrayList<Integer>>();
    for(int i=0;i<vertices;i++) {
      adjList.add(new ArrayList<Integer>());
    }
  }

  public void addEdge(int u, int v) {
    adjList.get(u).add(v);
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
public class SnowBoarding {

  public static int dfs(Graph g,int src,boolean visited[]) {
    if(src == visited.length-1) {
      return 1;
    }
    visited[src] = true;
    int ans =0;
    for(int node:g.adjList.get(src)) {
      if(visited[node] == false) {
        ans = Math.max(ans,1+dfs(g,node,visited));
      }
    }
    visited[src] = false;
    return ans;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int NM[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int N = NM[0];
    int M = NM[1];
    Graph g = new Graph(N+1);
    for(int i=0;i<M;i++) {
      int uv[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      g.addEdge(uv[0], uv[1]);
    }

    boolean visited[] = new boolean[N+1];
    Arrays.fill(visited,false);
      int ans = dfs(g,1,visited);
      System.out.println(ans);
  }
}
