// Sol 1

// #include <iostream>
// #include <vector>
// #include <algorithm>

// using namespace std;

// int main() {
//  int n;
//  cin >> n;
//  n *= 2;
//  vector<int> vec(n);
//  for (int &x : vec) cin >> x;

//  sort(vec.begin(), vec.end());

//  int ans = 1e9;

//  for (int i = 0; i < n; ++i) {
//   for (int j = i + 1; j < n; ++j) {
//    vector<int> tmp;
//    for (int k = 0; k < n; ++k) {
//     if (k != i and k != j) {
//      tmp.push_back(vec[k]);
//     }
//    }
//    int tmp_ans = 0;
//    for (int k = 1; k < tmp.size(); k += 2) {
//     tmp_ans += tmp[k] - tmp[k - 1];
//    }
//    ans = min(ans, tmp_ans);
//   }
//  }

//  cout << ans << endl;
//  return 0;
// }




// #include <bits/stdc++.h>
// using namespace std;

// int main ()
// {
//     ios_base::sync_with_stdio (false);
//     cin.tie (NULL);
    
//     int n;
//     cin >> n;
//     vector<int> vec(n);
//     for (int i = 0; i < n; ++i)
//         cin >> vec[i];
        
//     sort (vec.begin(), vec.end());
    
//     int ans = 0;
    
//     for (int start = 0; start < n; ++start) {
//         // Left
//         int left = 0;
//         {
//             int last=start;
//             int jump=1;
//             while (last >= 0 and last < n) {
//                 int next = last;
//                 while (next-1 >= 0 and abs(vec[next-1]-vec[last]) <= jump) {
//                     next -= 1;
//                 }
//                 // no change condition
//                 if (next == last)
//                    { break;}
//                 last = next;
//                 jump += 1;
//             }
        
//         left=abs(last-start);
// }
//         int right=0;
//         {
//             int last = start;
//             int jump = 1;
//             while (last >= 0 and last < n) {
//                 int next = last;
//             while (next+1<n and abs(vec[next + 1] - vec[last]) <= jump) {
//                 next += 1;
//             }
//             // no change condition
//             if (next == last)
//              { break;}
//             last = next;
//             jump += 1;
//             }
//             right = abs(last - start);
//         }
//         ans = max(ans, left + right + 1);
        
//     }
    
    
//     cout << ans << endl;
    
//     return 0;

// }
import java.util.*;
import java.io.*;
public class UnstopableSpaceShip {
    public static void main(String args[]) throws IOException {
      BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
      int x = Integer.parseInt(p.readLine());
      String nh[] = p.readLine().trim().split(" ");

      int height[] = new int[2*x];

      for(int i=0;i<2*x;i++) {
        height[i] = Integer.parseInt(nh[i]);
      }
      Arrays.sort(height);
      int N= 2*x;
      int diff = Integer.MAX_VALUE;

      for(int i=0;i<N;i++) {
        for(int j=i+1;j<N;j++) {
          int temp[] = new int[N-2];
          for(int k=0,c=0;k<N;k++) {
            if(k!=i && k!=j) {
              temp[c++] = height[k];
            }
          }
            int tDiff = 0;
            for(int t=1; t<temp.length;t+=2) {
                tDiff= tDiff + (temp[t]-temp[t-1]);
            }
            diff = (int)Math.min(tDiff,diff);
          }
        }
      System.out.println(diff);
    }
}
