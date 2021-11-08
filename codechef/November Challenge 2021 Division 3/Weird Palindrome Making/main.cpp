#include<bits/stdc++.h>
using namespace std;

const int N = 200002;

int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    long long dp[N];
    dp[0] = dp[1] = 0;

    for (int i = 2; i < N; i++) dp[i] = dp[i - 2] + 1;

    int T;
    cin >> T;


    while (T--) {
        int n;
        cin >> n;
        int sum = 0, counter = 0;
        for (int i = 0; i < n; i++) {
            cin >> counter;
            sum += counter % 2;
        }

        cout << dp[sum] << endl;
    }

    return 0;
}


## input:

2
1
4
3
4 3 1
  
## output:
  0
  1
