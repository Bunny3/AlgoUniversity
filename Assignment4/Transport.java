import java.util.*;
import java.io.*;

public class Transport {

public static int predicate(long mid, int C, int M, int arr[]) {
  int buses = 1;
  int capacity = 1;
  int first_person = arr[0];
  int i = 0;
  while(i<arr.length) {
    if((arr[i]-first_person > mid) || (capacity>C)) {
      buses++;
      capacity=1;
      first_person = arr[i];
    }
    capacity++;
    i++;
  }

  if(buses<=M)
    return 1;
  else 
    return 0;
}
  
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String nmc[] = p.readLine().trim().split(" ");
    int N = Integer.parseInt(nmc[0]);
    int M = Integer.parseInt(nmc[1]);
    int C = Integer.parseInt(nmc[2]);

    String strArr[] = p.readLine().trim().split(" ");
    int arr[] = new int[N];
    for(int i=0;i<N;i++) {
      arr[i] = Integer.parseInt(strArr[i]);
    }
    Arrays.sort(arr);
    long l=-1;
    long r=(long)1e9+1;

    while(l+1<r) {
      long mid = l + (r-l)/2;
      if(predicate(mid, C, M, arr)==0)
        l=mid;
      else
        r=mid;
    }

    System.out.println(r);
  }
}
