#include <bits/stdc++.h>
using namespace std;
namespace
{
	const int NN = 100000;
	typedef vector<long long> vll;
}; // namespace

long long min_prime(const vll &next)
{
	long long mn = INT_MAX;
	for (unsigned i = 0; i < next.size(); i++)
	{
		mn = min(mn, next[i]);
	}
	return mn;
}

void super_ulgy(const vll &primes, int m)
{
	vll ugly, next;
	vector<int> next_i;
	next_i.assign(NN, 0);
	for (long long n : primes)
		next.push_back(n);
	while (ugly.size() < (unsigned)m)
	{
		long long mn = min_prime(next);
		//cout << mn << " ";
		ugly.push_back(mn);
		for (unsigned i = 0; i < primes.size(); i++)
		{
			if (next[i] == mn)
			{
				next[i] = primes[i] * ugly[next_i[primes[i]]];
				next_i[primes[i]]++;
			}
		}
	}

	cout << endl;
	for (long long n : ugly)
	{
		cout << n << " ";
	}
	cout << endl;
}

int main(int argc, char *argv[])
{
	int n, m;
	while (scanf("%d%d", &m, &n) == 2)
	{
		vll primes;
		long long val;
		for (int i = 0; i < n; i++)
		{
			scanf("%lld", &val);
			primes.push_back(val);
		}
		super_ulgy(primes, m);
	}
	return 0;
}
