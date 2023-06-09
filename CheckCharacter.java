import java.util.*;
public class CheckCharacter {
  
  public static void main(String args[]) {
    String str;
    Scanner sc = new Scanner(System.in);
    str = sc.next();
    if(str.length()>1) {
      System.out.println("error");
    } else {
      char ch = str.charAt(0);
      if(ch>=65 && ch<=90) {
        System.out.println("upper");
      } else if(ch>=97 && ch<=122) {
          System.out.println("lower");
        } else {
          System.out.println("error");
        }
      
    }
  }
}
