import java.io.File;
import java.io.IOException;
public class FileOperations1 {
  public static void main(String args[]) {
    try {
      File fobj = new File("FileOperations.txt");
      if(fobj.createNewFile()) {
        System.out.println("Succsessfule file creation");
      } else {
        System.out.println("File already present");
      } 
    } catch (IOException e) {
      System.out.println("Erroe");
    }
  }
}
