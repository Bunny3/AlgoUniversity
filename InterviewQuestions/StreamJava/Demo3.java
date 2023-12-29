import java.util.*;
public class Demo3 {
  public static void main(String args[]) {
    List<String> stringList = Arrays.asList("A","B","C","1","2","3");
    //reduce
    Optional<String> reduced = stringList.stream().reduce((value,combinedValue)->{
      return value+combinedValue;
    });
    System.out.println(reduced.get());
    //toArray
    Object arr[] = stringList.stream().toArray();
    System.out.println(arr);
  }
}
