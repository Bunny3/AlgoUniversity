import java.util.*;
import java.io.*;

public class TravellerFund{

  public static int predicate( long mid, long arr[]) {
    long initial = mid;
    for(int i=0;i<arr.length;i++){
      initial = initial+arr[i];
      if(initial<=0)
        return 0;
    } 
    return 1;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int T;
    T = Integer.parseInt(p.readLine());
    while(T>0) {
      int n = Integer.parseInt(p.readLine());
      String narr[] = p.readLine().trim().split(" ");
      long arr[] = new long[n];
      long min_ = 0;
      for(int i=0;i<n;i++) {
        arr[i] = Long.parseLong(narr[i]);
      }
          long l= -1, r = (long)1e15+2;
        while(l+1<r) {
          long mid = l + (r-l)/2;
          if(predicate(mid,arr)==0) {
            l =mid;
          } else {
            r = mid;
          }
        }
        
        System.out.println(r);
        T--;
      } 

  
    }
  }
