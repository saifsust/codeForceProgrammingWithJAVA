#include<bits/stdc++.h>
using namespace std;

typedef vector<int>vi;


void salesman(int source, vector<vi> graph, vector<bool> &visited, vector<int>&ans)
{
    ans.push_back(source);
    visited[source]=true;

    for(int i = 0; i<graph[source].size(); i++)
    {
        int smaller = INT_MAX;
        for(int next : graph[source])
        {
            if(smaller > next && !visited[next])
            {
                smaller = next;
            }
        }

        if(smaller == INT_MAX) return;

        salesman(smaller, graph, visited, ans);

    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
   // freopen("input.txt", "r", stdin);
    int n, m;

    cin >> n >> m;
    vector<vi> graph(n, vector<int>());

    for(int i = 0; i<m; i++)
    {
        int u,v;
        cin  >> u >> v;
        --u, --v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    vector<bool>visited(n, false);
    vector<int> ans;
    salesman(0, graph, visited, ans);

    for(int val: ans)
    {
        printf("%d ", val + 1);
    }

    return 0;
}
