import java.io.*;
import java.util.*;
  class Graph {
    int vertices;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    public Graph(int v) {
      vertices = v+1;
      for(int i=0;i<vertices;i++) {
        adj.add(new ArrayList<Integer>());
      }
    }
    public void addEdge(int u, int v) {
      adj.get(u).add(v);
    }

    public void printEdge() {
      for(int i=1;i<vertices;i++) {
        System.out.print(i+"----->");
        for(int childNode:adj.get(i)) {
          System.out.print(childNode+" ");
        }
        System.out.println();
      }
    }
  };
public class CompanyHierarcy2 {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    String hiearchyArray[] = p.readLine().trim().split(" ");
    String profitArray[] = p.readLine().trim().split(" ");
    Graph g = new Graph(N);
    int emp=2;
    for(int i=0;i<N-1;i++) {
      g.addEdge(Integer.parseInt(hiearchyArray[i]),emp++);
    }

    int visited[] = new int[N+1];
    Arrays.fill(visited,-1);
    int ans[] = new int[N+1];
    int temp = DFS(1,visited,ans,g,profitArray);

    int max_ = Integer.MIN_VALUE;
    for(int i=1;i<N+1;i++) {
      max_ = Math.max(ans[i],max_);
    }
    System.out.println(max_);
  }
  public static int DFS(int node,int visited[], int ans[], Graph g, String profitArray[]) {
    visited[node] = 1;
    int profit = Integer.parseInt(profitArray[node-1]);
    for(int childNode: g.adj.get(node)) {
      if(visited[childNode] == -1) {
        profit +=DFS(childNode,visited,ans,g,profitArray);
      }
    }
    ans[node] = profit;
    return profit;
  }
}
