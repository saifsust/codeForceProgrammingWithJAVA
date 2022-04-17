#include<bits/stdc++.h>
using namespace std;



int main() {
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	const int N = 200005;
	int n , a;
	cin >> n;
	vector<vector<int>>nums(N);

	for (int i = 0; i < n; i++) {
		cin >> a;
		nums[a].push_back(i);
	}

	int Q, L, R, K;
	cin >> Q;

	for (int q = 1; q <= Q; q++) {
		cin >> L >> R >> K;
		cout << lower_bound(nums[K].begin(), nums[K].end(), R) - lower_bound(nums[K].begin(), nums[K].end(), L - 1) << endl;
	}

	return 0;
}
