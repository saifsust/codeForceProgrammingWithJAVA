#include <bits/stdc++.h>
using namespace std;

void dfsForward(int source, vector<vector<int>> &graph, vector<bool> &visited, 
vector<int>&order){
	visited[source] = true;
	for(int next : graph[source]){
		if(!visited[next]) dfsForward(next, graph, visited, order);
	}
	order.push_back(source); 
}

void dfsReverse(int source, vector<vector<int>> &graph, vector<bool> &visited, 
vector<int>&forward){
	visited[source] = true;
	forward.push_back(source);
	for(int next : graph[source]){
		if(!visited[next]) dfsReverse(next, graph, visited, forward);
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
	vector<vector<int>> graphForward(n+1, vector<int>()), graphReverse(n+1, vector<int>());
	vector<bool>visited(n+1, false);
	vector<int> order, comp, ans(n+1, 0);

	for(int i = 0; i<m; i++){
		cin >> u >> v;
		graphForward[u].push_back(v);
		graphReverse[v].push_back(u);
	}

	for(int node = 1; node<=n;  node++){
		if(!visited[node]){
			dfsForward(node, graphForward, visited, order);
		}
	}

	reverse(order.begin(), order.end());

	for(int i = 0; i<= n; i++){
		visited[i] = false;
	}

	for(int i = 0; i<order.size(); i++){
		comp.clear();

		if(!visited[order[i]]){
			dfsReverse(order[i], graphReverse, visited, comp);
		}
		if(comp.size() == 1) continue;
		for(int i = 0; i<comp.size(); i++){
			ans[comp[i]] = 1;
		}
	}

	for(int i = 1 ; i<=n; i++){
		cout << ans[i] << " ";
	}


	return 0;
}
