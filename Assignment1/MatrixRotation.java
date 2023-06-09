import java.util.*;
import java.io.*;
public class MatrixRotation {
  public static void main(String args[]) throws IOException{
    int N;
    InputStreamReader p = new InputStreamReader(System.in);
    BufferedReader br = new  BufferedReader(p);

    N = Integer.parseInt(br.readLine());
    int matrix[][] = new int[N][N];

    for(int i=0;i<N;i++){
      String line = br.readLine();
      String[] strs = line.trim().split(" ");
      for(int j=0;j<N;j++) {
        matrix[i][j] = Integer.parseInt(strs[j]);
      }
    }

    // for(int i=0;i<N;i++) {
    //   for(int j=0;j<N;j++) {
    //     System.out.print(matrix[i][j] + " ");
    //   }
    //   System.out.println();
    // }

    //Transpose matrix 
    for(int i=0;i<N;i++) {
      for(int j=0;j<=i;j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    // System.out.println("After Transpose");
    // for(int i=0;i<N;i++) {
    //   for(int j=0;j<N;j++) {
    //     System.out.print(matrix[i][j] + " ");
    //   }
    //   System.out.println();
    // }

    //Reverse bottom to top

    for(int i=0;i<N;i++) {
      //reverse
      for(int j=0,k=(N-1);j<N/2;j++,k--) {
        int temp = matrix[j][i];
        matrix[j][i] = matrix[k][i];
        matrix[k][i] = temp;
      }
    }

    // System.out.println("after Reverse");
    for(int i=0;i<N;i++) {
      for(int j=0;j<N;j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
