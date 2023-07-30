import java.util.*;
import java.io.*;
public class AvoidingCities {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String NV[] = p.readLine().trim().split(" ");
    int N = Integer.parseInt(NV[0]);
    int V = Integer.parseInt(NV[1]);
    String srcDest[] = p.readLine().trim().split(" ");
    int src = Integer.parseInt(srcDest[0]);
    int des = Integer.parseInt(srcDest[1]);
    String curseString[] = p.readLine().trim().split(" ");
    int curseArray[] = new int[N];
    for(int i=0;i<N;i++) {
      curseArray[i] = Integer.parseInt(curseString[i]);
    }

    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for(int i=0;i<N;i++) {
      adj.add(new ArrayList<Integer>());
    }
    for(int i=0;i<V;i++) {
      String UV[] = p.readLine().trim().split(" ");
      int u = Integer.parseInt(UV[0]);
      int v = Integer.parseInt(UV[1]);
      if(curseArray[u] == 1 || curseArray[v] == 1)
        continue;
      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    int dist[] = new int[N];
    Arrays.fill(dist,0);
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(src);
    int visited[] = new int[N];
    Arrays.fill(visited,0);
    visited[src] =1;
    boolean flag = false;
    while(!q.isEmpty() && flag == false) {
      int x = q.remove();
      for(int i=0;i<adj.get(x).size();i++) {
        if(visited[adj.get(x).get(i)] == 0) {
          visited[adj.get(x).get(i)] = 1;
          dist[adj.get(x).get(i)] = dist[x]+1;
          q.add(adj.get(x).get(i));
          if(adj.get(x).get(i) == des) {
            flag = true;
            break;
          }
        }
      }
    }
    if(flag == true)
    System.out.println(dist[des]);
    else
    System.out.println(-1);
  }
}
