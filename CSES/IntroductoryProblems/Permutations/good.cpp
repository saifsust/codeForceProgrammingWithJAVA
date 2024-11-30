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

    for(int i = 2; i<=n; i+=2){
        cout << i << " ";
    }

    for(int i = 1; i<=n; i+=2){
        cout << i;
        if(i < n -1){
            cout << " ";
        }
    }

    cout << endl;


  }
  return 0;
}
