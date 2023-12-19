import java.io.*;
import java.util.*;
public class WaysOfBuilding {

  static int MOD = 1000000007;
 static int findWays(int inpArr[],int i,int N, int S,int dp[][]) {
  
    if(i == N) {
      if(S == 0)
        return 1;
      else
        return 0;
    }
    if( S == 0) 
      return 1;
    if(S<0)
      return 0;
    // if(i==N-1) {
    //   return (S == inpArr[i])?1:0;
    // }
    //Not include
    if(dp[i][S] != -1)
      return dp[i][S];
    int notInclude = findWays(inpArr, i+1,N, S,dp)%MOD;

    //include
    int include = 0;
    include = findWays(inpArr, i,N, S-inpArr[i],dp)%MOD;


    return dp[i][S]=(include+notInclude)%MOD;
  }
  public static void main(String args[])throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int T =Integer.parseInt(input.readLine());
    while(T>0) {
      int NS[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      int N = NS[0];
      int S = NS[1];
      int dp[][] = new int[N+1][S+1];
      for(int i=0;i<N+1;i++)
        Arrays.fill(dp[i],-1);
      int inpArr[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      System.out.println(findWays(inpArr,0,N,S,dp));
      T--;
    }
    
  }
}
