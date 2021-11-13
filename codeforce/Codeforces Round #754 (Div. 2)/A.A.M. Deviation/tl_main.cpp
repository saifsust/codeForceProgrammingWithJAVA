#include<bits/stdc++.h>
using namespace std;

const int N = 200002;

int d(int a1, int a2, int a3) {
    return abs(a1 + a3 - 2 * a2);
}

int d(int sum, int mean) {
    return abs(sum - 2 * mean);
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

        int curr = INT_MAX;
        //Codeforces Round #754 (Div. 2)
        // a1 + a3 == 2 * a2
        // min of abs(a1 + a3 - 2 * a2)
        //  (a1 + a3)/2 > a2
        // (a1 + a3)/2 < a2
        // (a1 + a3) / 2 == a2

        int sum = nums[1] + nums[3];
        int mean = nums[2];
        while ( curr > d(sum, mean)) {
            if (mean == (sum >> 1)) curr = min(curr, d(sum, mean));
            ++sum;
            --mean;
        }
        sum = nums[1] + nums[3];
        mean = nums[2];

        while (curr > d(sum, mean)) {
            if (mean == (sum >> 1)) curr = min(curr, d(sum,  mean));
            --sum;
            ++mean;
        }



        cout << curr << endl;

    }


    return 0;
}
