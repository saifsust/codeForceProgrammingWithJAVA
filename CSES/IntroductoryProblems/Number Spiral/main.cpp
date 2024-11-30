#include<bits/stdc++.h>
using namespace std;

long long calc(long long x, long long y){
    if( x >= y){
        if(x & 1){
            return (x - 1) * (x - 1) + y;
        }else{
            return (x * x) - (y - 1);
        }
    }

    if( y % 2 == 0){
        return (y -1) * (y -1) + x;
    }

    return (y * y) - (x  - 1);
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);
  int T;
  cin >> T;
  for(int t = 1; t<=T; t++){
    long long x, y;
    cin >> x >> y;

    cout << calc(x, y) << endl;

  }
  return 0;
}
