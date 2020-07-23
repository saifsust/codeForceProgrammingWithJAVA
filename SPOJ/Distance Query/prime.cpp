#include<bits/stdc++.h>
using namespace std;
#define F first
#define S second

typedef pair < int , int > ii;
typedef vector<ii>vii;
typedef vector<vii>vvii;

const int N = 100001;
const int LOG = 20;
const int INF = 1e8;
const int NINF = -1e8;

int up[N][LOG], mnv[N][LOG], mxv[N][LOG],n, mn, mx, level[N], u,v,w;

vvii G;

void dfs(int source=1 , int root=1, int w=0){
	up[source][0] = root;
	if(w) mnv[source][0] = mxv[source][0] = w;
	for(int i = 1; i< LOG; i++){
		int pnt = up[source][i-1];
		up[source][i] = up[pnt][i-1];
		mnv[source][i] = min(mnv[source][i-1], mnv[pnt][i-1]);
		mxv[source][i] = max(mxv[source][i-1], mxv[pnt][i-1]);
	}
	for(const auto &next : G[source]){
		if(next.S == root) continue;
		level[next.S] = level[source] + 1;
		dfs(next.S, source, next.F);
	}
	
}

void min_self(int &a, int b){
	a = min(a, b);
}

void max_self(int &a, int b){
	a = max(a,b);
}

void lca(int u, int v){
	mn = INF, mx = NINF;
	if(level[u] > level[v]) swap(u,v);
	
	if(level[u] != level[v]){
		for(int i = LOG - 1; i>=0; i--){
			if(level[up[v][i]] >= level[u]){
				min_self(mn, mnv[v][i]);
				max_self(mx, mxv[v][i]);
				v = up[v][i];
			}
		}
	}
	
	if(u == v) return;
	
	for(int i = LOG -1; i>= 0; i--){
		if(up[u][i] != up[v][i]){
			min_self(mn, mnv[u][i]);
			min_self(mn, mnv[v][i]);
			max_self(mx, mxv[u][i]);
			max_self(mx, mxv[v][i]);
			u = up[u][i] , v = up[v][i];
		}
	}
	
	min_self(mn, mnv[u][0]);
	min_self(mn, mnv[v][0]);
	max_self(mx, mxv[u][0]);
	max_self(mx, mxv[v][0]);
}


int main(int argc , char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	assert(cin >> n);
	G.resize(n+1);
	for(int i = 1; i<= n-1; i++){
		assert(cin >> u >> v>> w);
		G[u].emplace_back(w, v);
		G[v].emplace_back(w, u);
		
	}
	level[1] = 0;
	for(int i = 0; i<LOG; i++){
		mnv[1][i] = INF, mxv[1][i] = NINF;
	}
	dfs();
    int qry ;
    assert(cin >> qry);
    for(int q = 1; q<= qry; q++){
		assert(cin >> u >> v);
		lca(u,v);
		cout << mn << " " << mx << endl;
	}	
	return 0;
}
