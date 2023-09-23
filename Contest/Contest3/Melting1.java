import java.util.*;
import java.io.*;

class Pair {
  int x,y;
  Pair(int xx,int yy) {
    x= xx;
    y =yy;
  }
};
public class Melting1 {
  
  public static int dx[] = {0,1,0,-1};
  public static int dy[] = {1,0,-1,0};
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String NMK[] = p.readLine().trim().split(" ");
    int N = Integer.parseInt(NMK[0]);
    int M = Integer.parseInt(NMK[1]);
    long K = Long.parseLong(NMK[2]);

    char adj[][] = new char[N][M];

    Pair src = null;
    Pair des = null;
    for(int i=0;i<N;i++) {
      String row = p.readLine();;
      
      for(int j=0;j<M;j++) {
        if(row.charAt(j) =='i') {
          src = new Pair(i, j);
        } else  if (row.charAt(j) == 'h') {
          des = new Pair(i,j);
        } 
          adj[i][j] = row.charAt(j);
      }
    }
    Queue<Pair> q = new LinkedList<>();
    int visited[][] = new int[N][M];
    long dis[][] = new long[N][M];
    q.add(src);

    visited[src.x][src.y] = 1;
    dis[src.x][src.y] = 1;
    boolean flag =false;
    while(!q.isEmpty() && flag==false) {
      Pair node = q.poll();
      for(int i=0;i<4;i++) {
        int newx = node.x + dx[i];
        int newy = node.y + dy[i];
        if(newx >=0 && newx<N && newy >=0 && newy<M && adj[newx][newy] != '#' && visited[newx][newy] == 0) {
        if(des.x == newx && des.y == newy) {
          dis[newx][newy] = 1+ dis[node.x][node.y];
          flag = true;
          break;
        }
          dis[newx][newy] = 1 + dis[node.x][node.y];
          visited[newx][newy] = 1;
          q.add(new Pair(newx, newy));
        } 
      }
    }

    if(flag == true) {
    if(dis[des.x][des.y]-1>K)
    System.out.println("NO");
    else
    System.out.println("YES");
  }
  else {
    System.out.println("NO");
  }
}
}
