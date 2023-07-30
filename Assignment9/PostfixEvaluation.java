import java.util.*;
import java.io.*;

public class PostfixEvaluation {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String str = p.readLine();
    int ans = 0;
    Stack<Integer> st = new Stack<Integer>();
    for(int i=0;i<str.length();i++) {
      if(str.charAt(i)>='0' && str.charAt(i)<='9') {
        st.push(Integer.parseInt(str.charAt(i)+""));
      } else {
        int operand2,operand1;
        switch(str.charAt(i)) {
          case '+': operand2 = st.peek();
                    st.pop();
                    operand1 = st.peek(); 
                    st.pop();
                    ans = operand1 + operand2;
                    st.push(ans);
                    break;
          case '-': operand2 = st.peek();
                    st.pop();
                    operand1 = st.peek(); 
                    st.pop();
                    ans = operand1 - operand2;
                    st.push(ans);
                    break;
          case '*': operand2 = st.peek();
                    st.pop();
                    operand1 = st.peek(); 
                    st.pop();
                    ans = operand1 * operand2;
                    st.push(ans);
                    break;
          case '/': operand2 = st.peek();
                    st.pop();
                    operand1 = st.peek(); 
                    st.pop();
                    ans = operand1 / operand2;
                    st.push(ans);
                    break;
        }
      }
    }
    System.out.println(st.peek());
  }
}
