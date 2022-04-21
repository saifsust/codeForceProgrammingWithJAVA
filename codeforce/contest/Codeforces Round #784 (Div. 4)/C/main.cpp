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
        vector<int> nums(n + 3);
        for (int i = 1; i <= n; i++) {
            cin >> nums[i];
        }
 
 
        bool isPossible = true;
        for (int i = 1; i <= n - 2; i++) {
            if (nums[i] % 2 != nums[i + 2] % 2) {
                isPossible = false;
                break;
            }
        }
 
        if (isPossible) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
 
    }
 
    return 0;
}
