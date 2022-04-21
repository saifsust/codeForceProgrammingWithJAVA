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

    int T, n;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        cin >> n;
        if (n == 0) {
            cout << "0 ";
            continue;
        }
        int ans = INT_MAX;
        for (int a = 0; a <= 15; a++) {
            int p = (n + a);
            int counter = 0;
            while (p % 2 == 0) {
                ++counter;
                p /= 2;
            }

            ans = min(ans, a + 15 - counter);
        }

        cout << ans << " ";
    }

    return 0;
}
