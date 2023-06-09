import java.util.*;
public class Palindrome {
  public static void main(String args[]) {
    int T;
    Scanner sc = new Scanner(System.in);
     T = sc.nextInt();
     while(T-- > 0) {
      String n = sc.next();
      palindrome(n);
     }
  }
  public static void palindrome(String n) {
    int i = 0;
    int len = n.length();
    int j = len-1;
    boolean b = true;
    while(i<len/2) {
      if(n.charAt(i)!=n.charAt(j)) {
        b =false;
        break;
      }
      i++;j--;
    }
    if(b == true) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  } 
}
