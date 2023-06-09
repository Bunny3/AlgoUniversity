import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Emptypile {

  public static long predicate(long mid,long h,int n, double arr[]) {
    //no. of operation
    long copps=0;
    for(int i=0;i<n;i++) {
      copps += Math.ceil(arr[i]/mid);
    }
    if(copps<=h) 
      return 1;
    else
      return 0;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String nh[] = p.readLine().trim().split(" ");
    int n = Integer.parseInt(nh[0]);
    long h = Integer.parseInt(nh[1]);
    String inpArr[] = p.readLine().trim().split(" ");
    double arr[] = new double[n];
    long maxarr = 0;
    for(int i=0;i<n;i++) {
      arr[i] = Double.parseDouble(inpArr[i]);
      maxarr = (long)Math.max(maxarr, arr[i]);
    }

    long l=0, r=maxarr;

    while(l+1<r) {
      long mid = l + (r-l)/2;
      if(predicate(mid,h,n,arr) == 0 )
       l=mid;
       else
       r=mid;
    }
    System.out.println(r);
  }
}
