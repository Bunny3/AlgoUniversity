import java.io.*;
import java.util.*;
class Edge implements Comparable<Edge> {
  int u, v;
  long w;
  public Edge(int u, int v, long w) {
    this.u = u;
    this.v = v;
    this.w = w;
  }

  public int compareTo(Edge edge) {
    return Long.compare(this.w,edge.w);
  }
}

class DSU {
  int parent[];
  int rank[];
  public DSU(int nComponents) {
    parent = new int[nComponents];
    rank = new int[nComponents];
    for(int i=0;i<nComponents;i++) {
      parent[i] = i;
      rank[i] = 0;
    }
  }

  public int findParent(int v) {
    return parent[v] == v ? v :(parent[v]=findParent(parent[v]));
  }

  public void merge(int x, int y) { 

      int u = findParent(x);
      int v = findParent(y);
      if(u == v) {
        return;
      }
      if(rank[u] == rank[v]) {
        parent[u] = v;
        rank[v]++;
      } else if(rank[u]>rank[v]) {
        parent[v] = u;
      } else if(rank[u]<rank[v]) {
        parent[u] = v;
      }
  }
}
public class RepairingRoads {
  
  public static void main(String args[]) throws IOException{
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int NM[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int N = NM[0];
    int M = NM[1];
    ArrayList<Edge> edges = new ArrayList<>();
    for(int i=0;i<M;i++) {
      long uvc[] = Arrays.stream(input.readLine().trim().split(" ")).mapToLong(s->Long.parseLong(s)).toArray();
      edges.add(new Edge((int)uvc[0],(int)uvc[1], uvc[2]));
      edges.add(new Edge((int)uvc[1],(int)uvc[0], uvc[2]));
    }
    Collections.sort(edges);
    DSU dsu = new DSU(N+1);
    long ans = 0;
    for(Edge edge:edges) {
      if(dsu.findParent(edge.u) != dsu.findParent(edge.v)) {
        dsu.merge(edge.u, edge.v);
        ans +=edge.w;
      }
    }
    Set<Integer> st = new HashSet<>();
    for(int i=1;i<N+1;i++) {
      st.add(dsu.findParent(i));
    }
    if(st.size()>1) 
    {
      System.out.println("IMPOSSIBLE");
    } else {
    System.out.println(ans);
    }
  }
}
