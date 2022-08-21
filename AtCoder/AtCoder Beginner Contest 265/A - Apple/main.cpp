#include<bits/stdc++.h>
using namespace std;

int main() {
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int X, Y, N;
	cin >> X >> Y >> N;
	int yy = N / 3;
	int m = N % 3;
	int ans = min( yy * Y + m * X , X * N);
	cout << ans << endl;
	return 0;
}
