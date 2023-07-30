import java.util.*;
import java.io.*;

public class NearestLargestNumber {
  
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int  n = Integer.parseInt(p.readLine());
    String strHeights[] = p.readLine().trim().split(" ");
    long arrHeight[] = new long[n];
    for(int i=0;i<n;i++) {
      arrHeight[i] = Integer.parseInt(strHeights[i]);
    }

    System.out.print("-1 ");
    Stack<Long> st = new Stack<Long>();
    st.push(arrHeight[0]);
    for(int i=1;i<arrHeight.length;i++) {
      if(arrHeight[i]<st.peek()) {
        System.out.print(st.peek()+" ");
        st.push(arrHeight[i]);
      } else {
        while(!st.empty() && arrHeight[i]>=st.peek()) {
          st.pop();
        }
        if(!st.empty())
          System.out.print(st.peek()+" ");
        else
          System.out.print(-1+" ");
        st.push(arrHeight[i]);
      }
    }
  }
}
