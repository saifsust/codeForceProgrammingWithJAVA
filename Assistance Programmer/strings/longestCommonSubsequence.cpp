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
// recursion approach to find longest common subsequence. 
int64_t longestCommonSubsequence(string A, string B, size_t a, size_t b){
    if( a == 0 || b == 0) return  0;
    if(dp[a][b] != 0) return dp[a][b];
    if(A[a-1] == B[b-1]) return dp[a][b] = longestCommonSubsequence(A,B, a-1, b-1) + 1;
    return dp[a][b] = max(longestCommonSubsequence(A, B, a -1, b), longestCommonSubsequence(A, B, a, b-1));
}

// recursion and dynamic approach for longest common subsequence
    int64_t LCS(string str, string str2, int first , int second, vector<vector<int>> &dp){
        if(first >= str.size() || second >= str2.size()) return 0;
        if(dp[first][second] != -1) return dp[first][second];
        if(str[first]== str2[second]){
            if(dp[first][second] != -1) return dp[first][second];
            else return dp[first][second] = 1 + LCS(str, str2, first + 1, second + 1, dp);
        } 
        return  dp[first][second] = max(LCS(str, str2, first, second +1 , dp), LCS(str, str2, first + 1, second, dp));
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
