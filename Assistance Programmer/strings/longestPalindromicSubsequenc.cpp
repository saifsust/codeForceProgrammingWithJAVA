#include<bits/stdc++.h>
using namespace std;
const int64_t  N = 1000;
int dp[N][N];
       //abaxabaxabb
       /**
        *1 1 3 3 3 5 7 7 7 9 9 
        *0 1 1 1 3 5 5 5 7 9 9 
        *0 0 1 1 3 3 3 5 7 7 7 
        *0 0 0 1 1 1 3 5 5 5 5 
        *0 0 0 0 1 1 3 3 3 5 5 
        *0 0 0 0 0 1 1 1 3 5 5 
        *0 0 0 0 0 0 1 1 3 3 3 
        *0 0 0 0 0 0 0 1 1 1 2 
        *0 0 0 0 0 0 0 0 1 1 2 
        *0 0 0 0 0 0 0 0 0 1 2 
        *0 0 0 0 0 0 0 0 0 0 1 
         */
int longestPalindromeLength(string s){
    for(int i = 0; i< s.size(); i++) memset(dp[i], 0, sizeof(dp[i]));
    for(int i = 0; i<=s.size(); i++) dp[i][i] = 1;
    for(int col = 1 ; col < s.size(); col++){
        for(int row = 0, column = col; row < s.size()-1 ; row++, column++){
            if(s[row] == s[column]) dp[row][column] = dp[row + 1][column -1] + 2;
            else dp[row][column] = max(dp[row + 1][column], dp[row][column -1]);
        }
    }

    for(int i = 0; i<s.size(); i++){
        for(int j = 0; j < s.size(); j++){
            cout << dp[i][j] << " ";
        }
        cout << endl;
    }
    cout <<endl;
  return dp[0][s.size()-1];
}


int main(){
    freopen("in.in", "r", stdin);
    freopen("out.in", "w", stdout);
    string str;
    cin >> str;
    cout << longestPalindromeLength(str) << endl;
    return 0;
}
