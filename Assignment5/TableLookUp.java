import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class TableLookUp {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String nmx[] = p.readLine().trim().split(" ");
    int n = Integer.parseInt(nmx[0]);
    int m = Integer.parseInt(nmx[1]);
    int x = Integer.parseInt(nmx[2]);
    int matrix[][] = new int[n][m];

    for(int i=0;i<n;i++) {
      String inpTemp[] = p.readLine().trim().split(" ");
      for(int j=0;j<m;j++) {
        matrix[i][j] = Integer.parseInt(inpTemp[j]);
      }
    }
    int i=0, j=n-1;
    while(i>=0 && j<n) {
      if(matrix[i][j] == x) {
        System.out.println("YES");
        System.exit(0);
      } else {
        if(matrix[i][j]<x) {
          i++;
        } else if(matrix[i][j] >x) {
          j--;
        }
      }
    }
    System.out.println("NO");
  }
}
