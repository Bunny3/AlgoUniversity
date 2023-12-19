import java.io.*;
import java.util.*;
public class CoinCombination2 {
  public static int solve(int coins[],int x,int n,int indx,int dp[][]) {
    if(indx == n)
    {
      return 0;
    }
    if(x == 0) {
      return 1;
    }
    if(dp[x][indx]!=-1)
      return dp[x][indx];
    int notTake = solve(coins,x,n,indx+1,dp);
    int take = 0;
    if(coins[indx]<=x) {
      take = solve(coins,x-coins[indx],n,indx,dp);
    }
    return dp[x][indx] = (take%1000000007 + notTake%1000000007)%1000000007;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int nsum[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int n = nsum[0];
    int x = nsum[1];
    int dp[][] = new int[n+1][x+1];
    for(int i=0;i<n+1;i++)
      Arrays.fill(dp[i],0);
    int coins[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    // int ans = solve(coins,x,n,0,dp);
    for(int i=0;i<n+1;i++){
      dp[i][0]=1;
    }
    for(int i=n-1;i>=0;i--) {
      for(int j=0;j<=x;j++) {
        int notTake = dp[i+1][j];
        int take=0;
        if(j>=coins[i]) {
          take = 1+dp[i][j-coins[i]];
        }
        dp[i][j] = take + notTake;
      }
    }
    System.out.println(dp[n][x]);
  }
}
