import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
class Graph{
  int vertices;
  ArrayList<ArrayList<Integer>> adjList;
  int visited[];
  public Graph(int vertices) {
    this.vertices = vertices;
    adjList = new ArrayList<ArrayList<Integer>>();
    for(int i=0;i<vertices;i++) {
      adjList.add(new ArrayList<>());
    }
    visited = new int[vertices];
    Arrays.fill(visited,-1);
  }

  public void addEdge(int u,int v) {
    adjList.get(u).add(v);
    adjList.get(v).add(u);
  }

  public void DFS(int src) {
    visited[src] = 1;
    for(int child:adjList.get(src)) {
      if(visited[child] == -1) {
        DFS(child);
      }
    }
  }
}
public class BuildingRoads {
  
  public static void main(String args[]) throws IOException{
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int nm[] = Arrays.stream(p.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();

    int n = nm[0];
    int m = nm[1];
    Graph g = new Graph(n);
    for(int i=0;i<m;i++) {
      int uv[] = Arrays.stream(p.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      g.addEdge(uv[0]-1, uv[1]-1);
    }
    ArrayList<Integer> bridges = new ArrayList<>();
    for(int i=0;i<n;i++) {
      if(g.visited[i]==-1) {
        bridges.add(i+1);
        g.DFS(i);
      }
    }
    if(bridges.size()>1) {
      System.out.println(bridges.size()-1);
      for(int i=1;i<bridges.size();i++) {
        System.out.println(bridges.get(i-1)+ " "+ bridges.get(i));
      }
    } else {
      System.out.println(0);
    }
  }
}
