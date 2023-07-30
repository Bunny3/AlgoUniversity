import java.util.*;
import java.io.*;

public class PermutationString {
  
  public static String swap(String str,int i,int j) {
    char strArray[] = str.toCharArray();
    char ch = strArray[i];
    strArray[i] = strArray[j];
    strArray[j] = ch;
    str = String.valueOf(strArray);
    return str;
  }
  public static void permute(String str, int i) {
    if(i==str.length()) {
      System.out.println(str);
      return;
    } 
    for(int j=i;j<str.length();j++) {
      str=swap(str,i,j);
      permute(str,i+1);
      str=swap(str,i,j);
    }
  }
  public static void main(String argsp[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String orig = p.readLine();
    char origCh[] = orig.toCharArray();
    Arrays.sort(origCh);
    orig = String.valueOf(origCh);
    permute(orig,0);
  }
}
