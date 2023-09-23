
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public final class FinalClassExample {

  private final int id;
  private final String name;
  private final HashMap<String, String> testmap;
  private final Date dob;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public HashMap<String,String> getTestmap() {
    // return (HashMap<String, String>) testmap.clone();
    return testmap;
  }
  public Date getDob() {
    return dob;
  }
  
  public FinalClassExample(int id,String name, HashMap<String,String> testMap,Date dob) {

    this.id = id;
    this.name = name;
    this.testmap = testMap;
    // this.dob = new Date(dob.getTime());
    this.dob = dob;
    // HashMap<String,String> tempMap = new HashMap<>();
    // String key;
    // Iterator<String> it = testMap.keySet().iterator();

    // while(it.hasNext()) {
    //   key = it.next();
    //   tempMap.put(key,testMap.get(key));
    // }
    // this.testmap = tempMap;
  }

  public static void main(String args[]) throws InterruptedException{
    HashMap<String, String> h1 = new HashMap<>();
    h1.put("1", "first");
    h1.put("2","second");

    int i = 1;
    String name = "Shubham";

    Date d = new Date();
    FinalClassExample ce = new FinalClassExample(i, name, h1, d);
    System.out.println("This is after initailization");
    System.out.println("id"+ce.getId());
    System.out.println("name"+ce.getName());
    System.out.println("map"+ce.getTestmap());
    System.out.println("Date"+ce.getDob());
    i = 2;
    name = "Rahul";
    h1.put("3", "third");
    Thread.sleep(1000);
    Date d2 = new Date();
    System.out.println("Date->>" + d2);
    // Date dd = ce.getDob();
    ce.dob = d2;
    System.out.println("This is after local variable change");
    System.out.println("id"+ce.getId());
    System.out.println("name"+ce.getName());
    System.out.println("map"+ce.getTestmap());
    System.out.println("Date"+ce.getDob());
    HashMap<String, String> hmTest = ce.getTestmap();
    hmTest.put("4", "Fourth");

    System.out.println("After get method map value"+ce.getTestmap());
  }
}
