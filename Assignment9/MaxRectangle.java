import java.io.*;
import java.util.*;
public class MaxRectangle {
  public static void main(String args[]) throws IOException {
    int N;
  
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(p.readLine());
    String inpArr[] = p.readLine().trim().split(" ");

    int arrH[] = new int[N];
    for(int i=0;i<N;i++) {
      arrH[i] = Integer.parseInt(inpArr[i]);
    }

    // Stack<Pair> st = new Stack<>();
    Stack<Integer> st = new Stack<>();
    // Pair pp = new Pair(arrH[0],-1);
    // st.push(pp);
    int Left[] = new int[N];
    int Right[] = new int[N];
    Left[0] = -1;
    st.push(0);
    for(int i=1;i<N;i++) {
      while(!st.empty() && arrH[st.peek()]>=arrH[i]) {
        st.pop();
      }
      if(st.empty()) {
        Left[i] = -1;
      } else {
        Left[i] = st.peek();
      }
      st.push(i);
    }

    Right[N-1] = N;
    st.clear();
    st.push(N-1);
    for(int i=N-2;i>=0;i--) {
      while(!st.empty() && arrH[st.peek()]>=arrH[i]) {
        st.pop();
      }
      if(st.empty()) {
        Right[i] = N;
      } else {
        Right[i] = st.peek();
      }
      st.push(i);
    }

    int max_ar=arrH[0];

    for(int i=0;i<N;i++) {
      max_ar = (int)Math.max(max_ar, (Right[i]-Left[i]-1)*arrH[i]);
    }

    System.out.println(max_ar);
  }
}
