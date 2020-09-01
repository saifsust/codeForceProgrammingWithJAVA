#include<bits/stdc++.h>
using namespace std;

#define fasterio ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define N 10010
#define LOG 15
#define F first
#define S second
#define ALL(a) (a).begin(),(a).end()

typedef pair<int ,int>ii;
typedef vector<ii>vii;
typedef vector<vii>vvii;
typedef vector<int> vi;

int pnt[LOG][N], chainHead[N],nodes[N], nodesIn[N], segmentTree[3*N],containerChainNo[N],dist[N], depth[N], subtree[N];
int nodeCounter, chainNo;
/**
 * prototypes
 **/
void DFS(int source, int root, vvii const &G);
void HLD(int source, int head, vvii const &G);
int LCA(int u, int v);
void query(int u, int v, vi &path);
void query(int u, int v,int kth);
void query(int u, int v);
/**
 *  DFS for lca and subtree size
 **/
 
void DFS(int source, int root, vvii const &G){
	pnt[0][source] = root;
	for(int i = 1; i<LOG; i++){
		pnt[i][source] = pnt[i-1][pnt[i-1][source]];
	}
	subtree[source] = 1;
	for(const auto child : G[source]){
		if(child.S == root) continue;
		depth[child.S] = depth[source] + 1;
		dist[child.S] = dist[source] + child.F;
		DFS(child.S, source , G);
		subtree[source] += subtree[child.S];
	}
}

/**
 * Heavy light decomposition 
 **/

void HLD(int source , int prev , vvii const &G){
	if(chainHead[chainNo] == -1) chainHead[chainNo]=source;
     containerChainNo[source] = chainNo;
     int heavy_child = -1;
     //cerr << "SRC " << source << " prev " << prev <<" chainNo " << chainNo << endl;
     /**
      *  Looking for heavy child 
      **/
     for(const auto next : G[source]){
		 if(next.S == prev) continue;
		 if(heavy_child == -1 || subtree[heavy_child] < subtree[next.S]){
			 heavy_child = next.S;
		 }
	 }
	 /**
	  * traverse heavy path
	  **/
	 if(heavy_child != -1){
		 HLD(heavy_child, source, G);
	 }
	 
	 /**
	  * Looking for next chain
	  **/
	 for(const auto child : G[source]){
		 if(child.S == prev|| child.S == heavy_child) continue;
		// cout << source << " " << pnt[0][source] << endl;
		 chainNo++;
		 HLD(child.S, source, G);
	 }
	 
}
 
/**
 * LCA implementation 
 **/
  
  int LCA(int u, int v){
	  if(depth[u] > depth[v]) swap(u, v);
	  
	  if(depth[u] != depth[v]){
		  for(int i = LOG -1; i>= 0; i--){
			  if(depth[pnt[i][v]] >= depth[u]) v = pnt[i][v];
		  }
	  }
	  
	  if(u == v) return u;
	  
	  for(int i = LOG - 1; i>= 0; i--){
		  if(pnt[i][v] != pnt[i][u]) v = pnt[i][v], u=pnt[i][u];
	  } 
	  return pnt[0][u];
  }
  
/**
 * query to chain of HLD 
 **/
 
 void  query(int u, int v, vi &path){
	 
	 if(depth[u] > depth[v]) swap(u, v);
	 
	 int uChainNo = containerChainNo[u], vChainNo = containerChainNo[v];
	 while(true){
		 if(uChainNo == vChainNo){
			 if(u == v){
				 path.push_back(u);
				 break;
				}
				while(v != u){
					path.push_back(v);
					v = pnt[0][v];
				}
			 break;
		 }
		 
		 if(depth[u] > depth[v]) swap(u,v);
		 vChainNo = containerChainNo[v];
		 int head = chainHead[vChainNo];
		 while(v != head){
			 path.push_back(v);
			 v = pnt[0][v];
		 }
		 path.push_back(head);
		 v = pnt[0][head];
		 vChainNo = containerChainNo[v];
	 }
 }
 
/**
 * query  
 **/
 
 void debug(vi path){
	 for(const int p : path) cerr << p << " ";
	 cerr << endl;
 }
 
 void query(int u, int v, int kth){
	  vi path;
	  path.clear();
	 int lca = LCA(u,v);
	 query(u, lca, path);
	 
	 if(kth <= (int) path.size()){
		 cout << path[kth-1] << endl;
		 return;
	 }
	 kth -= (int) path.size();
	 path.clear();
	 query(v,lca, path);
	 reverse(ALL(path));
	 cout << path[kth-1] << endl;
 }
 
 void query(int u, int v){
     
     int lca = LCA(u, v);
     //cerr << "LCA " << lca << endl;
     int d= dist[u] + dist[v] - (dist[lca] << 1);
     cout << d << endl;
 }

int main(int argc, char *argv[]){
	fasterio;
	
	int test;
	scanf("%d", &test);
	
	for(int tt = 1; tt <= test; tt++){
		int n, u, v,c;
		scanf("%d", &n);
		vvii G(n+1);
		for(int i = 0; i<n-1; i++){
			scanf("%d%d%d", &u, &v, &c);
			assert(1 <= u && u<= n);
			assert(1<= v && v <= n);
			
			G[u].emplace_back(c, v);
			G[v].emplace_back(c, u);
			/**
			 * reset
			 **/
			chainHead[u]=chainHead[v] = -1;
			subtree[u]=subtree[v] = 0;
			depth[u] = depth[v] = 0;
			dist[u]=dist[v] = 0;
		}
		
		depth[1] =0;
		chainNo = 0;
		dist[1] = 0;
		DFS(1, 1, G);
		HLD(1,1, G);
		char cmd[100];
		
		while(scanf("%s", cmd)){
			if(cmd[0] == 'D' && cmd[1] == 'O') break;
			if(cmd[0] == 'D' && cmd[1] == 'I'){
				scanf("%d%d", &u, &v);
				assert(1 <= u && u<= n);
				assert(1<= v && v <= n);
				query(u, v);
			}
			if(cmd[0] == 'K'){
				scanf("%d%d%d", &u, &v, &c);
				assert(1 <= u && u<= n);
				assert(1<= v && v <= n);
				query(u,v,c);
			}
			
		}
		
		
		
		
	}
	
	return 0;
}
