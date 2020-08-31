#include<bits/stdc++.h>
using namespace std;

#define fast ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
#define fin  freopen("in.txt", "r", stdin)
#define fout freopen("out.txt","w", stdio)
#define F first
#define S second

const int NINF = INT_MIN;

typedef vector<int>vi;
typedef vector<vi>vvi;

const int LOG = 15;
const int N = 1e4+3;

int chainHead[N], depth[N], subtree[N], pnt[N], containChainNo[N], baseArray[N], baseArrayPos[N], segmentTree[3*N], edgeEndNode[N];
int up[N][LOG], chainNo, baseArrayInd, ans = NINF;

/**
 *  prototype declaration
 **/

void dfs(int source, int root ,vvi const &G, vvi const  &C);
void HLD(int curr_node, int cost, int prev_node, vvi const &G, vvi const &C);
int  query(int s, int e, int node, int L, int R);
void max_self(int &a, int b);
void query(int u, int v);
void update(int in, int val, int node, int L, int R);
void query_hld(int u, int v, int n);
void change(int i, int val, int n);

/**
 * assign all Nodes according to node weight 
 **/

void dfs(int source, int root, vvi const &G, vvi const &edgeIndex){
	up[source][0] = root;
	for(int i = 1; i<LOG; i++){
		up[source][i] = up[up[source][i-1]][i-1];
	}
	subtree[source] = 1;
	for(int i = 0; i<(int)G[source].size(); i++){
		int child = G[source][i];
		if(child == root) continue;
		edgeEndNode[edgeIndex[source][i]] = child;
		pnt[child] = source, depth[child] = depth[source] + 1;
		dfs(child, source , G, edgeIndex);
		subtree[source] += subtree[child];
	}
}

/**
 * heavy light decompose  save node weight in base array, numbered chain 
 **/


void HLD(int curr_node, int cost, int prev_node, vvi const &G, vvi const &C){
	if(chainHead[chainNo] == -1) chainHead[chainNo]=curr_node;
	containChainNo[curr_node]=chainNo;
	baseArrayPos[curr_node]=baseArrayInd;
	baseArray[baseArrayInd++]=cost;
	//cerr << curr_node << " " << chainNo << endl;
	int heavy_child = -1;
	int nCost = 0;
	
	/**
	 * looking for heavy child
	 **/
	
	for(int i = 0; i<(int) G[curr_node].size(); i++){
		int child = G[curr_node][i];
		if(child == prev_node) continue;
		//cerr << child << endl;
	    if(heavy_child == -1 || subtree[heavy_child] < subtree[child]){
			heavy_child = child;
			nCost = C[curr_node][i];
		}	
	}
	
	/**
	 * heavy path traverse
	 **/
	 
	if(heavy_child != -1){
		HLD(heavy_child, nCost, curr_node, G, C);
	}
	
	/**
	 * Looking for next chain
	 **/
	for(int i = 0; i< (int) G[curr_node].size(); i++){
		int child = G[curr_node][i];
		if(child == pnt[curr_node] || child == heavy_child) continue;
		chainNo++;
		HLD(child, C[curr_node][i], curr_node, G, C);
	}
}

void max_self(int &a, int b){
	a = max(a, b);
}

/**
 * Looking for LCA 
 **/
int LCA(int u, int v){
	if(depth[u] > depth[v]) swap(u, v);
	if(depth[u] != depth[v])
		for(int i = LOG -1; i>= 0; i--)
			if(depth[up[v][i]] >= depth[u]) v = up[v][i];
	
	if(u == v) return u;
	
	for(int i = LOG -1; i>=0; i--){
		if(up[v][i] != up[u][i]) v = up[v][i], u = up[u][i];
	}
	return up[u][0];
}



/**
 * build segment tree
 **/
 
 void build(int s, int e, int node){
	 if(s==e){
		 segmentTree[node] = baseArray[s];
		 return;
	 }
	 int mid = (s + e) >> 1;
	 build(s, mid, node << 1);
	 build(mid + 1, e, node << 1 | 1);
	 segmentTree[node] = max(segmentTree[node << 1], segmentTree[node << 1 | 1]);
	 return;
 }
 
 /**
  * query segment tree for max edge 
  **/
  
int query(int s, int e, int node, int L, int R){
	if(e< L || s > R) return -1;
	if( s<= L &&  R <= e) return segmentTree[node];
	
	int mid = (L+R) >> 1;
	
	int left = query(s, e, node << 1, L, mid);
	int right = query(s, e, node << 1 | 1, mid + 1, R);
	return max(left, right);
}

/**
 * query maximum edge  
 **/
 
void query(int u, int v, int n){
	int lca = LCA(u, v);
	ans = NINF;
	query_hld(u, lca, n);
	query_hld(v, lca, n);
	printf("%d\n", ans);
	
}

/**
 * Heavy light decompose tree query
 **/
 
void query_hld(int u, int v, int n){
	if(u==v) return;
	if(depth[u] > depth[v]) swap(u,v);
	int uChainNo = containChainNo[u], vChainNo = containChainNo[v];
	while(true){
		if(uChainNo == vChainNo){
			if(u== v) break;
		     int result = query(baseArrayPos[u] +1, baseArrayPos[v], 1, 1, n);
		      max_self(ans, result);
		      break;
		}
		if(depth[u] > depth[v]) swap(u, v);
		int head = chainHead[vChainNo];
		int result = query(baseArrayPos[head]+1, baseArrayPos[v], 1, 1, n);
		max_self(ans, result);
		max_self(ans, baseArray[baseArrayPos[head]]);
		v = pnt[head];
		vChainNo = containChainNo[v];
	}
}

/**
 *  update egde val
 **/

void update(int in, int val, int node, int L, int R){
	if(L==R){
	 segmentTree[node] = baseArray[in] = val;
	 return;
	}
	int mid = (L+R) >> 1;
	if(in <= mid) update(in, val, node << 1, L, mid);
	else update(in, val, node << 1 | 1, mid + 1, R);
	segmentTree[node] = max(segmentTree[node << 1] , segmentTree[node << 1 | 1]);
	return;
}

/**
 * change ith value of the edge
 **/
 void change(int in, int val, int n){
	 in = baseArrayPos[edgeEndNode[in-1]];
	 update(in, val, 1, 1, n);
 }

int main(int argc, char *argv[]){
	fast;
	//fin;
	int test;
	scanf("%d", &test);
	for(int tt = 1; tt<= test; tt++){
		int n, u, v, c;
		scanf("%d", &n);
		vvi G(n+1), C(n+1), edgeIndex(n+1);
		for(int i = 0; i<n-1;i++){
			scanf("%d%d%d", &u, &v, &c);
			G[u].push_back(v);
			G[v].push_back(u);
			C[u].push_back(c);
			C[v].push_back(c);
			edgeIndex[u].push_back(i);
			edgeIndex[v].push_back(i);
			
			/**
			 * reset
			 **/
			chainHead[u]=chainHead[v] = -1;
			baseArrayPos[u] = baseArrayPos[v] = 0;
			subtree[u] = subtree[v] = 0;
			containChainNo[u] = containChainNo[v] = 0;
			
		}
		depth[1] = 0;
		pnt[1] = -1;
		chainNo = 0;
		baseArrayInd = 0;
		
		dfs(1,1,G, edgeIndex);
		HLD(1, -1, 1, G, C);
		build(1, n, 1);
		char cmd[100];
		while(scanf("%s", cmd)){
			if(cmd[0] == 'D') break;
			if(cmd[0] == 'Q'){
				scanf("%d%d", &u, &v);
				assert(1<= u && u<= n);
				assert(1 <= v && v <= n);
				query(u,v, n);
			}
			if(cmd[0] == 'C'){
				int in, val;
			    scanf("%d%d", &in, &val);
			    assert(1 <= in && in <= n);
				change(in, val, n);
			}
		}
		
		
	}
		
	
	return 0;
}
