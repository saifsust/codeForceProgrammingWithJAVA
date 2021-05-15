#include<bits/stdc++.h>
using namespace std;
const int64_t  N = 1000;
int64_t dp[N][N];
int64_t longestPalindromeSubsequence(string s, int start,int end){
    if(start > end) return 0;
    if(start == end) return dp[start][end] = 1;
    if(dp[start][end] != 0) return dp[start][end];
    if(s[start] == s[end]){
        return dp[start][end] = longestPalindromeSubsequence(s, start + 1, end - 1) + 2;
    }
    return dp[start][end] = max(longestPalindromeSubsequence(s, start + 1, end), longestPalindromeSubsequence(s , start, end -1));
}

int main(){
    //freopen("in.in", "r", stdin);
    //freopen("out.in", "w", stdout);
    string str;
    while(cin >> str){
    memset(dp, 0, sizeof(dp));
    cout << longestPalindromeSubsequence(str, 0, str.size() -1) << endl;
    }
    return 0;
}
