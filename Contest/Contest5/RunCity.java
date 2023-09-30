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

public class RunCity {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int nx[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int n = nx[0];
    int x = nx[1];
    Graph g = new Graph(n+1);
    for(int i=0;i<n-1;i++) {
      int uv[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      g.addEdge(uv[0], uv[1]);
    }

    // g.printGraph();
    int sum =0;
    for(int i=1;i<n+1;i++) {
      if(g.adjList.get(i).size() == 0) {
        sum+=i;
      }
    }
    // System.out.println(sum);
    if(sum>=x) {
      
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
