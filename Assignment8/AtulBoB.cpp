#include<bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin>>n;
  vector<int> plates(n,0);
  vector<int> order(n,0);

  for(int i=0;i<n;i++) {
    cin>>plates[i];
  }


  for(int i=0;i<n;i++) {
    cin>>order[i];
  }
satck<int> st;
vector<int> ans;
  for(int i=0,j=0;i<n;i++) {
    if(plates[i] == order [j]) {
      ans.push(plates[i]);
      j++;
    } else {
      st.push(plates[i]);
    }
  }
  while(!st.empty()) {
    int k =st.top();
    st.pop();
    ans.push(k);
  }
  ///compare ans with order
  return 0;
}