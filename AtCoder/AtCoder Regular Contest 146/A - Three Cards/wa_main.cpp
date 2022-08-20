#include<bits/stdc++.h>
using namespace std;

long long result(long long a, long long b, long long c) {
	int f = log10(b);
	int s = log10(c);
	long long sum = a * pow(10, f + 1) + b;
	return sum * pow(10, s + 1) + c;
}

long long concatenate(long long a, long long b, long long c) {

	long long n1 = result(a, b, c);
	long long n2 = result(a, c, b);
	long long n3 = result(b, a, c);
	long long n4 = result(b, c, a);
	long long n5 = result(c, a, b);
	long long n6 = result(c, b, a);
	//cout << n1 << " " << n2 << " " << n3 << " " << n4 << " " << n5 << " " << n6 << endl;
	return  max(n1, max(n2, max(n3, max(n4, max(n5, n6)))));
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int N;
	cin >> N;

	vector<long long >nums(N);

	for (unsigned i = 0; i < nums.size(); i++) {
		cin >> nums[i];
	}

	sort(nums.begin(), nums.end(), [](const long long a, const long long b) {
		return a  > b;
	});

	cout << concatenate(nums[0], nums[1], nums[2]) << endl;
	return 0;
}
