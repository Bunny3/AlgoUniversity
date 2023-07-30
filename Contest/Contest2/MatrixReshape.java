import java.io.*;
import java.util.*;
public class MatrixReshape {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String NMRC[] = p.readLine().trim().split(" ");
    int N = Integer.parseInt(NMRC[0]);
    int M = Integer.parseInt(NMRC[1]);
    int R = Integer.parseInt(NMRC[2]);
    int C = Integer.parseInt(NMRC[3]);
    int matrix[][] = new int[N][M];
    int ansMatrix[][] = new int[R][C];
    for(int i=0;i<N;i++) {
      String rowString[] = p.readLine().trim().split(" ");
      for(int j=0;j<M;j++) {
        matrix[i][j] = Integer.parseInt(rowString[j]);
      }
    }
    
        if(R*C != N*M) {
      //Print Original array
    for(int i=0;i<N;i++) {
      for(int j=0;j<M;j++) {
        System.out.print(matrix[i][j]+" ");
      }
      System.out.println();
    }
      System.exit(0);
    }
    int t=0,k=0;
    for(int i=0;i<N;i++) {
      for(int j=0;j<M;j++) {
        ansMatrix[t][k] = matrix[i][j];
        k++;
        if(k>=C) {
          t++;
          k=0;
        }
      }
    }

    for(int i=0;i<R;i++) {
      for(int j=0;j<C;j++) {
        System.out.print(ansMatrix[i][j]+" ");
      }
      System.out.println();
    }
  }
}
