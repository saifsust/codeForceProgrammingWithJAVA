#include<bits/stdc++.h>
using namespace std;

#define FIO ios::sync_with_stdio(false); cin.tie(0); cout.tie(0)
#define FIN freopen("in.txt","r",stdin)
#define NN 100005
#define LOG 20
#define F first
#define S second

typedef pair<int,int> ii;
typedef vector<int>vi;
typedef vector<vi>vvi;

int up[NN][LOG],depth[NN],pos[NN], chainHead[NN],chain[NN], base[NN], inx=0, chainNo=0, sizeSubTree[NN];
ii SGMNT[NN];
/**
 * prototype declaration 
 **/

void HLD(int curr, int prev, vvi &G, vvi &costINX, int cost);
void query(int u, int v, int L, int R,char action, int &ans);
void DFS(int node, int root, vvi &G);
int LCA(int u, int v);
void build(int node, int L,int R);
ii query(int node, int s, int e, int L, int R);
void update(int node, int s,int e, int L, int R);

/**
 * main function 
 **/
int main(int argc, char *argv[]){
	FIO;	
	FIN;
	int N;
	assert(cin >> N);
	vvi G(N+1), costINX(N+1);
	int u,v,c;
	/**
	 * inputter
	 **/
	
	for(int i = 0; i<N-1; i++){
		assert(cin >> u >> v >> c);
		G[u].push_back(v);
		G[v].push_back(u);
		costINX[u].push_back(c);
		costINX[v].push_back(c);
	}
	
	depth[1] = 0;
	inx = 0;
	chainNo = 0;
	DFS(1,1, G);
	HLD(1, -1, G,costINX, 0);
	build(1, 0, inx);
	int q, lca, ans=INT_MIN;
	char action;
	assert(cin >> q);
	for(int t = 1; t<=q; t++){
		assert(cin >> action >> u >> v);
		lca = LCA(u,v);
		//cout << lca << endl;
		query(u, lca ,0, inx-1, action, ans);
		query(lca, v, 0, inx-1, action, ans);
		if (action == 'f') continue;
		cout << ans << endl;
		
	}
	return 0;
}

/**
 * DFS visits all nodes and retains track there parents
 **/

void DFS(int node, int root, vvi &G){
	cout << node << " " << root << endl;
	up[node][0] = root;
	for(int i = 1; i<LOG; i++){
		up[node][i] = up[up[node][i-1]][i-1];
	}
	sizeSubTree[node] = 1;
	for(const int child : G[node]){
		if(child == root) continue;
		depth[child] = depth[node] + 1;
		DFS(child, node, G);
		sizeSubTree[node] += sizeSubTree[child];
	}
}

/**
 * construct heavy light decompose
 **/
void HLD(int curr, int prev,vvi &G, vvi &costINX, int cost){
	if(chainHead[chainNo] == -1) chainHead[chainNo] = curr;
	chain[curr] = chainNo;
	base[inx] = cost;
	pos[curr] = inx++;
	/**
	 * choose heavy child
	 **/
	int heavy = -1;
	for(unsigned i = 0; i< G[curr].size(); i++){
		int child = G[curr][i];
		if(child == prev) continue;
		if(heavy == -1 || sizeSubTree[heavy] < sizeSubTree[child]){
			heavy = child;
			cost = costINX[curr][i];
		}
	}
	/**
	 * foreward to heavy child path
	 **/
	if(heavy != -1) HLD(heavy, curr, G, costINX, cost);
	/**
	 * choose another heavy path
	 **/
	 for(unsigned i = 0; i < G[curr].size(); i++){
		 int child = G[curr][i];
		 if (child == prev || heavy == child) continue;
		 ++chainNo;
		 HLD(child, curr,G, costINX,cost);
	 }
	
}

/**
 * Lowest Common Ancestor
 */
int LCA(int u, int v){
	if(depth[u] > depth[v]) swap(u, v);
	if(depth[u] != depth[v]){
		for(int i = LOG-1; i>= 0; i--){
			if(depth[up[v][i]] >= depth[u]) v = up[v][i];
		}
	}
	if(u == v) return u;
	for(int i = LOG-1; i>=0; i--){
		if(up[v][i] != up[u][i]) v = up[v][i], u = up[u][i];
	}
	return up[v][0];
}

/**
 * build segment according to base
 **/
 
 void build(int node, int L, int R){
	 if(L == R){
		SGMNT[node] =make_pair(base[L], base[R]);
		return; 
	 }
	 int mid = (L + R) >> 1;
	 build(node << 1, L, mid);
	 build(node << 1|1, mid + 1, R);
	 ii left = SGMNT[node << 1];
	 ii right = SGMNT[node << 1 | 1];
	 int sum = left.F + right.F;
	 SGMNT[node] = make_pair(sum, max(sum, max(left.S, right.S)));
 }

/**
 * query to segment tree to look for consecutive summation
 **/
 
ii query(int node, int s, int e, int L, int R){
     if(s > R  || e < L) return make_pair(0, INT_MIN);
     if( s <= L && R<= e) return SGMNT[node];
     int mid = (L + R) >> 1;
     ii left = query(node << 1, s, e, L, mid);
     ii right = query(node << 1 | 1, s, e, mid +1, R);
     int sum = left.F + right.F;
     return make_pair(sum, max(sum, max(left.S,right.S)));
}

/**
 * update sign of all values
 */
void update(int node, int s,int e, int L, int R){
	if(s > R || e < L) return;
	if(L == R){
		SGMNT[node].S = SGMNT[node].F  *= -1; 
		return;
	}
	int mid = (L + R) >> 1;
	update(node << 1 , s, e, L, mid);
	update(node << 1 | 1, s, e, mid+1, R);
	int sum = SGMNT[node << 1] . S + SGMNT[node << 1 | 1].S;
	SGMNT[node] = make_pair(sum,max(sum, max(SGMNT[node << 1].S, SGMNT[node << 1 | 1].S)));
}

void query(int u, int v, int L, int R,char action, int &ans){
	if(depth[u] > depth[v])swap(u,v);
	int uChain = chain[u], vChain=chain[v];
	while(true){
		if(uChain == vChain){
			
			if(action == '?'){
			ii temp = query(1,pos[u], pos[v], L,R);
			ans = max(ans,max(temp.F, temp.S));
			}else{
				update(1, pos[u], pos[v], L, R);
			}
			
			return;
		}
		if(depth[u] > depth[v])swap(u,v);
		int head = chainHead[chain[u]];
		v = up[head][0];
		vChain = chain[v];
		if(action == '?'){
		ii temp = query(1, pos[head], pos[u], L, R);
		ans = max(ans, max(temp.F, temp.S));
		int cost = base[pos[v]];
		ans = max(ans, max(temp.F+cost, cost));
		}else{
			update(1, pos[head], pos[u], L, R);
			base[pos[v]] *= -1;
		}
	}
}

























