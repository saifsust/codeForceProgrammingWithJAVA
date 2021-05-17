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
        int64_t x ;
        cin  >> x;
        int64_t root = int(cbrt(x));
        int64_t a=0, b= 0;
        //cout << pow(2, 3) << endl;
       for(int64_t i = 1; i<= root; i++){
           a = i;
           int64_t low = 1, high = root;
           while(low <= high){
               int64_t mid = (low + high) >> 1;
               //cout << pow(mid, 3) << " " << pow(a, 3) << endl;
               if( pow(mid , 3) + pow(a, 3) == x){
                   b = mid;
                   break;
               }else if( pow(mid, 3) + pow(a, 3) < x) low = mid + 1;
               else high = mid - 1;

           }
           //cout << b << endl;
           if(b) break;
       }
       if( a && b) cout << "YES"<<endl;
       else cout << "NO" << endl;       

    }
    return 0;
}
