// Use Fast Input/Output in this Question

// What is fast i/o & how you can implement it in your language:

// C++: https://www.geeksforgeeks.org/fast-io-for-competitive-programming/
// Java: https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
// Python: https://www.geeksforgeeks.org/fast-i-o-for-competitive-programming-in-python/
// The Sphinx has presented you with N
//  numbers. The i
// -th number is ni
// . The sphinx now asks you Q
//  questions. The j
// -th question specifies two integers lj
//  and rj
// . You must answer with the sum of integers in the range [lj,rj]
// . That is the sum of all ni
//  where lj≤i≤rj
// .

// Input
// One integer N
//  on the first line.

// N
//  integers on the second line. The i
// -th integer is ni
// .

// One integer Q
//  on the third line.

// Q
//  lines follow. The j
// -th of these lines has two integers lj
//  rj
// .

// Constraints
// 1≤N,Q≤106
// 1≤ni≤106
// 1≤li≤ri≤N
// Output
// Q
//  lines with one answer on each --- the answer to the j
// -th query on the j
// -th line.

// Example 1
// Input
// 9
// 4 4 3 1 5 4 5 4 2
// 5
// 1 6
// 2 8
// 1 3
// 4 8
// 5 8
// Output
// 21
// 26
// 11
// 19
// 18
// Example 2
// Input
// 14
// 1 1 1 5 5 5 1 1 4 5 1 2 1 2
// 5
// 1 11
// 9 10
// 4 13
// 5 13
// 3 5
// Output
// 30
// 9
// 30
// 25
// 11
// Limits
// Time: 4
// s
// Memory: 256
//  MB
import java.util.*;
import java.io.*;
public class SphinxRangeSum {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    String inp[] = p.readLine().trim().split(" ");
    long arr[] = new long[N];
    for(int i=0;i<N;i++) {
      arr[i] = Long.parseLong(inp[i]);
    }
    long Q = Long.parseLong(p.readLine());
    long prefixSum[] = new long[N+1];
    prefixSum[1] = arr[0];
    for(int i=2;i<=N;i++) {
      prefixSum[i] = arr[i-1] + prefixSum[i-1];
    }

    for(int i=0;i<Q;i++) {
      String lrs[]=p.readLine().trim().split(" ");
      int l = Integer.parseInt(lrs[0]);
      int r = Integer.parseInt(lrs[1]);
      System.out.println(prefixSum[r]-prefixSum[l-1]);
    }
  }
}
