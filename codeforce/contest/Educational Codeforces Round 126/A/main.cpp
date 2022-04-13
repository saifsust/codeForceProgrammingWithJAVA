#include<bits/stdc++.h>
using namespace std;


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
        int a[n], b[n];

        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }

        for (int i = 0; i < n; i++) {
            cin >> b[i];
        }

        long long sum = 0;

        for (int i = 0; i < n - 1; i++) {
            if (abs(a[i] - a[i + 1]) + abs(b[i] - b[i + 1]) > abs(a[i] - b[i + 1]) + abs(b[i] - a[i + 1])) {
                swap(a[i + 1], b[i + 1]);
            }
            sum += abs(a[i] - a[i + 1]) + abs(b[i] - b[i + 1]);
        }

        cout << sum << endl;

    }
    return 0;
}
