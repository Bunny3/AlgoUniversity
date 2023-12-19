import java.io.*;
import java.util.*;
public class UnfairMultiverse {
  public static int[] Maximum(int arr[]) {
    int left[] = new int[arr.length];
    int right[] = new int[arr.length];
    left[0]=-1;
    right[arr.length-1] = arr.length;
    Stack<Integer> leftStack = new Stack<Integer>();
    Stack<Integer> rightStack = new Stack<Integer>();
    leftStack.add(0);
    for(int i=1;i<arr.length;i++) {
      while(!leftStack.isEmpty() && arr[leftStack.peek()]<arr[i])
      {
        leftStack.pop();
      }
      if(leftStack.isEmpty()) {
        left[i] = -1;
      }
      else {
        left[i] = leftStack.peek();
      }
      leftStack.add(i);
    }
    rightStack.add(arr.length-1);
    for(int i=arr.length-2;i>=0;i--) {
      while(!rightStack.isEmpty() && arr[rightStack.peek()]<=arr[i])
      {
        rightStack.pop();
      }
      if(rightStack.isEmpty()) {
        right[i] = arr.length;
      } else {
        right[i] = rightStack.peek();
      }
      rightStack.add(i);
    }
    int ans[]= new int[arr.length];
    for(int i=0;i<arr.length;i++) {
      ans[i] = (i-left[i])*(right[i]-i);
    }
    //     for(int i=0;i<arr.length;i++) {
    //  System.out.print(left[i]+" ");
    // }
    // System.out.println();
    //     for(int i=0;i<arr.length;i++) {
    //  System.out.print(right[i]+" ");
    // }
    // System.out.println();
    // for(int i=0;i<arr.length;i++) {
    //  System.out.print(ans[i]+" ");
    // }
    // System.out.println();
    return ans;
  }

  public static int[] Minimum(int arr[]) {
    int left[] = new int[arr.length];
    int right[] = new int[arr.length];
    left[0]=-1;
    right[arr.length-1] = arr.length;
    Stack<Integer> leftStack = new Stack<Integer>();
    Stack<Integer> rightStack = new Stack<Integer>();
    leftStack.add(0);
    for(int i=1;i<arr.length;i++) {
      while(!leftStack.isEmpty() && arr[leftStack.peek()]>arr[i])
      {
        leftStack.pop();
      }
      if(leftStack.isEmpty()) {
        left[i] = -1;
      }
      else {
        left[i] = leftStack.peek();
      }
      leftStack.add(i);
    }
    rightStack.add(arr.length-1);
    for(int i=arr.length-2;i>=0;i--) {
      while(!rightStack.isEmpty() && arr[rightStack.peek()]>=arr[i])
      {
        rightStack.pop();
      }
      if(rightStack.isEmpty()) {
        right[i] = arr.length;
      } else {
        right[i] = rightStack.peek();
      }
      rightStack.add(i);
    }
    int ans[]= new int[arr.length];
    for(int i=0;i<arr.length;i++) {
      ans[i] = (i-left[i])*(right[i]-i);
    }
    //     for(int i=0;i<arr.length;i++) {
    //  System.out.print(left[i]+" ");
    // }
    // System.out.println();
    //     for(int i=0;i<arr.length;i++) {
    //  System.out.print(right[i]+" ");
    // }
    // System.out.println();
    // for(int i=0;i<arr.length;i++) {
    //  System.out.print(ans[i]+" ");
    // }
    // System.out.println();
    return ans;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(input.readLine());
    int arr[] = Arrays.stream(input.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();

    //preprocess for Number of subarray with a[i] as minimum
    //preprocess for Number of subarray with a[i] as maximum
    int miniArray[] = Minimum(arr);
    int maxiArray[] =Maximum(arr);
    int unfairness = 0;
    for(int i=0;i<N;i++) {
      unfairness+=arr[i]*(maxiArray[i]-miniArray[i]);
    }
    System.out.println(unfairness);
  }
}
