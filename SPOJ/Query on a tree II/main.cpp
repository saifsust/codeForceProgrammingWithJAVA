#include<bits/stdc++.h>
using namespace std;

#define F first
#define S second

typedef pair<int,int>ii;
typedef vector<ii>vii;
typedef vector<vii>vvii;
typedef vector<int>vi;

const int N = 1e4;
const int LOG = 20;

int up[N+2][LOG], h[N+2], level[N+2], path[N+2];

void dfs(int source, int root, vvii &G){
	up[source][0] = root;
	
	for(int i = 1; i<LOG; i++){
		up[source][i] = up[up[source][i-1]][i-1];
	}
	 
	for(const auto next : G[source]){
		if(next.S == root) continue;
		h[next.S] = h[source] + next.F;
		level[next.S] = level[source] + 1;
		path[next.S] = source;
		dfs(next.S, source, G);
	}
}


int lca(int u, int v){
	if(level[u] > level[v]) swap(u, v);
	
	if(level[u] != level[v]){
		for(int i = LOG-1; i>= 0; i--){
			if(level[up[v][i]] >= level[u]) v = up[v][i];
		}
	}
	
	if(u == v) return u;
	
	for(int i = LOG-1; i>=0; i--){
		if(up[v][i] != up[u][i]){
			u = up[u][i], v = up[v][i];
		}
	}	
	return up[v][0];
}



int main(int argc, char *argv[]){
	
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	int test;
	assert(cin >> test);
	for(int tt = 1; tt <= test; tt++){
		int n, u, v, w;
		assert(cin >> n);
		assert(n <= N);
		vvii G(n+2);
		
		for(int i = 1; i<= n-1; i++){
			assert(cin >> u >> v >>w);
			G[u].emplace_back(w, v);
			G[v].emplace_back(w, u);
		}
		
		level[1] = h[1] = 0;
		memset(path, 0, sizeof path);
		path[1]=1;
		dfs(1,1, G);
		
		string str;
		while(cin >> str){
			if(!str.compare("DONE")) break;
			
			if(!str.compare("DIST")){
				assert(cin >> u >> v);
				assert(1 <= u && u <= n);
				assert(1 <= v && v <= n);
				int anc = lca(u, v);
				//cerr << anc << endl;
				cout << (h[u] + h[v] - (h[anc] << 1)) << endl;
			}
			
			if(!str.compare("KTH")){
				assert(cin >> u >> v >> w);
				int anc = lca(u, v);
				vi p;
				int i = 0;
				while(u != anc){
					p.push_back(u);
					u = path[u];
					i++;
				}
				p.push_back(anc);
				i++;
				while(v != anc){
					p.push_back(v);
					v  = path[v];
				}
				reverse(p.begin()+i, p.end());
				cout << p[w-1] << endl;
			}
		}
		
		
	}
	return 0;
}
