import java.io.*;
import java.util.*;
public class JumpPossibility {

 static boolean ifPossible(int inpArr[],int i,int N, int S,int dp[][]) {
  
    if( S == 0) 
      return true;
    if(i==N-1) {
      return (S == inpArr[i]);
    }

    //Not include
    if(dp[i][S] != -1)
      return dp[i][S] == 1;
    boolean notInclude = ifPossible(inpArr, i+1,N, S,dp);

    //include
    boolean include = false;
    if(S>=inpArr[i]) {
      include =ifPossible(inpArr, i+1,N, S-inpArr[i],dp);
    }

    dp[i][S]= (include||notInclude) == true?1:0;
    return include||notInclude;
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
      System.out.println(ifPossible(inpArr,0,N,S,dp) == true ? "YES" : "NO");
      T--;
    }
    
  }
}
