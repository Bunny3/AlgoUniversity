import java.util.*;
import java.io.*;
public class MinimumJumps {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String NE[] = p.readLine().trim().split(" ");
    int N = Integer.parseInt(NE[0]);
    int E = Integer.parseInt(NE[1]);
    ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(N+1);
    for(int i=0;i<N+1;i++) {
      arr.add(new ArrayList<Integer>());
    }
    for(int i=0;i<E;i++) {
      String UV[] = p.readLine().trim().split(" ");
      int U = Integer.parseInt(UV[0]);
      int V = Integer.parseInt(UV[1]);
      arr.get(U).add(V);
      arr.get(V).add(U);
    }
    // // print Graph
    // for(int i=1;i<N+1;i++) {
    //   System.out.print("Adjacency List " + i+ " ");
    //   for(int j=0;j<arr.get(i).size();j++) {
    //     System.out.print("->"+arr.get(i).get(j));
    //   }
    //   System.out.println();
    // }

    String srcDes[] = p.readLine().trim().split(" ");
    int src = Integer.parseInt(srcDes[0]);
    int des = Integer.parseInt(srcDes[1]);
    Queue<Integer> q = new LinkedList<>();
    q.add(src);

    int visited[] = new int[N+1];
    Arrays.fill(visited,0);
    int count = 0;
    visited[src] = 1;
    boolean flag = false;
    // while(q.size()!=0) {
    //   int len = q.size();
    //   if(flag == true)
    //     break;
    //   count++;
    //   for(int j=0;j<len;j++) {
    //     int node = q.poll();
    //     if(node == des) {
    //       flag = true;
    //       break;
    //     }
    //     for(int i=0;i<arr.get(node).size();i++) {
    //       if(visited[arr.get(node).get(i)] == 0) {
    //         visited[node] = 1;
    //         q.add(arr.get(node).get(i));
    //       }
    //     }
    //   }
    // }

    //BFS algorithm
    int dist[] = new int[N+1];
    Arrays.fill(dist,0);
    while(!q.isEmpty() && flag == false) {
      int u = q.remove();
      for(int i=0;i<arr.get(u).size();i++) {
        if(visited[arr.get(u).get(i)] == 0) {
          visited[arr.get(u).get(i)] = 1;
          dist[arr.get(u).get(i)] = dist[u]+1;
          q.add(arr.get(u).get(i));

          if(arr.get(u).get(i) == des) {
            flag = true;
            break;
          }
        }
      }
    }

    if(flag == true)
    System.out.println(dist[des]);
    else
    System.out.println(0);
  }  
}
