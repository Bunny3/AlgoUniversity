import java.time.LocalDate;
import java.time.LocalDateTime;

class MultiThread implements Runnable{
  public void run() {
    try {
      LocalDateTime
    System.out.println("Thread " + Thread.currentThread().getId() + "is running");
    Thread.sleep(2000);
    System.out.println("Thread " + Thread.currentThread().getState() + "State");

    } catch(Exception e) {
      System.out.println("Exception is caught");
    }
  } 
};

public class MultiThreadDemo1 {
  public static void main(String args[]) {
    int n = 8;
    for(int i=0;i<n;i++) {
      // MultiThread obj = new MultiThread();
      Thread obj = new Thread(new MultiThread());
      obj.start();
    }
  }
}
