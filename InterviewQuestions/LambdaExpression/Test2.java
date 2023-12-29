/**
 *  Cab
 */
interface  Cab {
 public void bookCab(String src, String des);
}
//Replace with Lambda Expression
// class Ola implements Cab {
//   public void bookCab(String src, String des ) {
//     System.out.println("Ola is booked from "+src+" to "+des);
//   }
// }

public class Test2 {
  public static void main(String args[]) {
    Cab cab = ( src, des)->System.out.println("Ola is booked from "+src+" to "+des);;
    cab.bookCab("BLR", "Mumbai");
  }
}
