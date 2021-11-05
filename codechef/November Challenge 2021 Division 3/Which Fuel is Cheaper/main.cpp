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
        int x, y, a, b, k;
        cin >> x >> y >> a >> b >> k;
        int petrol = x + a * k;
        int diesel  = y + b * k;

        string ans = petrol == diesel ? "SAME PRICE" : petrol < diesel ? "PETROL" : "DIESEL";
        cout << ans << endl;

    }

    return 0;
}
