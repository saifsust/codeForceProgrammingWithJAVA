#include<bits/stdc++.h>
using namespace std;

const int N = 200002;

int d(int a1, int a2, int a3) {
    return abs(a1 + a3 - 2 * a2);
}


int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--) {

        int nums[4];
        for (int i = 1; i <= 3; i++) cin >> nums[i];

        cout << (d(nums[1] , nums[2], nums[3]) % 3 == 0 ? 0 : 1) << endl;

    }


    return 0;
}
