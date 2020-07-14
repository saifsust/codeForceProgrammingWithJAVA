#include<bits/stdc++.h>
using namespace std;
const int N = 1001;
const int BIT = 2030;
const int INF = INT_MAX;
typedef pair<int,int > pii;
typedef vector<pii>vpii;
vpii g[N];
int  n,m, u,v,w;
bool visited[N][BIT];

void dijkstra(int source){
	memset(visited, false, sizeof(visited));
	queue<pii>q;
	q.emplace(source, 0);
	while(!q.empty()){
		pii top = q.front();
		int pnt = top.first;
		int pnt_w = top.second;
		visited[pnt][pnt_w] = true;
		q.pop();
		for(const auto &next : g[pnt]){
		   if(!visited[next.first][pnt_w | next.second]){
			   q.emplace(next.first, pnt_w|next.second);
		   }
		}
	}
}

int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	assert(cin >> n >> m);
	for(int i = 0; i<m; i++){
		assert(cin >> u >> v >> w);
		g[u].emplace_back(v,w);
		g[v].emplace_back(u, w);
	}
	cin >> u >> v;
	dijkstra(u);
	int ans = -1;
	for(int i = 0; i<1024; i++){
		if(visited[v][i]){
			ans = i;
			break;
		}
	}
	cout << ans << endl;
	
	return 0;
}
