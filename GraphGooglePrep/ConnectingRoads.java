import java.util.*;
import java.io.*;
class Edge implements Comparable<Edge> {
  long u,v,w;
  Edge(long u, long v,long w) {
    this.u = u;
    this.v = v;
    this.w = w;
  }
  public int compareTo(Edge e2) {
    return Long.compare(this.w, e2.w);
  }
}

class Coordinates {
  long x,y,z;
  public Coordinates(long x, long y, long z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
}

class DSU {
  int parent[];
  int rank[];
  public DSU(int nComponents) {
    parent = new int[nComponents+1];
    rank = new int[nComponents+1];
    for(int i=0;i<nComponents;i++) {
      parent[i] = i;
      rank[i] =0;
    }
  }

  int findParent(int v) {
    return parent[v] == v ? v: (parent[v]=findParent(parent[v]));
  }

  void merge(int x,int y) {
    int u = findParent(x);
    int v = findParent(y);
    if(u == v) {
      return;
    }
    else if(rank[u] == rank[v]) {
      rank[u]++;
      parent[u] = v;
    } else if(rank[u]<rank[v]) {
      parent[u] = v;
    } else if(rank[u]>rank[v]) {
      parent[u] = v;
    }
    return;
  }
}
public class ConnectingRoads {
  public static long difference(int M,Coordinates a,Coordinates b) {
    return M*(Math.abs(a.x-b.x)+Math.abs(a.y-b.y)+Math.abs(a.z-b.z));
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int NM[]= Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int N = NM[0];
    int M = NM[1];
    ArrayList<Coordinates> coordinates = new ArrayList<>();
    for(int i=0;i<N;i++) {
      long xyz[] = Arrays.stream(input.readLine().trim().split(" ")).mapToLong(s->Long.parseLong(s)).toArray();
      coordinates.add(new Coordinates(xyz[0], xyz[1], xyz[2]));
    }
    ArrayList<Edge> edges = new ArrayList<>();
    for(int i=0;i<N-1;i++) {
      for(int j=i+1;j<N;j++) {
        long dis = difference(M,coordinates.get(i),coordinates.get(j));
        edges.add(new Edge(i+1,j+1,dis));
        edges.add(new Edge(j+1,i+1,dis));
      }
    }

    long ans =0;
    DSU dsu = new DSU(N+1);
    Collections.sort(edges);
    for(Edge edge:edges) {
      if(dsu.findParent((int)edge.u)!=dsu.findParent((int)edge.v)) {
        dsu.merge((int)edge.u,(int)edge.v);
        ans += edge.w;
      }
    }
    Set<Integer> countComponent = new HashSet<>();
    for(int i=1;i<N+1;i++){
      countComponent.add(dsu.findParent(i));
    }
    if(countComponent.size()>1) {
      System.out.println("IMPOSSIBLE");
    } else {
      System.out.println(ans);
    }
  }
}
