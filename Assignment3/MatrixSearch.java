import java.util.*;
import java.io.*;
public class MatrixSearch {
  public static void  main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String nmq[] = br.readLine().trim().split(" ");
    int N = Integer.parseInt(nmq[0]), M = Integer.parseInt(nmq[1]), Q = Integer.parseInt(nmq[2]);
    int matrix[][] = new int[N][M];
    for(int i=0;i<N;i++) {
      String temp[] = br.readLine().trim().split(" ");
      for(int j=0;j<M;j++) {
        matrix[i][j] = Integer.parseInt(temp[j]);
      }
    }

    String query[] = br.readLine().trim().split(" ");
    for(int i=0;i<Q;i++) {
      int target = Integer.parseInt(query[i]);
      int L = -1, R = N*M;
      while(L+1<R) {
        int mid = L + (R-L)/2;
        int nrow = mid/M;
        int ncol = mid%M;
  
        if(matrix[nrow][ncol]<target) {
          L = mid;
        } else {
          R = mid;
        }
      }
      System.out.println(R/M + " " + R%M);
    }
  }
}
