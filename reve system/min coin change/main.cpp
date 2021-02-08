#include<bits/stdc++.h>
using namespace std;
const int inf = 1000000000;
int minCoin(int *coins, int numOfCoins, int num){
    int dp[numOfCoins+1][num+1];
    for(int i = 0; i<= num ; i++){
        dp[0][i] = inf;
    }
    for(int i = 1; i<=numOfCoins; i++){
        for(int j =1; j<=num; j++){
            if( j == coins[i-1]) dp[i][j] = 1;
            else if ( j > coins[i-1]) dp[i][j] = min(dp[i-1][j], dp[i][j - coins[i-1]] + dp[i][coins[i-1]]);
            else dp[i][j] = dp[i-1][j];
        }
    }

   for(int i = 0; i<= numOfCoins; i++){
       for(int j = 0; j<= num; j++){
           cout << dp[i][j] << " ";
       }
       cout << endl;
   }

    return dp[numOfCoins][num];
}

int main(int argc, char* argv[]){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int num, numOfCoins;
    while(cin >> numOfCoins >> num){
        int coins[numOfCoins+1];
        for(int i = 0; i<numOfCoins; i++) cin >> coins[i];
        cout << minCoin(coins, numOfCoins, num) << endl;
    }
    return 0;
}