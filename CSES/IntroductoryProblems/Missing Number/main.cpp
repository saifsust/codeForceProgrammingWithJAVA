#include<bits/stdc++.h>
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  while(cin >> n){
    int nums[n+1];
    memset(nums, 0, sizeof(nums));
    int a;
    for(int i = 0; i<n -1; i++){
        cin >> a;
        ++nums[a];
    }

    for(int i = 1; i<= n; i++){
        if(nums[i] == 0){
            cout << i << endl;
            break;
        }
    }

  }
  return 0;
}
