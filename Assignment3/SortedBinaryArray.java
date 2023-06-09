import java.util.*;
import java.io.*;

public class SortedBinaryArray {
  
  public static void main(String args[]) throws IOException{
    int n;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    int arr[] = new int[n];
    String strs = br.readLine();
    String strsArr[] = strs.trim().split(" ");
    for(int i=0;i<n;i++) {
      arr[i] = Integer.parseInt(strsArr[i]);
    }

    int  L = -1, R= n;
    while(L+1<R) {
      int mid = L + (R-L)/2;
      if(arr[mid] == 0)
      {
        L = mid;
      } else {
        R = mid;
      }
    }
    if(R==n) {
      System.out.print(n+" ");
    } else {
      System.out.print(R+" ");
    }

    L = -1;
    R= n;
    while(L+1<R) {
      int mid = L + (R-L)/2;
      if(arr[mid] == 0)
      {
        L = mid;
      } else {
        R = mid;
      }
    }
    if(L==-1) {
      System.out.print("-1 ");
    } else {
      System.out.print(L);
    }
  }
}
