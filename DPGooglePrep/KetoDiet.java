import java.util.*;
import java.io.*;
public class KetoDiet {
  public static int solve(int i, int pr, int protein[],int fa,int fat[],int carbohydrate[],int P,int F) {
    if(i == protein.length){
      if((pr<P) || (fa<F)){
        return 0 ;
      } else {
        return 0;
      }
    }
    //notinclude
    int notinclude = solve(i+1, pr, protein, fa, fat, carbohydrate, P, F);
    int include = Integer.MAX_VALUE;
    include = solve(i+1, pr+protein[i], protein, fa+fat[i], fat, carbohydrate, P, F)+carbohydrate[i];
    System.out.println(Math.min(include,notinclude));
    return Math.min(include,notinclude);
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int PF[]= Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int P = PF[0];
    int F = PF[1];
    int n = Integer.parseInt(input.readLine());
    int protein[] = new int[n];
    int fat[] = new int[n];
    int carbohydrate[] = new int[n];
    for(int i=0;i<n;i++) {
      int temp[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      protein[i] = temp[0];
      fat[i] = temp[1];
      carbohydrate[i] = temp[2];
    }

    int ans = solve(0,0,protein,0,fat,carbohydrate,P,F);
    System.out.println(ans);
  }
}
