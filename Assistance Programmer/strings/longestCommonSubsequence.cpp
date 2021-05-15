#include<bits/stdc++.h>
using namespace std;
const int64_t  N = 1000;
int64_t dp[N][N];
int64_t longestCommonSubsequence(string A, string B){
      memset(dp, 0, sizeof(dp));
      for(size_t i = 1; i<=A.size(); i++){
          for(size_t j = 1; j<=B.size(); j++){
              if(A[i - 1] == B[j - 1]) dp[i][j] = dp[i-1][j-1] + 1;
              else dp[i][j] = max(dp[i][j - 1], dp[i-1][j]);
          }
      }
      return dp[A.size()][B.size()];
}


int main(){
   // freopen("in.in", "r", stdin);
    //freopen("out.in", "w", stdout);
    string A, B;
    while( cin >> A >> B){
        cout << longestCommonSubsequence(A, B) << endl;
    }    
    return 0;
}
