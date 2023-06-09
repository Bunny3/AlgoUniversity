import java.util.*;
public class SquareOfSortedArray {
  public static void main(String args[]) {
    int N;
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    int i=0,j=N-1;
    ArrayList<Integer> arrayList = new ArrayList<>();
    for(i=0;i<N;i++) {
      int temp = sc.nextInt();
      arrayList.add(temp);
    }
    i=0;
    j = N-1;
    ArrayList<Integer> arrayList2 = new ArrayList<>();
    while(i<=j) {
      if(Math.abs(arrayList.get(i)) > Math.abs(arrayList.get(j))) {
        arrayList2.add((int)Math.pow(arrayList.get(i),2));
        i++;
      } else {
        arrayList2.add((int)Math.pow(arrayList.get(j),2));
        j--;
      }
    }
    Collections.reverse(arrayList2);
    for(i=0;i<N;i++) {
      System.out.print(arrayList2.get(i) + " ");
    }
  }
}
