import java.io.*;
import java.util.*;
public class QuantumExperiments {
  public static int solve(int F,int K) {

    if( F == 1 || F == 0)
      return F;
    if(K == 1) {
      return K;
    }
    int ans = Integer.MAX_VALUE;
    for(int k=1;k<=F;k++) {
      int temp = 1+Math.max(solve(k-1,K-1),solve(F-k,K));
      ans = Math.min(ans,temp);
    }
    return ans;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(input.readLine());
    for(int i=0;i<N;i++) {
      int NK[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      int F = NK[0];
      int K = NK[1];
      int ans = solve(F,K);
      System.out.println(ans==1?1:ans+1);

    }
  }
}
