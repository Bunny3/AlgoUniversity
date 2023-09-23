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
  public void  addEdge(int u, int v) {
    adj.get(u).add(v);
    adj.get(v).add(u);
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
public class RedAlert {

  static int threshHolN =0;
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String nc[] = p.readLine().trim().split(" ");
    int N = Integer.parseInt(nc[0]);
    int c = Integer.parseInt(nc[1]);
    Graph g= new Graph(N);
    String marking[] = p.readLine().trim().split(" ");
    for(int i=0;i<N-1;i++) {
      String temp[] = p.readLine().trim().split(" ");
      g.addEdge(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
    }
    // g.printEdge();
    // int visited[] = new int[N+1];
    threshHolN = c;
    // Arrays.fill(visited,-1);
    int ans = DFS(0,1,marking,0,g);
    
    System.out.println(ans);
  }

  public static int DFS(int parent,int node,String marking[], int k, Graph g) {
    if(marking[node-1].compareTo("1") == 0) {
      k = k+1;
    } else {
      k=0;
    }
    if(k>threshHolN) {
      return 0;
    }
    if(g.adj.get(node).size() == 1 && node != 1) {
      return 1;
    }
    int ans = 0;
    for(int childNode: g.adj.get(node)) {
      // System.out.println("child Node "+childNode+" of Parent Node "+node);
      if(childNode != parent) {
        ans+=DFS(node,childNode,marking,k,g);
      }
    }
    return ans;
  }
}
