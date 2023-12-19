import java.util.*;
import java.io.*;
class TrieNode {
  boolean isEnd;
  TrieNode arr[];
  public TrieNode() {
    this.isEnd = false;
    arr = new TrieNode[26];
  }

  public void insert(String s) {
    TrieNode temp = this;
    for(int i=0;i<s.length();i++) {
      char ch = s.charAt(i);
      if(temp.arr[ch-'a'] == null) {
        TrieNode p = new TrieNode();
        if(i == s.length()-1) {
          p.isEnd = true;
        }
        temp.arr[ch-'a']=p;
        temp = p;
      }  else {
        temp = temp.arr[ch-'a'];
        if(i == s.length()-1) {
          temp.isEnd = true;
        }
      }
    } 
    
  }

  public int find(String s,int indx,ArrayList<String> ansString) {
    TrieNode temp = this;
    
    String ans="";
    for(int i=indx;i<s.length();i++) {
      char ch = s.charAt(i);
      if(temp.arr[ch-'a'] == null) {
        return -1;
      }
      ans = ans + ch;
      if(temp.arr[ch-'a'].isEnd == true ) {
        ansString.add(ans);
        ans="";
        return i;
      }
      temp = temp.arr[ch-'a'];
    }
    return s.length();
  }
}
public class DictionaryWord {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    TrieNode trie = new TrieNode();
    for(int i=0;i<N;i++) {
      String s = p.readLine();
      trie.insert(s);
    }

    String fString = p.readLine();
    boolean flag = true;
    ArrayList<String> ansString = new ArrayList<>();
    for(int i=0;i<fString.length();) {
      i = trie.find(fString, i,ansString)+1;
      // System.out.println(i);
      if(i == -1) {
        flag = false;
        break;
      }
    }
    System.out.println(flag==false?"no":"yes");
    if(flag == true){
      for(String str: ansString) {
        System.out.print(str +" ");
      }
    }
  }
}
