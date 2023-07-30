import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class FillSegment {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String NKQ[] = p.readLine().trim().split(" ");
    int N = Integer.parseInt(NKQ[0]);
    int K = Integer.parseInt(NKQ[1]);
    int Q = Integer.parseInt(NKQ[2]);

    int arr[] = new int[N];
    for(int i=0;i<Q;i++) {
      int pos = Integer.parseInt(p.readLine().trim());
      arr[pos-1] = 1;
    }

    for(int i=1;i<N;i++) {
      arr[i] = arr[i]+arr[i-1];
    }
    int min_ = arr[K-1];
    for(int i=1;i<(N-K);i++) {
        min_ = (int)Math.min(min_,(arr[i+K-1]-arr[i-1]));
    }
    System.out.println(min_);
  }
}