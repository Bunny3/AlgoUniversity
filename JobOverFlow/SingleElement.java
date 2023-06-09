import java.util.*;
import java.io.*;
public class SingleElement {
  
  public static void search(long arr[], int low, int high) {
    if(low>high)
      return;
    if(low==high)
    {
      System.out.println(arr[low]);
      return;
    }

    int mid = low + ((high-low)/2);
    if(mid%2 == 0) {
      if(arr[mid] == arr[mid+1]) {
        search(arr,mid+2,high);
      } else {
        search(arr,low,mid);
      }
    } else if (mid%2 == 1) {
      if(arr[mid]==arr[mid-1]) {
        search(arr, mid+1, high);
      } else {
        search(arr, low, mid-1);
      }
    }

  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(p.readLine());
    while(T>0) {
      int N = Integer.parseInt(p.readLine());
      String narr[] = p.readLine().trim().split(" ");
      long arr[] = new long[N];
      for(int i=0;i<N;i++) {
        arr[i] =Long.parseLong(narr[i]);
      }
      Arrays.sort(arr);
      int low = 0, high = N-1;
      search(arr,low,high);
      T--;
    }
  }
}

