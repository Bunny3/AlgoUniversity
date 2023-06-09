package Matrix_Class;

public class MatrixSearch {
  public static void main(String args[]) {
    int m,n;
    int[][] matrix = new int[m][n];

    int  l = 0;
    int h = m*n-1;

    while(l<h) {
      int mid = (l+h)/2;
      int r = mid/m;
      int c = mid%m;
      if(matrix[r][c]  == target) {
        find = true;
        break;
      } else if(matrix[r][c]<target){
        l = mid+1;
      } else  if(matrix[r][c] > target) {
        h = mid-1;
      }

    }

    if(find == true)
    //true
    else 
    //false
  }
}
