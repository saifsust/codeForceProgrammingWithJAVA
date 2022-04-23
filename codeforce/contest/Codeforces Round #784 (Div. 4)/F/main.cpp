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
        vector<int>cn(n);

        for (int i = 0; i < n; i++) {
            cin >> cn[i];
        }

        int left = 0, right = n - 1;

        int cntb = 0 , cnta = 0;

        int ans = 0, counter = 0;

        while (left <= right) {
            cnta += cn[left];
            ++counter;
            ++left;
            if (cnta == cntb) {
                ans = counter;
            }

            while (left <= right && cntb <= cnta) {
                cntb += cn[right--];
                ++counter;
                if (cntb == cnta) {
                    ans = counter;
                }

            }
        }

        cout << ans << endl;

    }

    return 0;
}
