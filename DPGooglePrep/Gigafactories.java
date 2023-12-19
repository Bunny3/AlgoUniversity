import java.io.*;
import java.util.*;
public class Gigafactories {
  public static int solve(int N,int C,int cost[],int value[]) {
    if(N==0)
      return 0;
    if(C == 0) {
      return 0;
    }
    //notinclude
    int notInclude = solve(N-1,C,cost,value);
    //include
    int include =0;
    if(C>=cost[N-1]) {
      include = solve(N-1,C-cost[N-1],cost,value)+value[N-1];
    }

    return Math.max(include,notInclude);
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int NC[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();


    int N = NC[0];
    int C = NC[1];
    int cost[] = new int[N];
    int value[] = new int[N];
    for(int i=0;i<N;i++) {  
      int temp[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      cost[i] = temp[0];
      value[i] = temp[1];
    }
    int dp[][] = new int[N+1][C+1];
    for(int i=0;i<N+1;i++) {
      for(int j=0;j<C+1;j++) {
        if(i==0 || j==0)
          dp[i][j] = 0;
        else {
          //notInclude
          dp[i][j] = dp[i-1][j];
          if(j>=cost[i-1]) {
            dp[i][j] = Math.max(dp[i][j],dp[i-1][j-cost[i-1]]+value[i-1]);
          }
        }
      }
    }
    System.out.println(dp[N][C]);
    // for(int i=0;i<N+1;i++) {
    //   for(int j=0;j<C+1;j++) {
    //     System.out.print(dp[i][j]+" ");
    //   }
    //   System.out.println();
    // }
    // System.out.println(solve(N, C, cost, value));
  }
}
