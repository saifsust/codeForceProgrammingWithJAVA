#include<bits/stdc++.h>
using namespace std;
void solve();
int main(){
    #ifndef ONLINE_JUDGE
     // freopen("in.in", "r", stdin);
      //freopen("out.in", "w", stdout);
    #endif
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
   
    int t;
    cin >> t;
    while(t--){
        solve();
    }
    return 0;
}

const int N = 1000;
int position[N];

// one player can take only 2^k coins only and who can not take coin will loose the game
int isFirstWin(int n){
    if(n == 3 || n == 5 || n == 7) return position[n] = 0;
    if(n == 1 || n == 2) return position[n] = 1;
    if(position[n] != -1) return position[n];
    for(int i = 2; i<= n ; i*= 2){
        if(position[n-i] != -1) return position[n -1];
        if(!isFirstWin(n - i)) return position[n-i] = 1;
    }
    return position[n] = 0; 
}


void solve(){
 
  // one player can take 1, 2, 4 coin at a time
  // who take the last coin , she/he will win the game

  int n;
  cin >> n;
  memset(position, -1, sizeof(position));
  if(isFirstWin(n)){
      cout << "First Win" << endl;
  }else cout << "Second Win" << endl;


}
