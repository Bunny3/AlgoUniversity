import java.io.*;
import java.util.*;
public class CoinCombination {
  public static int findNumberOfCombinations(int coins[],int x,int n){
    if(x == 0) 
      return 1;
    int numOfCoins = 0;
    for(int i=0;i<n;i++) {
      if(coins[i]<=x){
        numOfCoins += findNumberOfCombinations(coins,x-coins[i],n);
      }
    }
    return numOfCoins;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int nsum[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int n = nsum[0];
    int x = nsum[1];
    int coins[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    // int ans = findNumberOfCombinations(coins,x,n);
    // System.out.println(ans);
    int dp[] = new int[x+1];
    Arrays.fill(dp,0);
    dp[0] = 1;
    for(int i=0;i<=x;i++) {
      for(int j=0;j<coins.length;j++) {
        if(i>=coins[j]) {
          dp[i] = (dp[i]+dp[i-coins[j]])%1000000007;
        }
      }
    }
    // for (int weight = 0; weight <= x; weight++) {
    //   for (int i = 1; i <= n; i++) {
    //     if (weight - coins[i - 1] >= 0) {
    //       dp[weight] += dp[weight - coins[i - 1]];
    //       dp[weight] %= MOD;
    //     }
    //   }
    // }
    System.out.println(dp[x]%1000000007); 
  }
}
