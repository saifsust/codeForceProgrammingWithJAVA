#include<bits/stdc++.h>
using namespace std;
const int dx[]= {0, 1, 0, -1};
const int dy[]= {1, 0, -1, 0};
typedef pair<int,int> pii;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    //freopen("input.txt", "r", stdin);

    int T;

    cin >> T;

    while(T--){
        int n, m;
        cin >> n >> m;
        string grid[n];
        int dist[n][m];

        queue<pii>q;

        for(int i = 0; i<n; i++){
            cin >> grid[i];
            for(int j = 0; j<m; j++){
                dist[i][j] = INT_MAX;
                if(grid[i][j] == '1'){
                    q.push(make_pair(i, j));
                    dist[i][j] = 0;
                }
            }
        }


        while(!q.empty()){
           auto [xx, yy] = q.front();
           q.pop();

           for(int i = 0; i<4; i++){
                int x = xx + dx[i];
                int y = yy + dy[i];

                if(x >= 0 && x < n && y>=0 && y < m){
                        int d = dist[xx][yy] + 1;

                        if(d < dist[x][y] && grid[x][y] == '0'){
                                dist[x][y] = d;
                                q.push(make_pair(x, y));
                        }
                }
           }

        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                printf("%d ", dist[i][j]);
            }
            printf("\n");
        }


    }

    return 0;
}
