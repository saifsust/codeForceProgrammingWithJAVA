#include<bits/stdc++.h>
using namespace std;
const int INF = (int) 1e9;

int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};

typedef struct Node
{
    int kill;
    int x, y;

    Node(int _kill, int _x, int _y)
    {
        kill = _kill;
        x = _x;
        y = _y;
    }

    bool operator <(const struct Node &node) const
    {
        return kill > node.kill;
    }
};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    freopen("input.txt", "r", stdin);

    int T;
    cin >> T;
    for(int t = 1; t<=T; t++)
    {
        int R,C;
        cin >> R >> C;
        int kills[R][C];
        string grid[R];

        for(int r = 0; r < R; r++)
        {
            cin >> grid[r];
            for(int c = 0; c < C; c++)
            {
                kills[r][c] = INF;
            }
        }

        priority_queue<Node>q;
        q.push({0, 0, 0});
        kills[0][0] = 0;

        while(!q.empty())
        {
            Node pnt = q.top();
            q.pop();
            int xx = pnt.x;
            int yy = pnt.y;
            if(xx == R - 1 && yy == C - 1)
            {
                cout << pnt.kill << endl;
                break;
            }

            for(int i = 0; i<4; i++)
            {
                int x = xx + dx[i];
                int y = yy + dy[i];

                if(x >= 0 && x < R && y>=0 && y < C)
                {

                    int k = 1;

                    if(grid[x][y] == grid[xx][yy])
                    {
                        k = 0;
                    }

                    int total = k + pnt.kill;

                    if(total < kills[x][y])
                    {
                        kills[x][y] = total;
                        q.push({total, x, y});

                    }


                }

            }

        }


    }
    return 0;
}
