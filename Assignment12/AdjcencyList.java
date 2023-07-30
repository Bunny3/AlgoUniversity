import java.util.*;
import java.io.*;
public class AdjcencyList {
  public static void main(String args[]) throws IOException {
    int N;
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(p.readLine());
    for(int i=1;i<=N;i++) {
      String tempArr[] = p.readLine().trim().split(" ");
      System.out.print(i+": ");
      for(int j=0;j<N;j++){
        if(Integer.parseInt(tempArr[j]) == 1) {
          System.out.print((j+1)+" ");
        }
      }
      System.out.println();
    }
  }
}
