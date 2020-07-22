#include<bits/stdc++.h>
using namespace std;

#define F first
#define S second

typedef pair < long long , int > lli;
typedef vector<lli>vlli;
typedef vector<vlli>vvlli;

const int N = 1e5+4;
const int LOG = 20;
const long long RNG = 1e9;
int level[N], up[N][LOG],t = 0,n, u,v;
long long h[N], w, mval[N][LOG], mx = 0;

vvlli G;

void dfs(int source = 0, int root = 0, long long w=0)
{
	up[source][0] = root;
	mval[source][0] = w;
	for(int i = 1; i<LOG; i++){
		up[source][i] = up[up[source][i-1]][i-1];
		mval[source][i] = max(mval[source][i-1] , mval[up[source][i-1]][i-1]);
	}
	for(const auto &next : G[source]){
		if(next.S == root) continue;
		h[next.S] = h[source] + next.F;
		level[next.S] = level[source] + 1;
		dfs(next.S, source, next.F);
	}
}

void max_self(long long &a, long long b){
	a = max(a, b);
}

int lca(int u, int v){
	if(level[u] > level[v]) swap(u,v);
	if(level[u] != level[v]){
		for(int i = LOG - 1; i>= 0 ; i--){
			if(level[up[v][i]] >= level[u]){
			    max_self(mx, mval[v][i]);
				v = up[v][i];
			}
		}
	}
	if(u==v) return u;
	for(int i = LOG -1; i>= 0 ; i--){
		if(up[u][i] != up[v][i]){
			max_self(mx, mval[u][i]);
			max_self(mx, mval[v][i]);
			u= up[u][i], v = up[v][i];
		}
	}
	
	max_self(mx, mval[u][0]);
	max_self(mx, mval[v][0]);
	return up[u][0];
}

void debug(){
	cerr << "PNT " << endl;
	for(int i = 0 ; i<=n; i++){
		for(int j = 0; j<LOG; j++){
			cerr << up[i][j] << " ";
		}
		cerr << endl;
	}
	cerr << "MVAL" << endl;
	for(int i = 0; i<=n; i++){
		for(int j = 0; j<LOG; j++){
			cerr << mval[i][j] << " ";
		}
		cerr << endl;
	}
}


int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	assert(cin >> n);
	G.resize(n+1);
	for(int i = 1; i<=n-1; i++){
		assert(cin >> u >> v >> w);
		assert(1<=u && u<=n);
		assert(1<=v && v <=n);
		assert(1<= w && w <= RNG);
		u--, v--;
		G[u].emplace_back(w,v);
		G[v].emplace_back(w, u);
	}
	h[0]=level[0]= 0;
	dfs();
	//debug();
	int qry;
	assert(cin >> qry);
    for(int q = 1; q <= qry; q++){
		assert(cin >> u >> v >> w);
		assert(u != v);
		assert(1<= u && u<=n);
		assert(1<= v && v<=n);
		assert(1 <= w && w <= RNG);
		u--, v--;
		mx = 0;
		int anc = lca(u,v);
		cerr << endl;
		cerr <<"anc " << anc << " ans " << mx << endl;
		long long sum = h[u] + h[v] - (h[anc] << 1);
		cerr <<"sum "<< sum << endl;
		long long ans = sum	 - mx + w;
		cerr << ans << endl;
		if(ans < sum) cout << "YES" << endl;
		else cout << "NO" << endl;	
	}	
	return 0;
}
