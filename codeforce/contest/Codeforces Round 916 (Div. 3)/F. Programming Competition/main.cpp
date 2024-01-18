#include<bits/stdc++.h>
using namespace std;
 
void dfs(int source, vector<int> &sz, vector<vector<int>> &graph){
	sz[source] = 1;
	for(int next : graph[source]){
		dfs(next, sz, graph);
		sz[source] += sz[next];
	}
}
 
int maximumPair(int source, int countedPair, vector<int> &sz, vector<vector<int>> &graph){
	int T = 0;
	int M = - 1;
 
	// find maximum children node and counter total children
	for(int next : graph[source]){
		T += sz[next];
		if(M == -1 || sz[M] < sz[next]) M = next;
	}
 
	if(T == 0) return T;
 
	// maximum children node is equal to remaining children then all children can make pair to other node children
 
	if(sz[M]  - countedPair <= T - sz[M]) return (T - countedPair) / 2;
 
	// pair able children
	int counter = T - sz[M];
 
	return counter + maximumPair(M, max(0, countedPair + counter - 1), sz, graph);
 
 
}
 
 
int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int T;
	cin >> T;
 
	for(int t  = 1; t<= T; t++){
		int n ;
		cin >> n;
		vector<vector<int>> graph(n, vector<int>());
		int u;
		for(int i = 1; i<n; i++){
			cin >> u;
			--u;
			graph[u].push_back(i);
		}
 
		vector<int> sz(n, 0);
 
		dfs(0, sz, graph);
 
		cout << maximumPair(0, 0, sz, graph) << endl;
	}
	return 0;
}
