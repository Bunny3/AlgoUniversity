
import java.util.function.Consumer;
import java.util.function.Predicate;
//Predicate Interface

class Employee {
  String ename;
  int salary;
  int experience;

  Employee(String name, int sal, int exp) { 
    ename = name;
    salary = sal;
    experience = exp;
  }
}
public class Test3{
  
  public static void main(String args[]) {
    //Example1
    Predicate<Integer> p1 = i->(i>10);
    System.out.println(p1.test(2));
    //Example2: check the length of given string is greater than 4 or not
    Predicate<String> p2 = i -> i.length()>4;
    System.out.println(p2.test("HelloWorld"));
    //Example 3: Print array element whose length is greate than 4 
    String names[] = {"David","Scott","Smith","John","Mary"};
    for(String name: names) {
      if(p2.test(name))
        System.out.println(name);
    }

    Employee emp = new Employee("Shubham", 50000, 10);
    Predicate<Employee> p3 = e-> (e.salary>30000 && e.experience>3);
    System.out.println(p3.test(emp));

    //Example 4: Join Multiple predicate function: and , or , negate
    // p4 = check number is even
    // p5 = check number is greater then 50
    int[] arr= {5,15,20,25,30,35,40,45,50,55,60,65};

    Predicate<Integer> p4 = i -> (i%2 == 0);
    Predicate<Integer> p5 = i -> (i>50);

    for(int a:arr) {
      if(p4.negate().test(a)) {
        System.out.println(a);
      }
    }
  }
}

