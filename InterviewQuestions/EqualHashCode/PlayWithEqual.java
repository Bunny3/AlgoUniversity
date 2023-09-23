import java.util.*;
class Employee {
  int aadharId;
  String name;

  public Employee(int a,String na) {
    this.aadharId = a;
    this.name = na;
  }

  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime*result + aadharId;
    result = prime*result + ((name == null) ? 0 :name.hashCode());
    return result;
  }


  public boolean equals(Object obj) {
    if(this == obj)
    return true;
    if(obj == null) {
      return false;
    }
    if(this.getClass() != obj.getClass()) {
      return false;
    }

    Employee other = (Employee)obj;
    if(aadharId != other.aadharId) {
      return false;
    }
    if(this.name == null){
      if(other.name != null) {
        return false;
      } else if(!name.equals(other.name)) {
        return false;
      }
      return true;
    }
  }


}

public class PlayWithEqual {

  public static void main(String args[]) {
  Employee ee = new Employee(1, "Shubham");
  Employee cc = new Employee(2,"Rahul");

  System.out.println(ee.hashCode());
  }
}
