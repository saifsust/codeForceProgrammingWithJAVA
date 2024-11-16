#include<bits/stdc++.h>
using namespace std;

int main(){
   int n;
   cin >> n;
   vector<int> skewers(2 * n);
   for(int i = 0; i< 2 * n; i++){
     cin >> skewers[i];
    }

    sort(skewers.begin(), skewers.end(), [&](const int a, const int b){
        return a > b;
    });

    int ans = 0;
    for(int i = 0, j = 1; i< 2 * n; i+=2, j+=2){
        ans += min(skewers[i], skewers[j]);
    }

    cout << ans << endl;

  return 0;
}
