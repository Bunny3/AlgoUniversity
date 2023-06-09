// You are given a string S
//  , and a list of strings which needs to be substituted in the input string S
// .

// A substitution is a tuple (Li,Ri,subsi)
//  which denotes that we need to substitute the substring S[Li...Ri]
//  with subsi
// .

// It is guaranteed that all the intervals are non-overlapping.

// You must find out the modified string Sm
//  after incurring all substitutions.

// Input
// First line contains a string corresponding to S
// Second line contains a single integer N corresponding to the total number of substitutions

// N lines are followed containing each tuple (Li,Ri,subsi)
// Contraints

// 1≤|S|≤1000000
// 1≤Li≤Ri≤1000000
// Output
// A single string Sm
//  which corresponds to the modified string after all substitutions.

// Example
// input
// Alice_saw_a_tiger
// 2
// 0 4 Bob
// 12 18 Cat
// output
// Bob_saw_a_Cat

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.*;

public class StringSubstitution {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String inp = p.readLine();
    int n = Integer.parseInt(p.readLine());
    String qString[][] = new String[n][3];
    for(int i=0;i<n;i++) {
      qString[i]=p.readLine().trim().split(" ");
    }
    Arrays.sort(qString,new Comparator<String[]>(){
      public int compare(final String[] a,
                          final String[] b) {
                            return b[0].compareTo(a[0]);
                          }
    });

    for(int i=0;i<n;i++) {
      int start = Integer.parseInt(qString[i][0]);
      int end = Integer.parseInt(qString[i][1]);
      String replacement = qString[i][2];
      String temp1="",temp2="";
      if(start<inp.length())
        temp1 = inp.substring(0, start);
      if(end+1<inp.length())
        temp2 = inp.substring(end+1);
      inp = temp1+replacement+temp2;
    }
    System.out.println(inp);
  }
  
}
