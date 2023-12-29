import java.io.*;
import java.util.*;
public class EvenOdd extends Thread{

  synchronized public void run() {
    for(int i=0;i<10;i++) {
      if(i%2==0)
        System.out.println(Thread.currentThread().getId()+" -> "+i);
    }
  }
  public static void main(String args[]) {
    
    for(int i=0;i<3;i++) {
      EvenOdd obj = new EvenOdd();
        
      obj.start();
    }
      
  }
}
