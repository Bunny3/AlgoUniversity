import java.io.*;
import java.util.*;
public class CicularKadane {
  public static int GetMaxSumSubarray(int[] A) { 
    //Solution 1: Wrong Approach
    //Solution 2:
    //Find 2 ways: 1st maximum. Second minimum , 
    //Max of both
    int prevBest = 0;
    int N = A.length;
    int max_ = A[0];
    for(int i=0;i<N;i++) {
      prevBest = (int)Math.max(prevBest+A[i],A[i]);
      max_ = (int)Math.max(prevBest,max_);
    }

    //Find minimums contiguous
    prevBest = 0;
    int min_ = A[0];
    int sum =0;
    for(int i=0;i<N;i++) {
      prevBest = (int) Math.min(prevBest+A[i],A[i]);
      min_ = (int) Math.min(prevBest,min_);
      sum += A[i];
    }
    return max_>0?(int)Math.max(max_, (sum-min_)):max_;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    String Astring[] = p.readLine().trim().split(" ");
    int A[] = new int[N];
    for(int i=0;i<N;i++) {
      A[i] = Integer.parseInt(Astring[i]);
    }
  System.out.println(GetMaxSumSubarray(A));
  }
}
