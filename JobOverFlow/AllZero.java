// import java.util.*;
// import java.io.*;


// public class AllZero {
  
//   public static int predicate(long mid, long arr[], long M) {
//     long noOfOperation = 0;
//     for(int i=0;i<arr.length;i++) {
//       noOfOperation+=(long)Math.ceil(arr[i]/(double)mid);
//     }
//     if (noOfOperation<=M) {
//       return 1;
//     } else {
//       return 0;
//     }
//   }
//   public static void main(String args[]) throws IOException {
//     BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
//     int T=Integer.parseInt(p.readLine());
//     while(T>0) {
//       String NM[] = p.readLine().trim().split(" ");
//       int N = Integer.parseInt(NM[0]);
//       long M = Long.parseLong(NM[1]);
//       String Ninp[] = p.readLine().trim().split(" ");
//       long arr[] = new long[N];
//       long max = -1;
//       int nonZero = 0;
//       for(int i=0;i<N;i++) {
//         arr[i] = Long.parseLong(Ninp[i]);
//         // max = (long)Math.max(max,arr[i]);
//         if(arr[i]!=0)
//           nonZero++;
//       }
//       if(nonZero<=M) {
//       Arrays.sort(arr);
//       long l=0, r= arr[N-1];
//       while(l+1<r) {
//         long mid = l + (r-l)/2;
//         if(predicate(mid,arr,M)==0) 
//           l=mid;
//         else
//           r=mid;
//       }
//       System.out.println(r);
//     }
//     else {
//       System.out.println(-1);
//     }
//       T--;
//     }

//   }
// }


import java.util.*;
import java.io.*;


public class AllZero {
  
  public static int predicate(long mid, long arr[], long M) {
    long noOfOperation = 0;
    // System.out.println("iteration begin");
    for(int i=0;i<arr.length;i++) {
      noOfOperation+=(long)Math.ceil(arr[i]/(double)mid);
      // System.out.println((long)Math.ceil(arr[i]/mid));
    }
    // System.out.println("Iteration End");

    // System.out.println(mid+"------>"+noOfOperation);
    if (noOfOperation<=M) {
      return 1;
    } else {
      return 0;
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int T=Integer.parseInt(p.readLine());
    while(T>0) {
      String NM[] = p.readLine().trim().split(" ");
      int N = Integer.parseInt(NM[0]);
      long M = Long.parseLong(NM[1]);
      String Ninp[] = p.readLine().trim().split(" ");
      long arr[] = new long[N];
      long maxm = 0;
      int nonZero = 0;
      for(int i=0;i<N;i++) {
        arr[i] = Long.parseLong(Ninp[i]);
        maxm = (long)Math.max(arr[i],maxm);
      }
      if(maxm==0)
      {
        System.out.println(0);
      }
      else {
      Arrays.sort(arr);
      long l=0, r= (long)1e18;
      while(l+1<r) {
        long mid = l + (r-l)/2;
        if(predicate(mid,arr,M)==0) 
          l=mid;
        else
          r=mid;
      }
      
    // }
    // else {
    if(r == (long)1e18)
      System.out.println(-1);
    else 
      System.out.println(r);
    }
      T--;
    }

  }
}
