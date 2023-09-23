import java.io.*;
import java.util.*;

public class DoublingAmoeba {
  static int countSetBits(int n)
  {
      int count = 0;
      while (n > 0) {
          n &= (n - 1);
          count++;
      }
      return count;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(input.readLine());
    System.out.println(countSetBits(n));
  }
}
