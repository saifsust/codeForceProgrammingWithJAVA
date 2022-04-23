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

        bool ok = true;

        for (int i  = 1; ok && i < n; i++) {
            for (int j = 1; ok && i + j < n; j++) {
                for (int k = 1; ok && j + k < n; k++) {
                    for (int m = 1; ok && m + k <= n; m++) {
                        if (i + j + k + m == n) {
                            if (gcd(i, j) == lcm(k, m)) {
                                cout << i << " " << j << " " << k << " " << m << endl;
                                ok = false;
                                break;
                            }

                            if (gcd(i, k) == lcm(j, m)) {
                                cout << i << " " << k << " " << j << " " << m << endl;
                                ok = false;
                                break;
                            }

                            if (gcd(i, m) == lcm(j, k)) {
                                cout << i << " " << m << " " << j << " " << k << endl;
                                ok = false;
                                break;
                            }
                        }
                    }
                }
            }
        }



    }

    return 0;
}
