import java.util.*;
public class CountWord {
  public static void main(String args[]) {
    String Line;
    Scanner sc = new Scanner(System.in);
    Line = sc.nextLine();
    StringTokenizer strTok = new StringTokenizer(Line, " ", false);
    System.out.println(strTok.countTokens());
  }
}
