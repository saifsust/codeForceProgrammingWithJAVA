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
        int arr[n + 1];
        memset(arr, 0, sizeof(arr));
        int a;
        for (int i = 0; i < n; i++) {
            cin >> a;
            arr[a]++;
        }
 
        bool isFound = false;
        for (int i = 1; i <= n; i++) {
            if (arr[i] >= 3) {
                cout << i << endl;
                isFound = true;
                break;
            }
        }
 
        if (!isFound) {
            cout << "-1" << endl;
        }
 
    }
 
    return 0;
}
