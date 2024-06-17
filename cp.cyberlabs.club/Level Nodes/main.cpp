#include<bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    freopen("input.txt", "r", stdin);

    int n;
    cin >> n;
    vector<vector<int>> tree(n, vector<int>());
    int u,v;

    for(int i = 0; i< n-1; i++){
        cin >> u >> v;
        --u,--v;
        tree[u].push_back(v);
        tree[v].push_back(u);
    }

    int x;
    cin >> x;
    --x;

    int levelToNodes[n];
    memset(levelToNodes, 0, sizeof(levelToNodes));

    queue<pair<int,int>> q;
    q.push(make_pair(0, 0));

    bool visited[n];
    memset(visited, false, sizeof(visited));

    levelToNodes[0] = 1;
    visited[0] = true;

    while(!q.empty()){
        pair<int, int> levelToPnt = q.front();
        q.pop();

        for(int next : tree[levelToPnt.second]){
            if(!visited[next]){
                visited[next] = true;
                int l = levelToPnt.first + 1;
                ++levelToNodes[l];
                q.push(make_pair(l, next));
            }
        }
    }

    cout << levelToNodes[x] << endl;
    return 0;
}
