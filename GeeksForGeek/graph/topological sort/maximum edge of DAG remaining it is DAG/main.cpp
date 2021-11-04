#include<bits/stdc++.h>
using namespace std;

void topologicalSort(int source, vector<int>*adj, vector<int>&sorted, vector<bool>&visited) {
    visited[source] = true;
    for (const int next  : adj[source]) {
        if (visited[next]) continue;
        topologicalSort(next, adj, sorted, visited);
    }
    sorted.push_back(source);
}

int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    int n, e;
    cin >> n >> e;
    vector<int> adj[n];
    bool isConnected[n][n];
    for (int i = 0; i < n; i++) memset(isConnected[i], false, sizeof(isConnected[i]));
    int u, v;
    for (int i = 0; i < e; i++) {
        cin >> u >> v;
        adj[u].push_back(v);
        isConnected[u][v] = true;
    }

    vector<int> sorted;
    vector<bool> visited(n, false);
    for (int i = 0; i < n;  i++) {
        if (visited[i]) continue;
        topologicalSort(i, adj, sorted, visited);
    }

    int maxEdge = 0;
    for (int i = sorted.size() - 1; i >= 1; i--) {
        for (int j = i - 1; j >= 0; j--) {
            if (isConnected[sorted[i]][sorted[j]]) continue;
            ++maxEdge;
        }
    }
    cout << maxEdge << endl;
    return 0;
}
