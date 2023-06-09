import java.util.*;
import java.io.*;

public class NumberOfTriangle {

  public static int predicate(int arr[],int sum, int mid) {
    if(arr[mid]<sum)
      return 0;
    else
      return 1;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    String narr[] = p.readLine().trim().split(" ");
    int arr[] = new int[N];
    for(int i=0;i<N;i++) {
      arr[i] = Integer.parseInt(narr[i]);
    }

    Arrays.sort(arr);
    for(int i=0;i<arr.length;i++) {
      System.out.print(arr[i]+" ");
    }
    System.out.println();
    int ans=0;
    for(int i=0;i<N;i++) {
      int a = arr[i];
      for(int j=i+1;j<N;j++) {
        int b = arr[j];
        int l=j,r=N;
        while(l+1<r) {
          int mid = l + (r-l)/2;
          if(predicate(arr,(a+b),mid)==0) {
            l=mid;
          } else {
            r=mid;
          }
        }
        if(l==j) {

        } else {
          ans+=(l-j);
        }
      }
    }
    System.out.println(ans);
  }
  
}
