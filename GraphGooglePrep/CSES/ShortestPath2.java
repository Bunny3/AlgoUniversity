import java.io.*;
import java.util.*;
public class ShortestPath2 {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int nmq[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int n = nmq[0];
    int m = nmq[1];
    int q = nmq[2];
    int adjList[][] = new int[n+1][n+1];
    for(int i=1;i<=n;i++) {
      for(int j=1;j<=n;j++) {
        adjList[i][j] = 100000001;
        if(i == j) {
          adjList[i][j] = 0;
        }
      }
    }
    for(int i=0;i<m;i++) {
      int abc[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      adjList[abc[0]][abc[1]] = abc[2];
      adjList[abc[1]][abc[0]] = abc[2];
    }


    for(int k=1;k<=n;k++) {
      for(int i=1;i<=n;i++) {
        for(int j=1;j<=n;j++) {
          adjList[i][j] = Math.min(adjList[i][j],adjList[i][k]+adjList[k][j]); 
        }
      }
    }

    while(q>0) {
      int a,b;
      q--;
      int ab[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      if(adjList[ab[0]][ab[1]] == 100000001) {
        System.out.println(-1);
      } else {
        System.out.println(adjList[ab[0]][ab[1]]);
      }
    }
  }
}
