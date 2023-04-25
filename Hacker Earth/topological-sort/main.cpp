#include <bits/stdc++.h>

using namespace std;

void dfs(int source, vector<vector<int>> graph, vector<int> &in_deg, vector<int> &sorted, vector<bool> &visited){
	
	if(in_deg[source] != 0 || visited[source]) return;

	visited[source] = true;
	sorted.push_back(source);
   for(const int next : graph[source]){
	 if(in_deg[next] != 0){
		--in_deg[next];
		dfs(next, graph, in_deg, sorted, visited);
	 }
   }
}

vector<int> topologicalSort(int n, vector<vector<int>> graph){
	vector<int> in_deg(n+1, 0);
	
	for(int i = 1; i<=n; i++){
    	sort(graph[i].begin(), graph[i].end());
		for(const int next : graph[i]){
			in_deg[next] = 1 + in_deg[next];
		}
	}

    vector<int> sorted;
	vector<bool> visited(n + 1 , false);

	for(int node = 1; node<=n; node++){
		if(!visited[node] && in_deg[node] == 0){
		 dfs(node, graph, in_deg, sorted, visited);
		}
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
