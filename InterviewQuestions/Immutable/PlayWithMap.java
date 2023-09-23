

import java.util.HashMap;
import java.util.Map;
class Employee{

   int age;
   String empId;
   String name;
   
  public Employee(String empId,String name,int age){
    this.empId = empId;
    this.name = name;
    this.age = age;
  }

// final getter setter 


}
public class PlayWithMap {
  public static void main(String args[]) {
    Map<Employee,Employee> employeeMap = new HashMap<>();

    Employee emp1 = new Employee("E001","E001 name",32);
    Employee emp2 = new Employee("E002","E001 name",32);

    employeeMap.put(emp1,emp1);
    employeeMap.put(emp2,emp2);
    System.out.println(emp1.hashCode()+"--------"+emp2.hashCode());
    System.out.println(emp1.equals(emp2));
    System.out.println(employeeMap.get(new Employee("E001","E001 name",32)));
  }
}
