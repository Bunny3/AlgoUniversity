import java.util.*;
import java.io.*;

class Pair {
  int x,y;
  Pair(int xx,int yy) {
    x= xx;
    y =yy;
  }
};

public class ImportantNodes {
  
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String NMK[] = p.readLine().trim().split(" ");
    int N = Integer.parseInt(NMK[0]);
    int M = Integer.parseInt(NMK[1]);
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for(int i=0;i<N+1;i++) {
      adj.add(new ArrayList<Integer>());
    }
    for(int i=0;i<M;i++) {
      String UV[] = p.readLine().trim().split(" ");
      int u = Integer.parseInt(UV[0]);
      int v = Integer.parseInt(UV[1]);
      adj.get(u).add(v);
      adj.get(v).add(u);
    }
    int visited[] = new int[N+1];
    Arrays.fill(visited,0);
    int dist[] = new int[N+1];
    Arrays.fill(dist,0);
    Queue<Integer> q = new LinkedList<Integer>();
    ArrayList<ArrayList<Integer>> parent = new ArrayList<ArrayList<Integer>>();
    for(int i = 0; i < N; i++){
      parent.add(new ArrayList<>());
  }
  parent.get(1).clear();
  parent.get(1).add(-1);
    q.add(1);
    visited[1]=1;
    boolean flag =false;
    while(!q.isEmpty()) {
      int x = q.remove();
      for(int i=0;i<adj.get(x).size();i++) {

        if(dist[adj.get(x).get(i)]>dist[x]+1) {
          dist[adj.get(x).get(i)] = dist[x]+1;
          q.add(adj.get(x).get(i));
          parent.get(adj.get(x).get(i)).clear();
          parent.get(adj.get(x).get(i)).add(x);
        } else if (dist[adj.get(x).get(i)] == dist[x]+1) {
          parent.get(adj.get(x).get(i)).add(x);
        }
      }
    }

    // for(int i=0;i<N+1;i++) {
    //   System.out.print(dist[i]+" ");
    // }

    Set<Integer> st = new HashSet<Integer>();

    if(flag == true) {

    int v = dist[N];
    for(int i=1;i<N+1;i++) {
      if(dist[i]<v) {
        System.out.print(i+" ");
      }
    }
    System.out.print(N);
  }
  else {
    System.out.println(-1);
  }
}
}
