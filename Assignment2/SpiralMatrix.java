import java.util.*;
import java.io.*;
public class SpiralMatrix {
  public static void main(String args[]) throws IOException{
    int i=0,k=0,l=0,m,n;
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String mn[]= p.readLine().trim().split(" ");
    m=Integer.parseInt(mn[0]);
    n=Integer.parseInt(mn[1]);

    int matrix[][] = new int[m][n];
    for(i=0;i<m;i++) {
      String row[] = p.readLine().trim().split(" ");
      for(int j=0;j<n;j++) {
        matrix[i][j] = Integer.parseInt(row[j]);
      }
    }


    while(k<m && l<n) {
      for(i=l;i<n;i++) {
        System.out.print(matrix[k][i]+" ");
      }
      k++;
      for(i=k;i<m;i++) {
        System.out.print(matrix[i][n-1]+" ");
      }
      n--;
      if(k<m) {
        for(i=n-1;i>=l;i--){
          System.out.print(matrix[m-1][i]+" ");
        }
        m--;
      }
      if(l<n) {
        for(i=m-1;i>=k;i--) {
          System.out.print(matrix[i][l]+" ");
        }
        l++;
    }
    }
  }
}
