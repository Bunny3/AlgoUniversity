import java.io.*;
public class BoxPacking {
  
  public static int predicate(long mid, long w, long h, long n) {
    long numberOfBox = ((mid/w) * (mid/h));
    if(numberOfBox < n) {
      return 0;
    } else {
      return 1;
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    long N = Long.parseLong(p.readLine());
    for(int i=0;i<N;i++) {
      String whn[] = p.readLine().trim().split(" ");
      long w = Long.parseLong(whn[0]);
      long h = Long.parseLong(whn[1]);
      long n = Long.parseLong(whn[2]);

      long l=0, r = 1;
      while(predicate(r,w,h,n)==0) {
         r = r*2;
      }

      while(l+1<r) {
        long mid = l + (r-l)/2;
        if(predicate(mid, w, h ,n)==0)
          l= mid;
        else
          r= mid;
      }
      System.out.println(r);
    }
  }
}


