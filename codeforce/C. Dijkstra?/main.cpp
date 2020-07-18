#include<bits/stdc++.h>
using namespace std;
const int N= 1e5+5;
const long long INF = LONG_LONG_MAX;
long long dist[N],m,n;
typedef pair<int,int>pii;
typedef vector<pii>vpii;
typedef priority_queue<pii, vpii , greater<pii> >pq;
typedef map<pii, bool > mb;
vpii g[N];
int path[N];
bitset<N>visited;
void dijkstra(int source=1, int tt=n){
	pq q;
	q.emplace(0, source);
	path[source] = -1;
	dist[source] = 0;
	path[tt] = -1;
	while(!q.empty()){
		auto top = q.top();
		 q.pop();
		int pnt = top.second;
		if(pnt == tt) return;
		visited[pnt] = true; 
		for(const auto &next : g[pnt]){
			long long d = dist[pnt] + next.second;
			if(dist[next.first] > d  && !visited[next.first]){
				dist[next.first] = d;
				path[next.first] = pnt;
				q.emplace(d, next.first);
			}
		}
	}
}

int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);	
	assert(cin >> n >> m);
	int u,v,w;
	for(int i = 0; i<m; i++){
		assert(cin >>  u >> v >> w);
		g[u].emplace_back(v, w);
		g[v].emplace_back(u, w);
		dist[u] = dist[v] = INF;
	}
	
	dijkstra();
	
	if(path[n] == -1){
		cout << -1 << endl;
		return 0;
	}
	
	vector<int> p;
	for(int x = n; x != -1; x = path[x]) p.push_back(x);
	for(int i = (int) p.size() -1; i>0; i--) cout << p[i] << " ";
	cout << p[0] << endl;
	return 0;
}
