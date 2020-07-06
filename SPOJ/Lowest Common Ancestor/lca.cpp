#include<bits/stdc++.h>
using namespace std;
typedef vector<int>vi;
const int N = 1000;
int tim;
int tin[N+1], tout[N+1];

void dfs(int source, int parent, int up[][N+1], int lg, vi *g){
	tin[source] = ++tim;
	up[0][source] = parent;
	for(int i = 1; i<= lg; i++){
		up[i][source] = up[i-1][up[i-1][source]];
	}
	
	for(const auto &child : g[source]){
		if(child == parent) continue;
		dfs(child, source, up, lg, g);
	}
	tout[source]=++tim;
}

bool isAncestor(int u, int v){
	return tin[u] <= tin[v] && tout[u] >= tout[v];
}

int lca(int u, int v, int lg, int up[][N+1]){
	if(u>v) swap(u, v);
	if(isAncestor(u, v)) return u;
	if(isAncestor(v, u)) return v;
	for(int i = lg; ~i; i--) if(!isAncestor(up[i][u], v)) u = up[i][u];
	return up[0][u];
}

void solve(){
	int n, cn, u;
	assert(cin >> n);
	assert(1<= n && n<= N);
	vi g[n+1];
	for(int i = 1; i<= n ; i++){
		assert(cin >> cn);
		assert(0<= cn && cn <= 999);
		for(int k = 1 ; k<= cn; k++){
			assert(cin>>u);
			assert(1 <= u && u<= N);
			g[i].push_back(u);
			g[u].push_back(i);
		}
	}
	int lg = (int)ceil(log2(n));
	int up[lg+1][N+1];
	tim = 0;
	dfs(1,1,up,lg, g);
	int qries, v;
	assert(cin >> qries);
	assert(1<= qries && qries <= N);
	for(int q = 1; q<= qries; q++){
		assert(cin >>u>>v);
		assert(1<= u && u<=N);
		assert(1<=v && v<=N);
		cout << lca(u,v, lg, up) << endl;
	}
}

int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int test; 
	cin >> test;
	for(int t = 1; t<= test; t++){
		cout << "Case " << t << ":"<< endl;
		solve();
	}
	return 0;
}
