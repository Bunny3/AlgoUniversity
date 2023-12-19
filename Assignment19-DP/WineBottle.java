import java.io.*;
import java.util.*;

public class WineBottle {
  static int MOD = 1000000007;
  static int findMaximumProfit(int i,int j, int wineBottle[], int N,int dp[][]) {
    if(i == j) {
      return N*wineBottle[i];
    }
    if(dp[i][j]!=-1)
    return dp[i][j];
    int years = N - (j-i+1)+1;
    int ans = Math.max((findMaximumProfit(i+1,j,wineBottle,N,dp)+years*wineBottle[i])%MOD, (findMaximumProfit(i,j-1,wineBottle,N,dp)+years*wineBottle[j])%MOD);

    return dp[i][j]=ans%MOD;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N =Integer.parseInt(input.readLine());
    int inpArr[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int dp[][] = new int[N][N];
    for(int i=0;i<N;i++)
      Arrays.fill(dp[i],-1);
    System.out.println(findMaximumProfit(0,N-1,inpArr,N,dp));
  }
}
