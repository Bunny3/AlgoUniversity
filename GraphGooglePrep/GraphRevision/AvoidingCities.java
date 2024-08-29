/*
 * There are N cities with M
 bi-directional roads between them. You want to travel from city 0
 to city N−1
. But there are some cities that you cannot visit because they are cursed.

Find the smallest number of roads that you should take to complete your travel and output it. If it is not possible to do so output −1
.

1≤N≤105

0≤M≤2×105

INPUT
The first line contains two integers N
 and M
 denoting the number of cities and the number of roads respectively.

The second line contains two integers src
 and dest
 denoting the source and the destination respectively.

The third line contains N
 integers which are either 0
 or 1
 denoting whether each city is cursed or not. (1
 means that the city is cursed.)

Finally, there are M
 lines containing 2
 integers each u
 and v
 denoting that there is a road between city u
 and city v
.

OUTPUT
Output the smallest number of roads that you should take to complete your travel and output it. If it is not possible to do so output −1
.

EXAMPLE
Sample 1 INPUT:
properties
5 5
0 2
0 1 0 0 0
0 1
1 2
0 3
3 4
4 2
Sample 1 OUTPUT:
text
3
 */

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
    adj.get(v).add(u);
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
}
/*

5 5
0 2
0 1 0 0 0
0 1
1 2
0 3
3 4
4 2
*/
public class AvoidingCities {

  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int nm[] = Arrays.stream(p.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int n = nm[0];
    int m = nm[1];
    int sd[] = Arrays.stream(p.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int src = sd[0];
    int des = sd[1];
    int curse[] = Arrays.stream(p.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    Graph g = new Graph(n);
    for(int i=0;i<m;i++) {
      int uv[] = Arrays.stream(p.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      int u = uv[0];
      int v = uv[1];
      g.addEdge(u,v);
    }
     bfs(g,src,des,curse);
  }

  public static void bfs(Graph g, int src, int des, int curse[]) {
    int dist[] = new int[g.vertices];
    Arrays.fill(dist,0);
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(src);
    int visited[] = new int[g.vertices];
    Arrays.fill(visited,0);
    visited[src]=1;
    boolean flag = false;
    while(!queue.isEmpty() && flag == false) {
      int node = queue.poll();
      for(int i=0;i<g.adj.get(node).size();i++) {
        if(visited[g.adj.get(node).get(i)] == 0 && (curse[node] == 0)) {
          visited[g.adj.get(node).get(i)] = 1;
          dist[g.adj.get(node).get(i)] = dist[node]+1;
          queue.add(g.adj.get(node).get(i));
          if(g.adj.get(node).get(i) == des) {
            flag = true;
            break;
          }
        }
      }
    }
    if(flag == true) {
      System.out.println(dist[des]);
    } else {
      System.out.println(-1);
    }
  }
}
