import java.util.*;
import java.util.stream.Collectors;
public class SortDemo {
  public static void main(String args[]) {
    //sorted
    List<Integer> list1 = Arrays.asList(2,4,5,15,6,1,0);
    List<Integer> sortedList1 = list1.stream().sorted().collect(Collectors.toList());//assending Order
    List<Integer> sortedDesList1 = list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());//assending Order
    System.out.println(sortedList1);
    System.out.println(sortedDesList1);
    //anyMathch
    Set<String> fruits = new HashSet<>();
    fruits.add(("one apple"));
    fruits.add(("one mango"));
    fruits.add(("two apple"));
    fruits.add(("more grapes"));
    fruits.add(("two guavas"));
    boolean result = fruits.stream().anyMatch(value->{return value.startsWith("one");});
    System.out.println(result);
    //allMatch
    result = fruits.stream().allMatch(value->{return value.startsWith("one");});
    System.out.println(result);
    //noneMatch
    result = fruits.stream().noneMatch(value->{return value.startsWith("fff");});
    System.out.println(result);

    //findAny
    List<String> stringList = Arrays.asList("two","one","three","one");
    Optional<String> ele = stringList.stream().findAny();
    System.out.println(ele.get());
  }
}
