import java.io.*;
import java.util.*;

public class WineBottle {
  public static int solveMaxProfit(int i,int j,int wine[], int dp[][]) {
    // if(i>wine)
    if(dp[i][j]!=-1)
      return dp[i][j];
    if(i==j){
      return dp[i][j]=wine.length * wine[i];
    }  
    int Y = wine.length - (j-i);
    int left = Y*wine[i]+solveMaxProfit(i+1, j, wine,dp);
    int right = Y*wine[j]+solveMaxProfit(i, j-1, wine,dp);

    return dp[i][j]=(int)Math.max(left,right);
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(p.readLine());
    int inputArray[] = Arrays.stream(p.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int dp[][] = new int[n][n];
    for(int i=0;i<n;i++) {
      Arrays.fill(dp[i],-1);
    }
    int ans = solveMaxProfit(0, n-1, inputArray,dp);
    System.out.println(ans);;
  }
}
