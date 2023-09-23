import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Triple {
  long x,y,r;
  public Triple(long x,long y,long r) {
    this.x = x;
    this.y = y;
    this.r = r;
  }
};

class Pair {
  long x,y;
  public Pair(long x,long y) {
    this.x = x;
    this.y = y;
  }
};
public class BigDisc {
  
  public static boolean isInsideCircle(long x,long y, ArrayList<Triple> circles) {
    for(int i=0;i<circles.size();i++) {
      long xx = circles.get(i).x;
      long yy = circles.get(i).y;
      long rr = circles.get(i).r;

      long dist = (xx-x)*(xx-x) + (yy-y)*(yy-y);
      if(dist<= rr*rr)
        return true;
    }
    return false;
  }
  public static boolean checkForValidity(long X,long Y,ArrayList<Triple> circles) {
    long srcX = 0;
    long srcY = Y;
    long desX = X;
    long desY = 0;
    Queue<Pair> q = new LinkedList<Pair>();
    q.add(new Pair(srcX,srcY));
    int[] dx = {0,0,1,-1,1,1,-1,-1};
    int[] dy = {1,-1,0,0,1,-1,-1,1};
    boolean visited[][] = new boolean[(int)X+1][(int)Y+1];
    visited[(int)srcX][(int)srcY] = true;
    while(!q.isEmpty()) {
      Pair temp = q.poll();
      long x = temp.x;
      long y = temp.y;

      if(x == desX && y == desY) {
        return true;
      }

      for(int k=0;k<8;k++) {
        long nx = x + dx[k];
        long ny = y + dy[k];

        if(nx>=0 && nx<=X && ny>=0 && ny<=Y && !visited[(int)nx][(int)ny] && !isInsideCircle(nx,ny,circles)) {
          visited[(int)nx][(int)ny] = true;
          q.add(new Pair(nx, ny));
        }
      }
    }
    return false;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(input.readLine());
    long topRight[] = Arrays.stream(input.readLine().trim().split(" ")).mapToLong(s -> Long.parseLong(s)).toArray();
    long X = topRight[0];
    long Y = topRight[1];
    int N = Integer.parseInt(input.readLine());
    ArrayList<Triple> circles = new ArrayList<Triple>();
    for(int i=0;i<N;i++) {
      long xyr[] = Arrays.stream(input.readLine().trim().split(" ")).mapToLong(s -> Long.parseLong(s)).toArray();
      circles.add(new Triple(xyr[0], xyr[1], xyr[2]));
    }

    boolean ifPossible = checkForValidity(X,Y,circles);
    if(ifPossible == true) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
