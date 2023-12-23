#include<bits/stdc++.h>
using namespace std;

int main(){
        ios::sync_with_stdio(false);
        cin.tie(NULL);
        const int L = 1;
        const int U = 500;
        int T;
        scanf("%d", &T);
        for(int t = 1; t<= T; t++){
           int n ;
           scanf("%d", &n);
           assert(L <= n && n <= U);
           char str[n];
           scanf("%s", str);
           vector<long long> counter(27, 0);

           for(int i = 0; i<n; i++){
              ++counter[str[i] - 'A' + 1];
           }

           int ans = 0;

           for(unsigned i = 1; i< counter.size(); i++){
                 if(counter[i] >= i) ++ans;
           }

           printf("%d\n", ans);


        }
        return 0;
}
~  
