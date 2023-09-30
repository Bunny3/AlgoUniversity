import java.io.*;
import java.util.*;
public class NumberedChocolate {
  public static int solve(int valueArray[],int index,int capacity, int dp[][]) {
    if(index>=capacity) return 0;
    if(dp[index][capacity]!=-1) return dp[index][capacity];
    //not take
    int notTake = solve(valueArray, index+1, capacity, dp);
    //take
    int take = 0;
    if(capacity>=(index+1))
    take = valueArray[index] + solve(valueArray, index, capacity-(index+1), dp);

    int ans = (int)Math.max(take,notTake);
    dp[index][capacity] = ans;
    return ans;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(input.readLine());
    while(T>0) {
      int N = Integer.parseInt(input.readLine());
      int valueArray[] = Arrays.stream(input.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      int dp[][] = new int[N+1][N+1];
      for(int i=0;i<N;i++) Arrays.fill(dp[i],-1);
      System.out.println(solve(valueArray,0,N,dp)); 
      T--;
    }
  }
}
