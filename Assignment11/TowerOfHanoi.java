import java.util.*;
import java.io.*;

class pair {
  int N,x,y;
  pair(int n1,int x1, int y1) {
    N=n1;
    x = x1;
    y=y1;
  }
};
public class TowerOfHanoi {
  static ArrayList<pair> moves = new ArrayList<>();
  public static void TOH(int N, int src, int inter, int dest) {
    if(N<=0)
      return;
    TOH(N-1,src,dest,inter);
    pair obj = new pair(N,src,dest);
    moves.add(obj);
    TOH(N-1,inter,src,dest);
  }
  public static void main(String args[]) throws IOException {
  BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
  int N = Integer.parseInt(p.readLine());
  TOH(N,1,3,2);
  System.out.println(moves.size());
  for(int i=0;i<moves.size();i++) {
    System.out.println(moves.get(i).N+" "+moves.get(i).x+" "+moves.get(i).y);
  }
  }
}
