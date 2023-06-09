  import java.util.*;
  public class P8TreasureRoom {
    public static void main(String[] args) {
      HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
      int n,target;
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      target = sc.nextInt();
      boolean flag = true;
      for(int i=0;i<n;i++) {
        int temp = sc.nextInt();
        int compliment = target - temp;
        if(map.containsKey(compliment)) {
              flag = false;
              System.out.println((map.get(compliment)+1)+" "+(i+1));
              break;
        }
        map.put(temp,i);
      }
      if(flag == true)
      {
        System.out.println("-1");
      }
    }
  }
