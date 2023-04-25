#include <bits/stdc++.h>

using namespace std;

void dfs(int source, vector<vector<int>> graph, stack<int> &tracker, vector<bool> &visited){
	visited[source] = true;
	for(const int next : graph[source]){
		if(!visited[next]){
			dfs(next, graph, tracker, visited);
		}
	}
	tracker.push(source);
}


vector<int> topologicalSort(int n, vector<vector<int>> graph){
	   stack<int> tracker;
   vector<bool> visited(n + 1, false);

   for(int node  = 1; node<= n; node++)
   sort(graph[node].begin(), graph[node].end(), [&](const int a, const int b){
	return a > b;
   });
   
   for(int node = n; node >0; node--){
	if(!visited[node]){
		dfs(node, graph, tracker, visited);
	}
   }

	vector<int> sorted;

	while(!tracker.empty()){
	 sorted.push_back(tracker.top());
	 tracker.pop();
   }

   return sorted;
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int n, m, x, y;
	cin >> n >> m;
	vector<vector<int>> graph(n+1, vector<int>());
	for(int i = 0; i< m; i++){
		cin >> x >> y;
		graph[x].push_back(y);
	} 


   vector<int> sorted = topologicalSort(n,graph);

   for(int i = 0; i<(int) sorted.size()-1; i++){
	cout << sorted[i] << " ";
   }  

   cout << sorted[sorted.size() - 1] << endl;

 return 0;
}
