import java.util.*;
import java.io.*;

public class RotatedSearch {
  
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(p.readLine());
    String str[] = p.readLine().trim().split(" ");
    long arr[] = new long[n];
    for(int i=0;i<n;i++) {
      arr[i] = Long.parseLong(str[i]);
    }

    int pos=-1;
    for(int i=0;i<n-1;i++) {
      if(arr[i]>arr[i+1]) {
        pos = i;
        break;
      }   
    }
    System.out.println(arr[pos+1]);;
  }
}
