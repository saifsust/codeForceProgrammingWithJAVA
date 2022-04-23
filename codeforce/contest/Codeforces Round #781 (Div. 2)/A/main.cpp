#include<bits/stdc++.h>
using namespace std;
#define ll long long


ll gcd(ll a, ll b) {
    if (a == 0) return b;
    return gcd( b % a, a);
}

ll lcm(ll a, ll b) {
    return (a * b) / gcd(a, b);
}

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
        int n, a, b, c, d;

        cin >> n;

        cout << n - 3 << " 1 1 1" << endl;


    }

    return 0;
}
