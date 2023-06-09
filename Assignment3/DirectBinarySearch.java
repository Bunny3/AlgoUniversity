import java.util.*;
import java.io.*;


public class DirectBinarySearch {
  
  public static void main(String args[]) throws IOException {
    int N,Q;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String nq = br.readLine();
    String nqstr[] = nq.trim().split(" ");
    N= Integer.parseInt(nqstr[0]);
    Q= Integer.parseInt(nqstr[1]);

    String inputString = br.readLine();
    String inpStringArr[] = inputString.trim().split(" ");
    int arr[] = new int[N];
    for(int i=0;i<N;i++) {
      arr[i] = Integer.parseInt(inpStringArr[i]);
    }

    String inpQuery[] = br.readLine().trim().split(" ");
    int queryArr[] = new int[Q];
    for(int i=0;i<Q;i++) {
      queryArr[i] = Integer.parseInt(inpQuery[i]);
    }
    for(int i=0;i<Q;i++) {
      System.out.println(Arrays.binarySearch(arr,queryArr[i])+" ");
    }
  }
}
