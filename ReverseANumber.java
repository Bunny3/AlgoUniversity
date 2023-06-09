import java.util.*;
public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    String inp;
    for(int i=0;i<T;i++) {
      inp = sc.next();
      String ans = reverseNumber(inp);
      if(ans.charAt(0) == '0') {
        int k = 0;

        while(k<ans.length()) {
          if(ans.charAt(k)!='0')
          break;
            k++;
        }
        ans = ans.substring(k);
      }
      System.out.println(ans);
    }
  }

  public static String reverseNumber(String n) {
    int l = n.length();
    int i =0;
    int j = l-1;
    char number[] = n.toCharArray();
    while(i<l/2) {
      char  temp = number[i];
      number[i] = number[j];
      number[j] = temp;
      j--;
      i++;
    }
    return String.valueOf(number);
  }
}