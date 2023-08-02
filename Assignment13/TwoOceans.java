import java.util.*;
import java.io.*;

class Pair {
  int x,y;
  Pair(int xx,int yy) {
    x =xx;
    y = yy;
  }
}
public class TwoOceans {
  public static int dx[] = {0,1,0,-1};
  public static int dy[] = {-1,0,1,0};
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String nm[] = p.readLine().trim().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);
    long adj[][] = new long[n][m];
    for(int i=0;i<n;i++) {
      String tempRow[]= p.readLine().trim().split(" ");
      for(int j=0;j<m;j++) 
      {
        adj[i][j] = Long.parseLong(tempRow[j]);
      }
    }

    int visitedNw[][] = new int[n][m];
    // Arrays.fill(visitedNw,0);
    //Implement NW
    Queue<Pair> q = new LinkedList<Pair>();
    //Adding different Source node from NW
    for(int j=0;j<m;j++) {
      q.add(new Pair(0,j));
      visitedNw[0][j] = 1;
    }
    for(int i=0;i<n;i++) {
      q.add(new Pair(i,0));
      visitedNw[i][0] = 1;
    }

    while(!q.isEmpty()) {
      Pair pp = q.poll();
      for(int i=0;i<4;i++) {
        int newx = pp.x + dx[i];
        int newy = pp.y + dy[i];

        if(newx>=0 && newx<n && newy>=0 && newy<m && adj[pp.x][pp.y]<=adj[newx][newy]) {
          if(visitedNw[newx][newy] == 0) {
            visitedNw[newx][newy] = 1;
            q.add(new Pair(newx, newy));
          }
        }
      }
    }
    q.clear();;

    int visitedSE[][] = new int[n][m];
    // Arrays.fill(visitedSE,0);

    //Add different src node from SE
    for(int i=0;i<n;i++) {
      q.add(new Pair(i,m-1));
      visitedSE[i][m-1] = 1;
    }
    for(int j=0;j<m;j++) {
      q.add(new Pair(n-1, j));
      visitedSE[n-1][j] = 1;
    }

     while(!q.isEmpty()) {
      Pair pp = q.poll();
      for(int i=0;i<4;i++) {
        int newx = pp.x + dx[i];
        int newy = pp.y + dy[i];

        if(newx>=0 && newx<n && newy>=0 && newy<m  && adj[pp.x][pp.y]<=adj[newx][newy]) {
          if(visitedSE[newx][newy] == 0) {
            visitedSE[newx][newy] = 1;
            q.add(new Pair(newx, newy));
          }
        }
      }
    }

    for(int i=0;i<n;i++) {
      for(int j=0;j<m;j++) {
        if(i==n-1 && j==0) 
        visitedNw[i][j] = 1;
        else if(i==0 && j==m-1){
          visitedNw[i][j] = 1;
        }
         else if(visitedNw[i][j] == 1 && visitedSE[i][j]==1)
        {
          visitedNw[i][j] = 1; 
        } else {
          visitedNw[i][j] = 0; 
        }
      }
    }
    if(n==1 || m==1) {
      for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
          visitedNw[i][j] = 1;
        }
      }
    }
    for(int i=0;i<n;i++) {
      for(int j=0;j<m;j++) {
        System.out.print(visitedNw[i][j]+" ");
      }
      System.out.println();
    }
  }
}