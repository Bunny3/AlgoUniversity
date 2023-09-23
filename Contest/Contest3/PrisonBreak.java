import java.util.*;
import java.io.*;

class Triple {
  int x,y,type;
  public Triple(int x, int y,int type) {
    this.x = x;
    this.y = y;
    this.type =type;
  }
}
public class PrisonBreak {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String nmString[] = input.readLine().trim().split(" ");
    int n = Integer.parseInt(nmString[0]);
    int m = Integer.parseInt(nmString[1]);
    int dx[] = {1,0,-1,0};
    int dy[] = {0,-1,0,1};
    String grid[] = new String[n];
    for(int i=0;i<n;i++) {
      grid[i] = input.readLine();
    }
    int srcx=-1,srcy=-1;
    Queue<Triple> q = new LinkedList<Triple>();
    boolean vis[][] = new boolean[n][m];
    for(int i=0;i<n;i++) {
      for(int j=0;j<m;j++) {
        if(grid[i].charAt(j) == 'M') {
          q.add(new Triple(i, j, 0));
        }
        if(grid[i].charAt(j) == 'A') {
          srcx = i;
          srcy= j;
          if ((i == 0 || i == n - 1 || j == 0 || j == m - 1)) {
            System.out.println("YES");
            return;
          }
        }
         vis[i][j] = false;
      }
    }
    vis[srcx][srcy] = true;
    q.add(new Triple(srcx, srcy, 1));
    while(!q.isEmpty()) {
      Triple triplet = q.poll();
      int x = triplet.x;
      int y = triplet.y;
      int type = triplet.type;
      // System.out.println("("+x+","+y+","+type+")");
      for(int k=0;k<4;k++) {
        int nx = x + dx[k];
        int ny = y +dy[k];
        if(nx>=0 && nx<n-1 && ny>=0 && ny<m && grid[nx].charAt(ny)== '.' && vis[nx][ny] == false) {
          vis[nx][ny] = true;
          q.add(new Triple(nx, ny, type));
          if(type == 1 && (nx==0 || nx==n-1 || ny==0 || ny==m-1)) {
            System.out.println("YES");
            return;
          }
        }
      }
    }
    System.out.println("NO");
  }
}

// 5 8
// ########
// #M..A..#
// #.#.M#.#
// #M#..#.#
// #.######