import java.util.*;
import java.io.*;

public class PermutationString {
  
  // public static String swap(String str,int i,int j) {
  //   char strArray[] = str.toCharArray();
  //   char ch = strArray[i];
  //   strArray[i] = strArray[j];
  //   strArray[j] = ch;
  //   str = String.valueOf(strArray);
  //   return str;
  // }
  // public static void permute(String str, int i) {
  //   if(i==str.length()) {
  //     System.out.println(str);
  //     return;
  //   } 
  //   for(int j=i;j<str.length();j++) {
  //     str=swap(str,i,j);
  //     permute(str,i+1);
  //     str=swap(str,i,j);
  //   }
  // }
  // public static ArrayList<Character> temp = new ArrayList<Character>();
  public static int N;
  public static String tempStr="";
  public static void permuteString(int freq[], int idx) {
    if(idx == N) {
      // for(int i=0;i<temp.size();i++) {
      //   System.out.print(temp.get(i));
      // }
      System.out.println(tempStr);
      return;
    }

    for(int i=0;i<26;i++) {
      if(freq[i] > 0) {
        // temp.add((char)(i+'a'));
        tempStr = tempStr + (char)(i+'a');
        freq[i]--;
        permuteString(freq,idx+1);
        freq[i]++;
        // temp.remove(temp.size()-1);
        tempStr = tempStr.substring(0, tempStr.length()-1);
      }
    }

  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String orig = p.readLine();
    int freq[] = new int[26];
    Arrays.fill(freq,0);
    for(int i=0;i<orig.length();i++) {
      freq[orig.charAt(i)-'a']++;
    }

    // ArrayList<Character> temp = new ArrayList<>();
    // ArrayList<ArrayList<Character>> ans = new ArrayList<ArrayList<Character>>();
    N = orig.length();
    permuteString(freq,0);
  }
}
