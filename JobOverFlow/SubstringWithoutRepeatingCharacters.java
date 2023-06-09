// Given a string s
// , find the length of the longest substring without repeating characters.

// Input
// The first line contains an integer n
//  denoting the length of the string. The second line contains a string s
//  consisting of English letters, digits, and symbols.(1≤n≤5⋅104).
// Output
// Output the longest substring without repeating characters

// Examples
// input
// 9
// abcgracse
// output
// 6
// input
// 4
// okuo
// output
// 3
// input
// 8
// abcAacbB
// output
// 5
// input
// 5
// bbbbb
// output
// 1
// input
// 6
// $dgr$4
// output
// 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
public class SubstringWithoutRepeatingCharacters {

  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    String str = p.readLine().trim();

    HashMap<Character, Integer> mp = new HashMap<>();
    int i = 0;
    int ans=0;
    for(int j=0;j<N;j++)
    {
        mp.put(str.charAt(j),-1);
    }
    for(int j=0;j<N;j++)
    {
        i = Math.max(i,mp.get(str.charAt(j))+1);
        ans = Math.max(ans,j-i+1);
        mp.put(str.charAt(j),j);
    }
    System.out.println(ans);
  }
  
}
