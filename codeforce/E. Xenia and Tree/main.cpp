#include<bits/stdc++.h>
using namespace std;

#define FAST ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL)
#define FIN freopen("in.txt", "r", stdin)

/**
 * type defination
 **/
typedef vector<int>vi;
typedef vector<vi>vvi;
typedef vector<bool>vbl;

/**
 * const declaration
 **/
 const int N = 100010;
 const int LOGN = 20;
 const int INF = 1000000;
 int red_dist[N], pnts[N][LOGN], dist[N], par[N];
/**
 * ptototypes
 **/
int getCentroid(int start, const vvi &g, const vbl &dead);
void centroidDecompose(const vvi &g);
void DFS(int source, int root, const vvi &g);
int LCA(int u, int v);
int distCalc(int u, int v);
void update(int node);
int query(int node);

int main(int argc, char *argv[]){
	FAST;
	//FIN;
	int n,m, u, v;
	assert(cin >> n >> m);
	vvi g(n+1);
	for(int i = 1; i<n; i++){
		assert(cin >> u >> v);
		g[u].push_back(v);
		g[v].push_back(u);
	}
	dist[1] = 0;
	DFS(1,1,g);
	centroidDecompose(g);
	for(int i = 0; i<=n; i++) red_dist[i] = INF;
	update(1);
    
    for(int i = 0; i<m; i++){
	   assert(cin >> u >> v);
	   if(u == 1) update(v);
	   if(u == 2) cout << query(v) << endl;
	 }
	
	return 0;
}

/**
 * LCA and dist calculate
 **/

void DFS(int source, int root, const vvi &g){
	pnts[source][0] = root;
	for(int i = 1; i<LOGN; i++) pnts[source][i] = pnts[pnts[source][i-1]][i-1];
	for(const int next : g[source]){
		if(next == root) continue;
		dist[next] = dist[source] + 1;
		DFS(next, source, g);
	}
}

int LCA(int u, int v){
	if(dist[u] > dist[v]) swap(u, v);
	if(dist[u] != dist[v]){
		for(int i = LOGN-1; i>=0; i--) if(dist[pnts[v][i]] >= dist[u]) v = pnts[v][i];
	}
	if(u == v) return u;
	for(int i = LOGN-1; i>=0; i--){
		if(pnts[v][i] != pnts[u][i]) v = pnts[v][i], u = pnts[u][i];
	}
	return pnts[v][0];
}

int distCalc(int u, int v){
	return dist[u] + dist[v] - (dist[LCA(u,v)] << 1);
}

/**
 * centroid decompose
 **/

int getCentroid(int start, const vvi &g, const vbl &dead){
	 static vi tsz(g.size(),0);
	/**
	 * sub tree size calc
	 **/
	function < void (int, int)> DFS=[&](int source, int root){
		tsz[source] = 1;
		for(const int next : g[source]){
			if(next == root || dead[next]) continue;
			DFS(next, source);
			tsz[source] += tsz[next];
		}
	};
	DFS(start, -1);
	int hn = tsz[start] >> 1;
	//cout <<"( "<< hn << " " << tsz[start] << " )";
	/**
	 * centroid seek
	 **/
	function<int (int, int )> centroid = [&](int source, int root){
		for(const int next : g[source]){
		    if(next == root || dead[next]) continue;
		    if(tsz[next] > hn) return centroid(next, source);	
		}
		return source;
	};
	return centroid(start, -1);
}
/**
 * decompose tree
 */
void centroidDecompose(const vvi &g){
	vbl dead(g.size()+2, false);
	int start = 1;
	function<void (int,int)> decompose = [&](int start, int root){
		int centroid  = getCentroid(start, g, dead);
		//cout << centroid << "  ";
		
		if(root == -1) root = centroid;
		par[centroid] = root;
		dead[centroid] = true;
		
		for(const int next : g[centroid]){
			if(!dead[next]){
				decompose(next, centroid);
			}
		}
	};
	cout << endl;
	decompose(start, -1);
}

/**
 * update and query
 **/
void update(int node){
	int x = node;
	red_dist[x] = 0;
	while(true){
		red_dist[x] = min(red_dist[x], distCalc(x, node));
		if(x == par[x]) break;
		x = par[x];
	}
}


int query(int node){
	int x = node;
	int ans= INF;
	
	while(true){
	    ans = min(ans, distCalc(x, node) + red_dist[x]);
		if(x == par[x]) break;
		x  = par[x];
	}
	return ans;
}
