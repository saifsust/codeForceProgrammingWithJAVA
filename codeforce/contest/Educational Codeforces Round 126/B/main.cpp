#include<bits/stdc++.h>
using namespace std;
const int mod = 32768;


int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T, num;
    cin >> T;
    for (int  t  = 1; t <= T; t++) {
        cin >> num;
        num %= mod;

        int ans = INT_MAX;
        for (int add = 0; add <= 16; add++) {
            for (int mult = 0; mult <= 16; mult++) {
                int val = (num + add) * pow(2, mult);
                if (val % mod == 0) {
                    ans = min(ans, add + mult);
                }
            }
        }

        cout << ans << endl;

    }
    return 0;
}
