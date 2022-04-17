#include<bits/stdc++.h>
using namespace std;
const int N = 5 * 200005;
map<long long , long long> SGT[N];

void build(int first, int last, long long  node, int nums[]) {
    if (first > last ) return;
    if (first == last) {
        SGT[node][nums[first]] = 1;
        return;
    }
    // cout << first << " " << node << " " << last << endl;
    int mid = (first + last) >> 1;
    build(first, mid, node << 1, nums);
    build(mid + 1, last, node << 1 | 1, nums);
    for (int i = first ; i <= last; i++) {
        SGT[node][nums[i]] = SGT[node << 1][nums[i]] + SGT[node << 1 | 1][nums[i]];
    }
}

int query(int first, int last, long long  node, int L, int R, int k) {
    if (first > last) return 0;
    if (R < first || L > last) return 0;
    if (L <= first && last <= R) return SGT[node][k];
    int mid  = (first + last) >> 1;

    int left = query(first, mid, node << 1 , L, R, k);
    int right = query(mid + 1, last, node << 1 | 1, L, R, k);

    return left + right;

}

int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin >> n;
    int nums[n + 5];
    for (int i = 1; i <= n; i++) {
        cin >> nums[i];
    }

    build(1, n, 1, nums);

    int Q;
    cin >> Q;

    for (int q = 1; q <= Q; q++) {
        int L, R, K;
        cin >> L >> R >> K;
        cout << query(1, n, 1, L, R, K) << endl;
    }

    return 0;
}
