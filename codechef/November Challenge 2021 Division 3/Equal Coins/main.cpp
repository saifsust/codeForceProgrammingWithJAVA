#include<bits/stdc++.h>
using namespace std;


int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    while (T--) {
        long long x, y;
        cin >> x >> y;
        long long total = (x + 2 * y);
        string ans = "YES";
        if (total % 2)  ans = "NO";
        if (x == 0 && y % 2 == 1 ) ans = "NO";
        cout << ans << endl;

    }

    return 0;
}
