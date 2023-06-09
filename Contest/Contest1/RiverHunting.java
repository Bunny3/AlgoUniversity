import java.io.*;
import java.util.*;

public class RiverHunting {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int Q = Integer.parseInt(p.readLine());
    for(int i=0;i<Q;i++) {
      long N = Long.parseLong(p.readLine());
      System.out.println((int)Math.ceil(Math.log(N)/Math.log(2)));
    }
  }
}
