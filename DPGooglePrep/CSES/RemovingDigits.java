import java.util.*;
import java.io.*;
public class RemovingDigits {
// public static List<Integer> allDigitsList(int n) {
//   String s = ""+n;
//   List<Integer> ans = new ArrayList<Integer>();
//   Set<Integer> st = new HashSet<Integer>();
//   for(int i=0;i<s.length();i++) {
//     st.add(s.charAt(i)-'0');
//   }
//   Iterator<Integer> setIterator = st.iterator();
//   while(setIterator.hasNext()) {
//     ans.add(setIterator.next());
//   }
//   return ans;
// }
public static int findMinSteps(int n,int dp[]) {
  if(n<0)
    return 0;
  if(n == 0)
    return 1;
  if(dp[n]!=-1) 
    return dp[n];
  // List<Integer> digits = allDigitsList(n);
  int minSteps = Integer.MAX_VALUE;
  
  for(char ch:Integer.toString(n).toCharArray()) {
    if((ch-'0')<=n) {
      int value = findMinSteps(n-(ch-'0'),dp);
      if(value!=Integer.MAX_VALUE) {
        minSteps = Math.min(minSteps,1+value);
      }
    }
  }
  return dp[n]=minSteps;
}
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(input.readLine());
    int dp[] = new int[n+1];
    Arrays.fill(dp,Integer.MAX_VALUE);
    // int ans = findMinSteps(n,dp);
    dp[0]=0;
    for(int i=0;i<=n;i++) {
      for(char ch:Integer.toString(i).toCharArray()) {
        if((ch-'0')<=i) {
          dp[i] = Math.min(dp[i],dp[i-(ch-'0')]+1);
        }
      }
    }
    System.out.println(dp[n]);
  }
}
