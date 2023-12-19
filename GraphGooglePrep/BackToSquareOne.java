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
    for(int i=0;i<vertices;i++) {
      System.out.print("From vertices "+i+" --> ");
      for(int j:adjList.get(i)) {
        System.out.print(j+" ");
      }
      System.out.println();
    }
  }
};
public class BackToSquareOne {
  public static boolean isCyclic(Graph g,int src,boolean visited[],boolean recStack[]) {

    if(recStack[src] == true)
      return true;
    if(visited[src] == true)
      return false;
    visited[src]=true;
    recStack[src] = true;
    for(int node: g.adjList.get(src)) {
        if(isCyclic(g, node, visited, recStack)) 
          return true;
    }
    recStack[src]=false;
    return false;
  }
  private static boolean isCyclicUtil(Graph g,int i, boolean[] visited,
  boolean[] recStack)
{

// Mark the current node as visited and
// part of recursion stack
if (recStack[i])
return true;

if (visited[i])
return false;

visited[i] = true;

recStack[i] = true;
List<Integer> children = g.adjList.get(i);

for (Integer c: children)
if (isCyclicUtil(g,c, visited, recStack))
return true;

recStack[i] = false;

return false;
}
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int NM[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int N = NM[0];
    int M = NM[1];
    Graph g = new Graph(N);
    for(int i=0;i<M;i++) {
      int uv[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      g.addEdge(uv[0], uv[1]);
    }

    boolean visited[] = new boolean[N];
    boolean recStack[] = new boolean[N];
    boolean flag = false;
    // g.printGraph();
    for(int i=0;i<N;i++) {
      if(isCyclic(g,i,visited,recStack) == true)
      {
        flag = true;
        break;
      }
    }

    System.out.println(flag==true?"NO":"YES");
  }
}
