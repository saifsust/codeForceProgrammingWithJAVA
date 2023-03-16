#include <bits/stdc++.h>
using namespace std;

stack<int>tracker;

void dfs(int source, long long &counter, vector<vector<int>> &graph,
         vector<bool> &isSpecialWalkPossible, long long low_access_time[] ,
         long long high_access_time[]) {

	tracker.push(source);
	high_access_time[source] = low_access_time[source] = ++counter;

	for (int next : graph[source]) {
		if (high_access_time[next] == 0) {
			dfs(next, counter, graph, isSpecialWalkPossible, low_access_time, high_access_time);
			low_access_time[source] = min(low_access_time[next], low_access_time[source]);

		} else {
			low_access_time[source] = min(low_access_time[source], high_access_time[next]);
		}
	}

	if (low_access_time[source] == high_access_time[source]) {
		bool isPossibleWalk = false;

		while (!tracker.empty() && tracker.top() != source) {
			isPossibleWalk = true;
			isSpecialWalkPossible[tracker.top()] = true;
			tracker.pop();
		}

		if (isPossibleWalk && !tracker.empty()) {
			isSpecialWalkPossible[tracker.top()] = true;
		}
		if (!tracker.empty()) tracker.pop();
	}

}


int main() {
#ifndef ONLINE_JUDGE
	freopen("in.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int n, m, u, v;
	cin >> n >> m;
	long long low_access_time[n + 1], high_access_time[n + 1];
	vector<vector<int>> graph(n + 1, vector<int>());
	vector<bool>isSpecialWalkPossible(n + 1, false);

	for (int i = 0; i < m; i++) {
		cin >> u >> v;
		graph[u].push_back(v);
	}

	memset(high_access_time, 0, sizeof(high_access_time));
	memset(low_access_time, 0, sizeof(low_access_time));

	long long counter = 0;
	for (int i = 1 ; i <= n; i++) {
		if (high_access_time[i] == 0) {
			dfs(i, counter, graph, isSpecialWalkPossible, low_access_time, high_access_time);
		}

		cout <<	isSpecialWalkPossible[i] << " ";
	}

	return 0;
}
