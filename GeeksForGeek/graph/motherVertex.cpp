#include<bits/stdc++.h>
using namespace std;
int cnt;
void dfs(int source , bool visited[], vector<int64_t> graph[]){
    visited[source] = true;
    //cout << source << endl;
    ++cnt;
    for(const int64_t next : graph[source]){
        if(!visited[next]){
            dfs(next, visited, graph);
        }
    }
}

int main(){
    freopen("in.txt", "r", stdin);
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int64_t n, e;
    cin >> n >> e;
    vector<int64_t>graph[n+1];
    int u, v;
    for(int64_t i = 0; i<e; i++){
        cin >> u >> v;
        graph[u].push_back(v);
    }
     bool visited[n+1];
    for(int i = 0; i<n; i++){
       memset(visited, false, sizeof(visited));
        cnt = 0;
        dfs(i, visited, graph);
        if(cnt == n) cout << i << endl;
    }
  
    return 0;
}
