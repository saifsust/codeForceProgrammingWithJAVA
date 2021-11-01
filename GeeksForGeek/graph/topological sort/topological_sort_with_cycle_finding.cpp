#include<bits/stdc++.h>
using namespace std;

int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int node, edge;
    cin >> node >> edge;
    vector<int>graph[node];
    int u, v;
    for (int i = 0; i < edge; i++) {
        cin >> u >> v;
        graph[u].push_back(v);
    }
    queue<int> source;
    vector<int> in_degree(node, 0);
    for (int i = 0; i < node; i++) {
        for (const int next : graph[i]) {
            in_degree[next]++;
        }
    }

    for (int i = 0; i < node; i++) if (in_degree[i] == 0) source.push(i);
    vector<int> sorted;
    int cnt  = 0;
    while (!source.empty()) {
        int front = source.front();
        source.pop();
        for (const int next : graph[front]) {
            if (--in_degree[next] == 0) source.push(next);
        }
        sorted.push_back(front);
        ++cnt;
    }

    if (sorted.size() != node) cout << "No topological sort exists";
    else {
        for (const int next : sorted) {
            cout << next << " ";
        }
        cout << endl;
    }



    return 0;
}
