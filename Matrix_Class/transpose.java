package Matrix_Class;

public class transpose {
  public static void main(String args[]) {
    int m,int n;
    Scanner p = new Scanner(System.in);

    m = p.nexInt();
    n = p.nextInt();
    int[][] matrix = new int[n][n];
    for(int i=0;i<n;i++) {
      for(int j=i+1;j<n;j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }
  
}
