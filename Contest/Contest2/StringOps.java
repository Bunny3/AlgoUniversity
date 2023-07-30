import java.util.*;
import java.io.*;

public class StringOps {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String str = p.readLine().trim();

    int Q = Integer.parseInt(p.readLine());
    String QueriesString[] = p.readLine().trim().split(" ");
    int Queries[] = new int[Q];
    for(int i=0;i<Q;i++) {
      Queries[i] = Integer.parseInt(QueriesString[i])-1;
    }
    int N = str.length();
    int prefix[] = new int[str.length()+1];
    for(int i=0;i<Queries.length;i++) {
      prefix[Queries[i]] = 1;
      prefix[N-Queries[i]] = -1;
    }

    for(int i=1;i<prefix.length;i++) {
      prefix[i] = prefix[i] + prefix[i-1];
    }
    char strArr[] = str.toCharArray();
    String ans = "";
    for(int i=0;i<N/2;i++) {
      if(prefix[i]%2==0) {
        continue;
      }
      else {
        char temp = strArr[i];
        strArr[i] = strArr[N-i-1];
        strArr[N-i-1] = temp;
      }
    }

    String sd = new String();
    ans = sd.valueOf(strArr);
    System.out.println(ans);
  }
}
