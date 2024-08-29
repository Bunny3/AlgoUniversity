import java.util.*;
import java.io.*;

public class OriginalKadane {

  static int max_ans = 0;
  public static int findMaxSumSubArray(int index,int inpArray[],int dp[]) {
    if(index == 0)
      return inpArray[0];
    if(dp[index]!=-1)
      return dp[index];
    int ans = Math.max(findMaxSumSubArray(index-1,inpArray,dp)+inpArray[index],inpArray[index]);
    dp[index] = ans;
    max_ans = Math.max(max_ans,ans);
    return ans;
  }
  public static int maxSubArraySum(int a[], int size)
{
    int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
 
    for (int i = 0; i < size; i++)
    {
        max_ending_here = max_ending_here + a[i];
        max_so_far = Math.max(max_so_far, max_ending_here);
 
        if (max_ending_here < 0)
            max_ending_here = 0;
    }
    return max_so_far;
}
  public static void main(String args[]) throws IOException {
    BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(inp.readLine());
    int inpArr[] = Arrays.stream(inp.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int dp[] = new int[N];
    Arrays.fill(dp,-1);
    // int ans = findMaxSumSubArray(N-1,inpArr,dp);
    // System.out.println(max_ans);
    System.out.println(maxSubArraySum(inpArr,N));
  }
}
