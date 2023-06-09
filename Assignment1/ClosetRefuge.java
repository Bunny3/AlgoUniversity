import java.util.*;
public class ClosetRefuge {
  public static void main(String[] args) {
    int n;
    Scanner p = new Scanner(System.in);
    n = p.nextInt();
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    int arr[] = new int[n];
     for(int i=0;i<n;i++) {
      int temp = p.nextInt();
      arr[i] = temp;
      if(map.containsKey(temp)) {
        map.put(temp,map.get(temp)+1);
      } else {
        map.put(temp,1);
      }
    }
    int i=1;
    boolean flag = false;
    while(i<=n) {
      if(map.containsKey(i) == false) {
        flag = true;
        break;
      }
      i++;
    }
    
    if(flag == true) {
      System.out.println(i);
    } else {
      System.out.println(n+1);
    }

  }
}