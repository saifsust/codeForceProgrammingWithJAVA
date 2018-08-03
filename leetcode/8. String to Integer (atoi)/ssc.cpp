#include<iostream>
#include<vector>
#include<map>
using namespace std;

const int N = 100;
vector<int>G[N];

int num[N], deu[N];
bool visited[N];

void dfs(int init)
{

    for(int i = 0; i < G[init].size(); ++i)
    {
        int child = G[init][i];
        if(!visited[child])
        {
            visited[init] = true;
            num[child] = init;
            deu[child] = child;
            dfs(child);
        }
        else
        {
            num[init] = min(num[init], deu[child]);
        }

    }

}



int main(int argc, char *argv[])
{

    int n, e;
    cin >> n >> e;



}