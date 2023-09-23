import java.util.*;
import java.io.*;

public class BigDisc1 {
  
  public static long distance(long x1,long y1,long x2,long y2){
    return (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2);
  }
  public static boolean[] bfs(int src, ArrayList<ArrayList<Integer>> adj) {
    int n = adj.size();
    Queue<Integer> q = new LinkedList<>();
    q.add(src);
    boolean vis[] = new boolean[n];
    Arrays.fill(vis,false);

    while(!q.isEmpty()) {
      int node = q.poll();
      for(int neighbour:adj.get(node)) {
        if(!vis[neighbour]) {
          vis[neighbour]=true;
          q.add(neighbour);
        }
      }
    }
    return vis;
  }
  public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    adj.get(u).add(v);
    adj.get(v).add(u);
  }
  public static void solve(int X, int Y, int N,long[][] circles, ArrayList<ArrayList<Integer>> adj) {
    for(int i=0;i<=N+4;i++) {
      adj.add(new ArrayList<Integer>());
    }

    for(int i=0;i<N;i++) {
      int idx = i+4;
      if(circles[i][0]-circles[i][2]<=0) {
        addEdge(adj,3,idx);
      }
      if(circles[i][1]+circles[i][2]>=Y) {
        addEdge(adj,0,idx);
      }
      if(circles[i][0]+circles[i][2]>=X) {
        addEdge(adj,1,idx);
      }
      if(circles[i][1]-circles[i][2]<=0) {
        addEdge(adj,2,idx);
      }
    }

    for(int i=0;i<N;i++) {
      int idxi = i+4;
      for(int j=i+1;j<N;j++) {
        int idxj = j+4;

        if(distance(circles[i][0],circles[i][1],circles[j][0],circles[j][1])<=(circles[i][2]+circles[j][2])*(circles[i][2]+circles[j][2])
        ) {
          addEdge(adj, idxi, idxj);
        }
      }
    }

    boolean[] TV = bfs(0,adj);
    boolean[] RV = bfs(1,adj);
    boolean ans = !(TV[2] || TV[3] || RV[2] || RV[3]);
    System.out.println(ans ? "YES" : "NO");
  } 
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(input.readLine());
    while(T-- > 0) {
    int XY[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
    int X = XY[0];
    int Y = XY[1];
    int N = Integer.parseInt(input.readLine());
    long circles[][] = new long[N][3];
    for(int i=0;i<N;i++) {
      int xyr[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
      circles[i][0] = xyr[0];
      circles[i][1] = xyr[1];
      circles[i][2] = xyr[2];
    }
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    solve(X,Y,N,circles,adj);
    }
  }
}
