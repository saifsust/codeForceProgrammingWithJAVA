#include<bits/stdc++.h>
using namespace std;
int dx[] = {0, 0, 1, -1};
int dy[] = {-1, 1, 0, 0};

float DFS(int row, int col, int n, int m, vector<vector<char>> board, vector<vector<pair<int,int>>> tunnels, vector<vector<bool>>&used){

   // cout << board[row][col] << endl;

    if(board[row][col] == '%'){
        return 1.0;
    }

    used[row][col] = true;
    int rowx = tunnels[row][col].first;
    int coly  = tunnels[row][col].second;

    float tunnelsAns=0.0, axiesAns=0.0;

    float result = 0;
    if(rowx > -1 && coly > -1 && used[rowx][coly] == false && (board[rowx][coly] != '#' || board[rowx][coly] != '*')){
        result  += DFS(rowx, coly, n, m, board, tunnels, used)/4.0;
        if(board[rowx][coly] == '%'){
          return result;
        }
    }

    for(int i = 0; i<4; i++){
        int x = dx[i] + row;
        int y = dy[i] + col;
        if(x >= 0 && x < n && y >= 0 && y <m ){
            if(used[x][y] == false && (board[x][y] != '#' || board[x][y] != '*')){
               result +=  DFS(x, y, n, m, board, tunnels, used);
            }
        }
    }

    return result / 4.0;
}

int main(){
    freopen("input.txt", "r", stdin);
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n, m, k;
    cin >> n >> m >> k;
    vector<vector<char>>board(n, vector<char>(m));
    vector<vector<pair<int,int>>> tunnels(n, vector<pair<int,int>>(m, make_pair(-1, -1)));
    vector<vector<bool>>used(n, vector<bool>(m, false));

    int u, v;
    string inp;
    for(int i = 0; i<n; i++){
        cin >>inp;
        for(int j = 0; j<m; j++){
            board[i][j] = inp[j];
            if(board[i][j] == 'A'){
                u = i;
                v = j;
            }
        }
    }

    int a,b,c,d;
    for(int i = 0; i<k; i++){
        cin >> a >> b >> c >> d;
        tunnels[--a][--b] = make_pair(--c, --d);
    }

    printf("%0.2f",DFS(u, v, n, m, board, tunnels, used));

    return 0;
}
