import java.io.*;
import java.util.*;
class Pair {
  int x,y;
  public Pair(int a,int c) {
    x = a;
    y = c;
  }
};
public class Labrynith {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int nm[] = Arrays.stream(p.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int n = nm[0];
    int m = nm[1];

    char map[][] = new char[n][m];

    Pair src=new Pair(0,0),des = new Pair(0,0); 
    for(int i=0;i<n;i++) {
      String temp = p.readLine();
      for(int j=0;j<m;j++) {
        map[i][j] = temp.charAt(j);
        if(map[i][j] == 'A') {
          src = new Pair(i,j);
        }
        else if(map[i][j] == 'B') {
          des = new Pair(i,j);
        }
      }
    }

    Queue<Pair> q= new LinkedList<>();
    int dx[] = {0,1,0,-1};
    int dy[] = {-1,0,1,0};
    String stepDir = "LDRU";
    q.add(src);
    int visited[][] = new int[n][m];
    for(int i=0;i<n;i++) {
      Arrays.fill(visited[i],-1);
    }
    visited[src.x][src.y] = 1;
    int dist[][] = new int[n][m];
    for(int i=0;i<n;i++) {
      Arrays.fill(dist[i],n*m);
    }
    int previousStep[][] = new int[n][m];
    while(!q.isEmpty()) {
      Pair node = q.remove();
      for(int i=0;i<4;i++) {
        int nx = node.x + dx[i];
        int ny = node.y + dy[i];
        if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny] != '#' && visited[nx][ny] == -1) {
          visited[nx][ny] = 1;
          q.add(new Pair(nx, ny));
          previousStep[nx][ny] = i;
        }
      }
    }
    if(visited[des.x][des.y] == 1) {
      System.out.println("YES");
      ArrayList<Integer> steps = new ArrayList<>();
      while(true) {
        if(des.x==src.x && des.y==src.y)
          break;
        int d = previousStep[des.x][des.y];
        steps.add(d);
        des.x = des.x-dx[d];
        des.y = des.y-dy[d];
        // System.out.println("des Now("+des.x+","+des.y+")");
      }
      Collections.reverse(steps);
      System.out.println(steps.size());
      for(int i:steps) {
        System.out.print(stepDir.charAt(i));
      }
      System.out.println();
    } else {
      System.out.println("NO");
    }
  }
}
