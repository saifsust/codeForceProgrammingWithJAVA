#include<bits/stdc++.h>
using namespace std;
#define ll long long


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
        vector<ll>nums(n + 3);

        for (int i = 1; i <= n; i++) {
            cin >> nums[i];
        }

        int Q;
        cin >> Q;

        for (int q = 1; q <= Q; q++) {
            int l , r;
            cin >> l >> r;
            ll cost = INT_MAX;

            for (int i = l; i <= r - 1; i++) {
                for (int j = i + 1; j <= r; j++) {
                    cost = min(cost, nums[i] | nums[j]);
                }
            }

            cout << cost << endl;

        }

    }

    return 0;
}
