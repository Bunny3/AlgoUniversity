import java.io.*;
import java.util.*;

public class RotateArray {
  public static void main(String args[]) throws IOException{
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String NK[] = p.readLine().trim().split(" ");
    int n = Integer.parseInt(NK[0]);

    int  k = Integer.parseInt(NK[1]);
    String arrNum[] = p.readLine().trim().split(" ");
    // long num[] = new long[n];
    // for(int i=0;i<n;i++) {
    //   num[i] = Long.parseLong(arrNum[i]);
    // }
    for(int i=k;i<n;i++) {
      System.out.print(arrNum[i]+" ");
    }
    for(int i=0;i<k;i++) {
      System.out.print(arrNum[i]+" ");
    }

  }
}
