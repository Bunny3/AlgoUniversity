import java.util.*;
import java.io.*;
class TrieNode {
  TrieNode arr[];
  boolean isEnd;
  long cnt_sub;
  TrieNode() {
    arr = new TrieNode[26];
    cnt_sub =0;
    this.isEnd = false;
  }
  public void insert(StringBuilder s,int n) {
    TrieNode temp = this;
    for(int i=n-1;i>=0;i--) {
      char ch = s.charAt(i);
      if(temp.arr[ch-'a'] == null) {
        TrieNode p = new TrieNode();
        if(i == s.length()-1) {
          p.isEnd = true;
        }
        temp.arr[ch-'a']=p;
        temp = p;
        
      } else {
        temp = temp.arr[ch-'a'];
        if(i == s.length()-1) {
          temp.isEnd = true;
        }
      }
      temp = temp.arr[ch-'a'];
    }
    temp.cnt_sub++;
  }

  public long find(StringBuilder s,int n) {
    TrieNode temp = this;
    for(int i=0;i<s.length();i++) {
      char ch = s.charAt(i);
      if(temp.arr[ch-'a'] == null) {
        return 0;
      }
        temp = temp.arr[ch-'a'];
    }
    return temp.cnt_sub;
  }
  
}
public class CountPalindrome {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    TrieNode trie= new TrieNode();
    int count = 0;
    for(int i=0;i<N;i++) {
      StringBuilder s = new StringBuilder(p.readLine());
      StringBuilder t = new StringBuilder(s.toString());
      t.reverse();
      // System.out.println(s+"----");
      // System.out.println(t+"---");
      
      if(i>0) {
        count +=2*trie.find(s,s.length());
      }
      if(s.toString().equals(t.toString())) {
        count++;
        // System.out.println("Encounterd "+i);
      }
        
      trie.insert(s, s.length());
    }
    System.out.println(count);
  }
}
