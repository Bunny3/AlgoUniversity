package Matrix_Class;

public class SnakeMatrix {
  public static void main(String args[]) {
    int r = 3;
    for(int i=0;i<r;i++) {
      if(i%2 == 0 ) {
        printElement(i,reverseDirection);
      } else {
        printElement(i, -reverseDirection);
      }
    }
  }
  
}
