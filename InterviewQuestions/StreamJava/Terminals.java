import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
public class Terminals {
  public static void main(String args[]) {
    List<String> vechileList = Arrays.asList("bus","car","bicycle","bus","car","car","bike");
    //distinct
    List<String> distinctVehicles = vechileList.stream().distinct().collect(Collectors.toList());
    System.out.println(distinctVehicles);
     vechileList.stream().distinct().forEach(value->System.out.println(value));
    //count
    long countOfDisticList = vechileList.stream().distinct().count();
    System.out.println(countOfDisticList);
    //limit
    System.out.println(vechileList.stream().limit(3).collect(Collectors.toList()));
  }
}
