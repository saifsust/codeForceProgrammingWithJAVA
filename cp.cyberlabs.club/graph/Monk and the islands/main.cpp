#include<bits/stdc++.h>
using namespace std;
const int INF = (int) 1e9;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
   // freopen("input.txt", "r", stdin);
 
    int T;
    cin>> T;
    for(int t = 1; t<=T; t++){
        int n, m;
        cin>> n >> m;
        vector<vector<int>> land(n, vector<int>());
 
        for(int i = 0; i<m; i++){
            int x , y;
            cin >> x >> y;
            --x,--y;
            land[x].push_back(y);
            land[y].push_back(x);
        }
 
        queue<int> q;
        q.push(0);
        int dist[n];
        for(int i = 0; i<n; i++){
            dist[i] = INF;
        }
        dist[0] =  0;
 
        while(!q.empty()){
            int pnt = q.front();
            q.pop();
            for(const int next : land[pnt]){
                int d = 1 + dist[pnt];
                if(d < dist[next]){
                    dist[next] = d;
                    q.push(next);
                }
            }
        }
 
        cout << dist[n - 1] << endl;
    }
    return 0;
}
