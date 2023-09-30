import java.io.*;
import java.util.*;
public class JumpPossiblity {
  
  public static boolean solve(int jump[],int S, int index, int dp[][]) {
    if(S == 0) {
      return true;
    }
    if(index<0)
      return false;
   if(dp[S][index]!=-1) {
      return dp[S][index] == 0?false:true;
    }
    if(index == 0) {
      dp[S][index]=(S == jump[index])?1:0;
      return (S == jump[index]);
    }
    
    boolean take = false;    
    //Not Include
    boolean notTake = solve(jump,S,index-1,dp);
    //Include
    if(S>=jump[index]) {
      take = solve(jump,S-jump[index],index-1,dp);
    }


    dp[S][index]= (take||notTake)?1:0;
    return (take||notTake);
  } 
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(input.readLine());
    while(T>0) {
      int  ns[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      int N = ns[0];
      int S = ns[1];
      int jumps[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      int dp[][] = new int[S+1][N+1];
      for(int i=0;i<S+1;i++){
        Arrays.fill(dp[i],-1);
      }
      System.out.println(solve(jumps, S, N-1,dp)?"YES":"NO");
      T--;
    }
  }
}
