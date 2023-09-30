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
}
public class DiameterOfTree {

  static int ans;
  public static int Diameter(int src,Graph g,boolean visited[]) {
    visited[src] = true;
    if(g.adjList.get(src).size() == 0) {
      return 1;
    }
    // int max_ = Integer.MIN_VALUE;
    int max1 =0, max2=0;
    for(int node:g.adjList.get(src)) {
      if(visited[node] == false) {
        int h = Diameter(node, g, visited);
        if(h>max1) {
          max2 = max1;
          max1 = h;
        } else if(h>max2) {
          max2=h;
        }
      }
    }

    ans = (int)Math.max(ans,(max1+max2)+1);
    return (int)Math.max(max1,max2)+1;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(input.readLine());
    Graph g = new Graph(n);
    for(int i=0;i<n-1;i++) {
      int uv[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      g.addEdge(uv[0], uv[1]);
    }
    ans =0;
    boolean visited[] = new boolean[n+1];
    Arrays.fill(visited,false);
    int temp = Diameter(1,g,visited);
    if(temp > ans) {
      System.out.println(temp-1);
    } else {
    System.out.println(ans-1);
    }
  }
}
