import java.io.*;
public class FileOperation2 {
  public static void main(String args[]) {
    File fobj = new File("FileOperations.txt");
    if(fobj.exists()) {
      System.out.println("File name : "+fobj.getName());
      System.out.println("Absolute path : "+fobj.getAbsolutePath());
      System.out.println("Can Write : "+ fobj.canWrite());
      System.out.println("Can Read : "+ fobj.canRead());
      System.out.println("The size of the file in bytes is: " + fobj.length());
    } else {
      System.out.println("File not exits");
    }
  }
  
}
