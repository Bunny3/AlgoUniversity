import java.util.*;
import java.util.stream.Collectors;

public class FilterDemo1 {
  public static void main(String[] args) {
    List<Integer> numberList = Arrays.asList(10,2,19,43,53);
    List<Integer> evenList = new ArrayList<>();
    evenList = numberList.stream().filter(n->n%2==0).collect(Collectors.toList());
    System.out.println(evenList);
    numberList.stream().filter(n->n%2==0).forEach(n->System.out.println(n));
    numberList.stream().filter(n->n%2==0).forEach(System.out::println);
  }
}
