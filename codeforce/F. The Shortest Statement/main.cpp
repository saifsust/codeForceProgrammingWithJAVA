#include<bits/stdc++.h>
using namespace std;
const int N = 1e5+5;
const int LOG = 19;
const int MdN = 21;
const long long INF = LONG_LONG_MAX;
typedef pair<int, int > pii;
typedef vector<pii> vpii;
typedef queue<int>qi;
typedef set<pii>spii;
vpii g[N];
spii ignored;
int level[N], up[N][LOG], n,m, u, v, w;
long long h[N], dist[MdN][N];
bool visited[N];
void dfs(int source = 1, int root = 1){
	up[source][0] = root;
	visited[source] = true;
	for(int i = 1; i<LOG; i++){
		up[source][i] = up[up[source][i-1]][i-1];
	}
	for(const auto &next : g[source]){
		if(!visited[next.first]){
		h[next.first] = h[source] + next.second;
		level[next.first] = level[source] + 1;
		dfs(next.first , source);
		// erase visited path
		if(source < next.first) ignored.erase(make_pair(source, next.first));
		else ignored.erase(make_pair(next.first, source));
	}
	}
}

int lca(int u, int v){
	if(u == v) return u;
	if(level[u] > level[v]) swap(u,v);
	if(level[u] != level[v]){
		for(int i = LOG-1; i>= 0; i--){
			if(level[up[v][i]] >= level[u]){
				v = up[v][i];
			}
		}
	}
	if(u == v) return u;
	for(int i = LOG -1; i>= 0; i--){
		if(up[v][i] != up[u][i]) v=up[v][i],u=up[u][i];
	}
	return up[u][0];
}


void dijkstr(int source, long long d[N]){
	qi q;
	q.push(source);
	for(int i = 0; i<= n; i++) d[i] = INF;
	d[source] = 0;
	while(!q.empty()){
	  int pnt = q.front();
	  q.pop();
	  for(const auto next : g[pnt]){
		  long long  dst = d[pnt] + next.second;
		  if(dst < d[next.first]){
			  d[next.first] = dst;
			  q.push(next.first);
		  }
	  }
	}
}
void min_self(long long  &a, long long b){
	a = min(a,b);
}

void solve(int u, int v){
	if(u==v){
		cout << "0"<<endl;
		return;
	}
	int an = lca(u, v);
	//cout << an << endl;
	long long  ans = h[u] + h[v] - (h[an] << 1);
	//cout << ans << endl;
	for(int i=0; i<(int)ignored.size(); i++){
		//cout << dist[i][u] << " " << dist[i][v] << endl;
		min_self(ans, dist[i][u] + dist[i][v]);
	}
	
	cout << ans << endl;
}

int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	assert(cin >> n  >> m);
	assert(m-n <= 20);
	for(int i = 0; i<m; i++){
		assert(cin >> u >> v >> w);
		g[u].emplace_back(v, w);
		g[v].emplace_back(u, w);
		if(u > v) swap(u,v);
		ignored.insert(make_pair(u,v));
	}
	level[1] = 0;
	h[1]= 0;
	dfs();
	int i=0;
	for(const auto source : ignored){
		//cout << source.first <<"->" << source.second << endl;
		dijkstr(source.first, dist[i++]);
	}
	int qry;
	assert(cin >> qry);
	for(int q = 1; q<= qry; q++){
		assert(cin >> u >> v);
		solve(u, v);
	}
	return 0;
}
