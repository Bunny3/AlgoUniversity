import java.util.*;
import java.io.*;

class Trie {
  // static int MaxN = 10001;
  static int ALPH = 26;
  HashMap<Integer,int[]> trie;
  int nc;
  HashMap<Integer,Integer> hotNode1;
  public Trie() {
    trie = new HashMap<Integer,int[]>();
    int temp[] = new int[ALPH];
    Arrays.fill(temp,-1);
    trie.put(0,temp);
    hotNode1 = new HashMap<Integer,Integer>();
    hotNode1.put(0,0);
    nc = 0;
  }
  void insert(String S) {
    int curr = 0;
    for(int i=0;i<S.length();i++) {
      int num = S.charAt(i)-'a';
      if(trie.get(curr)[num]==-1) {
        trie.get(curr)[num] = ++nc;
        int temp[] = new int[ALPH];
        Arrays.fill(temp,-1);
        trie.put(nc,temp);
      }
      curr = trie.get(curr)[num];
    }
    // hotNode.set(curr,hotNode.get(curr)+1);
    if(hotNode1.containsKey(curr)) {
      hotNode1.put(curr,hotNode1.get(curr)+1);
    } else {
    hotNode1.put(curr,1);
    }
  }
  int exactSearch(String s) {
    int curr =0;
    for(int i=0;i<s.length();i++) {
      int num = s.charAt(i)-'a';
      if(trie.get(curr)[num] == -1) {
        return 0;
      }
      curr = trie.get(curr)[num];
    }
    // if(hotNode1.get(curr)>0) return 1;
    if(hotNode1.containsKey(curr))
      return 1;
    return 0;
  }
  int prefixSearch(String s) {
    int curr =0;
    for(int i=0;i<s.length();i++) {
      int num = s.charAt(i)-'a';
      if(trie.get(curr)[num] == -1) {
        return 0;
      }
      curr = trie.get(curr)[num];
    }
    return 1;
  }
}
public class SearchString {
  public static void main(String args[]) throws IOException {
    BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(inp.readLine());
    Trie trie = new Trie();
    for(int i=0;i<N;i++) {
      String query[] = inp.readLine().trim().split(" ");
      switch(Integer.parseInt(query[0])) {
        case 1: trie.insert(query[1]);
              break;
        case 2:System.out.println(trie.exactSearch(query[1]));
              break;
        case 3: System.out.println(trie.prefixSearch(query[1]));
              break;
        // default:System.exit(0);/
      }
    }
  }
}
