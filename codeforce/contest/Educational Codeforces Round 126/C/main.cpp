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
    int T;
    cin >> T;

    for (int t = 1; t <= T; t++) {
        int n;
        cin >> n;
        vector<long long>h(n);
        for (int i = 0; i < n; i++) {
            cin >> h[i];
        }

        if (n <= 1) {
            cout << "0" << endl;
            continue;
        }

        long long mx = *max_element(h.begin(), h.end());
        long long ans = (long long )1e19;

        for (auto need : {mx , mx + 1}) {
            long long even = 0, odd = 0;

            for (long long v : h) {
                long long diff = need - v;
                even += diff / 2;
                odd += diff % 2;
            }

            long long days =  min(even, odd);
            even -= days;
            odd -= days;
            long long  m = 0;
            if (even) {
                m = 4 * (even / 3) + (even % 3 > 0 ? even % 3 + 1 : 0);
            }

            if (odd) {
                m = odd - 1 + odd;
            }
            ans = min(ans, days  * 2 + m);
        }

        cout << ans << endl;

    }

    return 0;
}
