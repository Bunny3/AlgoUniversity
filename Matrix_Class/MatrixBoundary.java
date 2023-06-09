package Matrix_Class;

public class MatrixBoundary {

  public static void main(String args[]) {
    int n;
    for(i=0;i<n;i++) {
       for(int j=0;j<n;j++) {
        int temp = sc.nextInt();
        arr[i][j] = temp;
       }
    }

    for(i=0;i<n;i++) {
      for(int j=0;j<n;j++) {
        if(i==0||j==0 || i==(n-1) || j==(n-1))
          System.out.println(arr[i][j]);
      }
   }
  }
  
}
