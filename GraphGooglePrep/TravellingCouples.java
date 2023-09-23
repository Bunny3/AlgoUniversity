import java.io.*;
import java.util.*;

class Graph {
  int vertices;
  ArrayList<ArrayList<Integer>> adj;
  public Graph(int vertices) {
    this.vertices = vertices;
    adj = new ArrayList<ArrayList<Integer>>();
    for(int i=0;i<vertices;i++) {
      adj.add(new ArrayList<Integer>());
    }
  }
  public void addEdge(int u, int v) {
    adj.get(u).add(v);
    adj.get(v).add(u);
  }
  public void printGraph() {
    for(int i=1;i<vertices;i++) {
      System.out.print("vertex "+i+"is connected to :");
      for(int j=0;j<adj.get(i).size();j++) {
        System.out.print(adj.get(i).get(j));
      }
      System.out.println();
    }
  }
};
public class TravellingCouples {

  public static void bfs(int src,Graph graph, int visited[], int distance[]) {
    visited[src] = 1;
    distance[src] = 0;
    Queue<Integer> q= new LinkedList<Integer>();
    q.add(src);
    while(!q.isEmpty()) {
      int node = q.poll();
      for(int neighbour:graph.adj.get(node)) {
        if(visited[neighbour] == 0 ) {
          q.add(neighbour);
          distance[neighbour] = distance[node] +1;
          visited[neighbour] = 1;
        }
      }
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int inpArray[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
    int c1=inpArray[0];
    int c2=inpArray[1];
    int c3=inpArray[2];
    int n = inpArray[3];
    int m = inpArray[4];
    Graph graph = new Graph(n+1);
    for(int i=0;i<m;i++) {
      int edge[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
      graph.addEdge(edge[0],edge[1]);
    }
    // graph.printGraph();
    int visited[][] = new int[3][n+1];
    for(int[] row:visited) {
      Arrays.fill(row,0);
    }
    int distance[][] = new int[3][n+1];
    bfs(1,graph,visited[0],distance[0]);
    bfs(2,graph,visited[1],distance[1]);
    bfs(n,graph,visited[2],distance[2]);

    // for(int i=0;i<3;i++) {
    //   for(int j=0;j<n+1;j++) {
    //     System.out.print(distance[i][j]+" ");
    //   }
    //   System.out.println();
    // }

    int temp = Integer.MAX_VALUE;
    c3 = c3<(c1+c2) ? c3: c1+c2;
    for(int i=1;i<n+1;i++) {
      temp = (int)Math.min(c1*distance[0][i]+c2*distance[1][i]+c3*distance[2][i], temp);
    }
    System.out.println(temp);
  }
  
}
