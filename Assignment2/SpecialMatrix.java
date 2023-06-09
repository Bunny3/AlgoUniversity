import java.util.*;
import java.io.*;
public class SpecialMatrix {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int  n = Integer.parseInt(p.readLine());
    long matrix[][] = new long[n][n];
    for(int i=0;i<n;i++) {
      String inpS[]= p.readLine().trim().split(" ");
      for(int j=0;j<n;j++) {
        matrix[i][j] = Long.parseLong(inpS[j]);
      }
    }


    long max_sum = 0;
    long row_wise_sum[] = new long[n];
    long col_wise_sum[] = new long[n];

    Arrays.fill(row_wise_sum, 0);
    Arrays.fill(col_wise_sum,0);

    for(int i=0;i<n;i++) {
      for(int j=0;j<n;j++) {
        row_wise_sum[i] +=matrix[i][j];
        col_wise_sum[j] +=matrix[i][j];
        max_sum = Math.max(row_wise_sum[i],max_sum);
        max_sum = Math.max(col_wise_sum[j],max_sum);
      }
    }

    int i=0, j=0;
    long ans=0;
    while(i<n && j<n) {
      long diff = Math.min(max_sum-row_wise_sum[i],max_sum-col_wise_sum[j]);
      ans+=diff;
      row_wise_sum[i] += diff;
      col_wise_sum[j] += diff;
      
      if(row_wise_sum[i] == max_sum)
        i++;
      if(col_wise_sum[j] == max_sum)
        j++;
    }

    System.out.println(ans);
  }


}
