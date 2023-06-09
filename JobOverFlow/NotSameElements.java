import java.util.*;
import java.io.*;
public class NotSameElements {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(p.readLine());
    String nSrc[] = p.readLine().trim().split(" ");
    long src[] = new long[n];
    for(int i=0;i<n;i++)
    {
      src[i] = Long.parseLong(nSrc[i]);
    }
    int m = Integer.parseInt(p.readLine());
    String nDes[] = p.readLine().trim().split(" ");
    long des[] = new long[n];
    for(int i=0;i<m;i++)
    {
        des[i] = Long.parseLong(nDes[i]);
    }

    HashMap<Integer,Integer> mp1 = new HashMap<>();
    HashMap<Integer,Integer> mp2 = new HashMap<>();

  }
}
