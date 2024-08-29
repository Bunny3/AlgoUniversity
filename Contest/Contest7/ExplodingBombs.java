import java.io.*;
import java.util.*;
public class ExplodingBombs {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int NMK[] = Arrays.stream(p.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int N = NMK[0];
    int M  = NMK[1];
    int K = NMK[2];

    int bombArray[][] = new int[K][3];
    for(int i=0;i<K;i++) {
      bombArray[i] = Arrays.stream(p.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();;
    }

    //make overlapping array
    int board[][] = new int[N][M];
    for(int i=0;i<N;i++){
      Arrays.fill(board[i],0);
    }

    for(int i=0;i<K;i++) {
      int top = bombArray[i][0]-bombArray[i][2];
      int bottom = bombArray[i][0] + bombArray[i][2];
      int left = bombArray[i][1]-bombArray[i][2];
      int right = bombArray[i][1]+bombArray[i][2];

      if(top<0) {
        top = 1;
      }
      if(bottom > N)
      {
        bottom = N;
      }

      if(left<0) {
        left = 1;
      }

      if(right>M) {
        right = M;
      }

      for(int j=top;j<=bottom;j++) {
        board[j-1][(left-1)] +=1;
        board[j-1][Math.min((right-1)+1,M)] -=1;
      }

      // System.out.println("top : "+ top+ " bottom: "+bottom+" left: "+left+" right: "+right);
    }

    // for(int i=0;i<N;i++) {
    //   for(int j=0;j<M;j++) {
    //     System.out.print(board[i][j]+" ");
    //   }
    //   System.out.println();
    // }

// prefix array
    for(int i=0;i<N;i++) {
      for(int j=1;j<M;j++) {
        board[i][j]+=board[i][j-1];
      }
    }
  // System.out.println();
  int count =0;
    for(int i=0;i<N;i++) {
      for(int j=0;j<M;j++) {
        if(board[i][j] == 0) 
          count++;
      }
    }
  
    System.out.println(count);
    for(int i=0;i<N;i++) {
      for(int j=0;j<M;j++) {
        if(board[i][j] == 0) 
          System.out.println((i+1)+" "+(j+1));
      }
    }
  }
}