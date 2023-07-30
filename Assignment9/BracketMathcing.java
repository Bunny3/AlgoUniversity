import java.util.*;
import java.io.*;

public class BracketMathcing {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String inp = p.readLine();
    int arr[] = new int[inp.length()];
    Stack<Integer> st = new Stack<Integer>();
    for(int i=0;i<inp.length();i++) {
      if(inp.charAt(i) == '(') {
        st.push(i);
      } else if(inp.charAt(i) == ')'){
        if(!st.isEmpty()) {
          arr[i] = st.peek();
          arr[st.peek()] = i;
          st.pop();
        } else {
          arr[i] = -1;
          // break
        }
      }
    }
    while(!st.isEmpty()) {
      arr[st.peek()] = -1;
      st.pop(); 
    }
    for(int i=0;i<arr.length;i++) {
      System.out.print(arr[i]+" ");
    }
  }
} 
