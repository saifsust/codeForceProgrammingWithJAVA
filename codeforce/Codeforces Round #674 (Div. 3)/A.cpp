#include<bits/stdc++.h>
using namespace std;
void solve();
int main(){
    #ifndef ONLINE_JUDGE
      freopen("in.in", "r", stdin);
      freopen("out.in", "w", stdout);
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

void solve(){
    int n, x;
    cin >> n >> x;
    int ans = 0, counter = 3, first = 1 , last = 2;
    while(true){
        if(first <=  n && n <= last) break;
        first = ans * x + 3 ;
        last = (ans + 1) * x + 2;
        ++ans;
    }
    cout << ans + 1 << endl;
}
