#include<bits/stdc++.h>
using namespace std;
 
vector<int> solve(int n, int k){
        vector<int> ans;
        if(!k){
                for(int i = n; i>= 1; i--) ans.push_back(i);
                return ans;
        }
 
        for(int i = 1; i<k + 1;  i++) ans.push_back(i);
 
        for(int i = n; i>=k + 1; i--) ans.push_back(i);
 
        return ans;
}
 
int main(){
        ios::sync_with_stdio(false);
        cin.tie(NULL);
        const int LN = 2;
        const int LU = 50;
        const int LK = 0;
        int T;
        scanf("%d", &T);
 
        for(int t = 1; t<= T; t++){
                int n, k;
                scanf("%d%d", &n, &k);
                assert(LN <= n && LN <= LU);
                assert(LK <= k <= n - 1);
 
                vector<int> ans  = solve(n,k);
                for(int i = 0; i<ans.size(); i++){
                        printf("%d", ans[i]);
                        if(i < ans.size() - 1){
                                printf(" ");
                        }
                }
                printf("\n");
        }
        return 0;
}
