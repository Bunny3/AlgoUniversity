import java.util.*;
import java.io.*;
public class Main {
  
  public static void findFirstOccurence(int arr[],int target) {
    int L = -1 , R = arr.length;
    while(L+1<R) {
      int mid = L + (R-L)/2;
      if(arr[mid] < target) {
        L = mid;
      } else {
        R = mid;
      }
    }
    if(R==arr.length) {
      System.out.print("-1 ");
    } else {
      if(arr[R] == target)
      System.out.print(R+" ");
      else
      System.out.print("-1 ");
    } 

  }

  public static void findLastOccurence(int arr[], int target) {
    int L = -1 , R = arr.length;
    while(L+1<R) {
      int mid = L + (R-L)/2;
      if(arr[mid] <= target) {
        L = mid;
      } else {
        R = mid;
      }
    }
    if(L==-1) {
      System.out.println("-1 ");
    } else {
      if(arr[L] == target)
        System.out.println(L);
      else
        System.out.println("-1 ");
    }
  }
  public static void  binarySearch(int[] arr, int target) {
    findFirstOccurence(arr,target);
    findLastOccurence(arr,target);

  }
  public static void main(String args[]) throws IOException{
    int N,Q;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String nq[] = br.readLine().trim().split(" ");
    N = Integer.parseInt(nq[0]);
    Q = Integer.parseInt(nq[1]);
    String arrStrs[] = br.readLine().trim().split(" ");
    int arr[] = new int[N];
    for(int  i=0;i<N;i++) {
      arr[i] = Integer.parseInt(arrStrs[i]);
    }
    for(int i=0;i<Q;i++) {
      int temp = Integer.parseInt(br.readLine());
      if(temp<arr[0] || temp>arr[N-1])
      {
        System.out.println(-1+" "+-1);
      } else {
        binarySearch(arr,temp);}

    }
  }
}