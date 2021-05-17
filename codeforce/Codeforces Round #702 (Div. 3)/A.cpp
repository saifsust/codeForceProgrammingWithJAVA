#include<bits/stdc++.h>
using namespace std;

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
        int num;
        cin >> num;
        double nums[num + 1];
        for(int i = 0; i< num; i++) cin >> nums[i];
        int counter = 0;
        for(int i = num -1; i> 0; i--){
            double mx = max(nums[i], nums[i - 1]);
            double mn = min(nums[i], nums[i - 1]);
            if(mx / mn <= 2.0) continue;
            while(mx / mn > 2.0){
                ++counter;
                if(mx / 2.0 > int(mx) / 2)  mx = floor(mx/ 2.0) + 1;
                else mx /= 2.0;
                mx = max(mx, mn);
                mn = min(mn, mx);
            }
        }
        cout << counter << endl;

    }
    



    return 0;
}
