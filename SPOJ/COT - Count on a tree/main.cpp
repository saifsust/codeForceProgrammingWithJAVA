#include<bits/stdc++.h>

using namespace std;

#define fastio ios::sync_with_stdio(false);cin.tie(0); cout.tie(0);
#define F first
#define S second
#define ALL(a) (a).begin(), (a).end()

typedef vector<int> vi;
typedef vector<vi>vvi;

const int N = 1e5+5;
const int LOG = 20;
const int INF = INT_MAX;

int up[N][LOG],pnt[N],depth[N], chainHead[N], chainNoContainer[N],chainNo = 0, baseArray[N],pos[N], baseArrayIn = 0, subtreeSize[N];

/**
 * prototype
 **/
 void DFS(int source , int root, vvi const &G){
	 up[source][0] = root;
	 for(int i = 1; i<LOG; i++){
		 up[source][i] = up[up[source][i-1]][i-1];
	 }
	 subtreeSize[source] = 1;
	 for(const int child : G[source]){
		 if(child == root) continue;
		 depth[child] = depth[source] + 1, pnt[child] = source;
		 DFS(child, source, G);
		 subtreeSize[source] += subtreeSize[child]; 
	 }
 }
 
/**
 * Heavy Light Decomposition
 **/
 void HLD(int source, int prevNode , int cost, vvi const &G, int *costs){
	// cerr << "SR " << source <<" PREV " << prevNode << endl;
	 if(chainHead[chainNo] == -1) chainHead[chainNo]=source;
	 chainNoContainer[source]=chainNo;
	 pos[source]=baseArrayIn;
	 baseArray[baseArrayIn++]=cost;
	 int heavyNode = -1, nCost=0;
	 /**
	  * Looking for heavy child
	  **/
	 for(int i = 0; i< (int) G[source].size(); i++){
		 int child = G[source][i];
		 if(child == prevNode) continue;
		 if(heavyNode == -1 || subtreeSize[child] > subtreeSize[heavyNode]){
			 heavyNode = child;
			 nCost= costs[child];
		 }
	 }	 
	 /**
	  * traverse heavy chain
	  **/
	  if(heavyNode != -1){
		  HLD(heavyNode,source,nCost, G, costs);
	  }
	  /**
	   * Looking for next chain 
	   **/
	   for(const int child : G[source]){
		   if(child == prevNode || child == heavyNode) continue;
		   chainNo++;
		   HLD(child, source ,costs[child], G, costs);
	   }
 }

int LCA(int u, int v){
	if(depth[u] > depth[v]) swap(u,v);
	if(depth[u] != depth[v]){
		for(int i = LOG-1; i>=0; i--){
			if(depth[up[v][i]] >= depth[u]) v = up[v][i];
		}
	}
	if(u == v) return u;
	for(int i = LOG-1; i>= 0; i--){
		if(up[v][i] != up[u][i]) v = up[v][i], u = up[u][i];
	}
	return up[u][0];
}

void query_HLD(int u, int lca, int v, vi  &list){
	if(depth[u] > depth[v]) swap(u,v);
	int uChainNo = chainNoContainer[u], vChainNo = chainNoContainer[v];
	
	while(true){
		//cerr << "uchainNo " << uChainNo << " vChainNo " << vChainNo << endl; 
		if(uChainNo == vChainNo){
			if(u==v) break;
			for(int node = v; node != lca && node != pnt[u] ; node = pnt[node]) list.push_back(baseArray[pos[node]]);			
			//for(int i = pos[v] ; i>=pos[u]; i--) list.push_back(baseArray[i]);
			//cerr << "Node " << u << " " << v << endl;
			//cerr << "Pos " << pos[u] << " " << pos[v] << endl; 
			break;
		}
	  if(depth[u] > depth[v]) swap(u, v);
	  int head = chainHead[vChainNo];
	  //cerr << "Head "<< head << " v " << v << " u "<< u <<endl;
	  //cerr << "POS " << pos[head] << " "<< pos[v]<<endl;
	  //cerr << "PNT " << up[head][0]<< endl;
	  for(int node = v; node != lca && node != pnt[head]; node = pnt[node]) list.push_back(baseArray[pos[node]]);
	  //for(int i = pos[v]; i>= pos[head]; i--) list.push_back(baseArray[i]);
	  v = up[head][0];
	  vChainNo = chainNoContainer[v]; 
	}
	
} 

void debug(vi list){
	for(const int val : list) cerr << val << " ";
	cerr << endl;
}

void query(int u, int v, int kth){
	if(depth[u] > depth[v]) swap(u,v);
	int lca = LCA(u, v);
	//cerr << "LCA "<< lca << endl;
	vi list;
	list.clear();
	query_HLD(u,lca, lca, list);
	list.push_back(baseArray[pos[lca]]);
	//debug(list);
	query_HLD(v, lca, lca, list);
	//debug(list);
	sort(ALL(list));
	//debug(list);
	if(kth<=(int)list.size()) printf("%d\n", list[kth-1]);
}


int main(int argc, char *argv[]){
	fastio;
	
	int n,m, u,v,k;
	scanf("%d%d", &n, &m);
	vvi G(n+1);
	int costs[n+1];
	
	for(int i = 1; i<=n; i++){
		scanf("%d", &costs[i]);
	}
	
	for(int i = 1; i<= n-1; i++){
		scanf("%d%d", &u, &v);
		assert(1<= u && u<=n);
		assert(1<= v && v<=n);
		G[u].push_back(v);
		G[v].push_back(u);
	}
	pnt[1] = 0;
	depth[1] = subtreeSize[1]=0;
	DFS(1, 1, G);
	memset(chainHead, -1, sizeof(chainHead));
	chainNo = 0, baseArrayIn = 0;
	HLD(1, 1, costs[1], G, costs);
	//for(int i = 0; i<=baseArrayIn; i++) cerr << baseArray[i] << " ";
	//cerr << endl;
	for(int q = 1; q<= m; q++){
		scanf("%d%d%d", &u, &v, &k);
		assert(1<= u && u<= n);
		assert(1<= v && v<= n);
		assert(1<=k);
		query(u, v, k);
	}
	
	return 0;
}
