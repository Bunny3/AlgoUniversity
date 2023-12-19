import java.io.*;
import java.util.*;

public class MinimumCoins {
  public static int findMinimumNumberOfCoins(int coins[],int n,int x, int dp[]) {

    // if(x<0)
    //   return Integer.MAX_VALUE;
    if(x == 0) {
      return 1;
    }
    if(dp[x]!=-1) 
      return dp[x];
    int minCoins = Integer.MAX_VALUE;
    for(int i=0;i<n;i++) {
      if(x>=coins[i]) {
        int value = findMinimumNumberOfCoins(coins,n,x-coins[i],dp);
        if(value!=Integer.MAX_VALUE) {
          minCoins = Math.min(minCoins,1+value);
        }
      }
    }
    return dp[x]=minCoins;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int nsum[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int n = nsum[0];
    int x = nsum[1];
    int coins[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    // for(int i=0;i<n;i++) {
    //   coins[i] = Integer.parseInt(input.readLine());
    // }
    int dp[] = new int[x+1];
    Arrays.fill(dp,Integer.MAX_VALUE);
    // int ans = findMinimumNumberOfCoins(coins,n,x,dp);

    // if(ans == Integer.MAX_VALUE)
    // System.out.println(-1);
    // else
    // System.out.println(ans-1);
    dp[0] = 1;
    for(int i=1;i<=x;i++) {
      for(int j=0;j<n;j++) {
        if(i>=coins[j]) {
          if(dp[i-coins[j]]!=Integer.MAX_VALUE) {
            dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);
          }
        }
      }
    }

   System.out.println(dp[x]==Integer.MAX_VALUE ? -1 :dp[x]-1);

  }
}
