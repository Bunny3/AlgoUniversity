/**
 * Cab
 */
@FunctionalInterface
interface Cab {
  public void bookCab();
}
// We will try to use Labmda expression
// class Ola implements Cab {
//   public void bookCab() {
//     System.out.println("Ola cab is booked...");
//   }
// }
public class Test {
  public static void main(String args[]) {
    Cab cab = () -> System.out.println("Ola cab is booked...");
    cab.bookCab();
  }
}
