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
    const int N = 1003;
    int T, n;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        cin >> n;
        vector<int> candies(n);

        for (int i = 0; i < n; i++) {
            cin >> candies[i];
        }

        int left = 0, right = n - 1;
        long long a = 0, b = 0;
        long long  tc = 0;
        long long ans = INT_MIN;
        while (left <= right) {
            a += candies[left++];
            ++tc;

            if (a == b) {
                ans = tc;
            }

            //cout << left << endl;

            while ( left <= right && b <= a) {
                cout << right << endl;
                b += candies[right--];

                ++tc;
                if ( a == b ) {
                    ans = tc;
                }
            }

            // cout << left << " " << right << endl;
        }

        cout << (ans == INT_MIN ? 0 : ans) << endl;


    }

    return 0;
}
