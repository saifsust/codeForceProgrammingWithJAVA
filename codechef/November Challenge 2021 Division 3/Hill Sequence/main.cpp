#include<bits/stdc++.h>
using namespace std;

const int N = 200002;


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
        int n;
        cin >> n;
        int nums[n];

        for (int i = 0; i < n; i++) cin >> nums[i];

        sort(nums, nums + n, greater<int>());

        bool isPrint = true;
        int first = 0, last = n - 1;

        int hill_sequence[n], in = n - 1;

        while (first <= last && in >= 0) {

            if (in > 0 && nums[in] < nums[in - 1]) {
                hill_sequence[last--] = nums[in--];
            } else {
                hill_sequence[first++] = nums[in--];
            }

            if ( (last + 2 < n && hill_sequence[last + 2] == hill_sequence[last + 1]) || ( first - 2 >= 0 && hill_sequence[first - 1] == hill_sequence[first - 2])) {
                cout << -1 ;
                isPrint = false;
                break;
            }

        }

        if (isPrint) {
            for (int i = 0; i < n - 1; i++) {
                cout << hill_sequence[i] << " ";
            }
            cout << hill_sequence[n - 1];
        }

        cout << endl;

    }

    return 0;
}
