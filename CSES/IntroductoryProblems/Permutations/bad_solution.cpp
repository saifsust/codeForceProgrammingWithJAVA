#include<bits/stdc++.h>
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  while(cin >> n){

    if( 2<= n && n <= 3){
        cout << "NO SOLUTION"<<endl;
        continue;
    }

    if( n == 4){
        cout << "2 4 1 3" << endl;
        continue;
    }

    for(int i = n, j=n/2; j >=1 ;i--, j--){
        cout << i << " " << j << " ";
    }

    if(n & 1){
      cout << n/2 + 1;

    }

    cout << endl;


  }
  return 0;
}
