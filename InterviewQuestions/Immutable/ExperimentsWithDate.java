import java.util.Date;
public class ExperimentsWithDate {
  private Date dob;
  public Date getDob() {
    return dob;
  }
  
  public ExperimentsWithDate(Date dob) {
    this.dob = dob;
  }

  public static void main(String args[]) throws InterruptedException{
    Date objdate = new Date();
    ExperimentsWithDate ce = new ExperimentsWithDate(objdate);
    System.out.println("This is after initialization of  object");
    System.out.println("Date before "+ce.getDob());
    Thread.sleep(1000);
    Date tempDate = new Date();
    System.out.println("Date change to " + tempDate);
    Date dd = ce.getDob();
    dd = new Date(tempDate.getTime());
    System.out.println("This is after local variable change");
    System.out.println("Date now "+ce.getDob());
  }
}
