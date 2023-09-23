import java.util.*;
import java.io.*;
class Graph {
  int vertices;
  ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
  public Graph(int v) {
    vertices = v;
    for(int i=0;i<vertices+1;i++) {
      adj.add(new ArrayList<Integer>());
    }
  }
  public void addEdge(int u, int v) {
    adj.get(u).add(v);
    // adj.get(v).add(u);
  }
  public void deleteEdge(int u, int v) {
    int index = -1;
    for(int childEdge:adj.get(u)) {
      index++;
      if(childEdge == v) {
        adj.get(u).remove(index);
        break;
      }
    }
  }

    public void printGraph() {
    for(int i=1;i<vertices+1;i++) {
      System.out.print("vertex "+i+"is connected to :");
      for(int j=0;j<adj.get(i).size();j++) {
        System.out.print(adj.get(i).get(j));
      }
      System.out.println();
    }
  }

};
public class CompanyHierarchy {
  
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    Graph g = new Graph(N);
    String hiearchyArray[] = p.readLine().trim().split(" ");
    int emp = 2;
    for(int i=0;i<N-1;i++) {
      g.addEdge(Integer.parseInt(hiearchyArray[i]), emp++);
    }
    int visited[] = new int[N+1];
    Arrays.fill(visited,-1);
    int ans[] = new int[N+1];
    int tem = DFS(1,visited,g,ans);
    for (int i = 1; i < ans.length; i++) {
      System.out.print(ans[i] + " ");
  }
    // g.printGraph();
  }

  public static int DFS(int i,int visited[], Graph g, int ans[]) 
  {
    visited[i] = 1;
    int size = 1;
    for(int e:g.adj.get(i)) {
      if(visited[e] == -1) {
        size+= DFS(e, visited, g, ans);
      }
    }

    ans[i] = size-1;
    return size;
  }
}
