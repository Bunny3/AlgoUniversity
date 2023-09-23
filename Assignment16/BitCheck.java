import java.util.*;
import java.io.*;

public class BitCheck {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String nb[] = p.readLine().trim().split(" ");
    long n = Long.parseLong(nb[0]);
    int b = Integer.parseInt(nb[1]);

    int dummy = 1;
    dummy = dummy<<(b);
    if((dummy & n) == dummy) 
      System.out.println(1);
    else
      System.out.println(0);
  }
}
