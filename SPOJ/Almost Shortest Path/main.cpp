#include<bits/stdc++.h>
using namespace std;
#define F first
#define S second
#define mp make_pair
#define pb push_back

typedef pair <int, int > ii;
typedef vector<ii>vii;
typedef vector<vii>vvii;
typedef set<int>si;
typedef priority_queue<ii, vii, greater<ii> > pq;

const int N = 501;
const int INF = INT_MAX;

int used[N][N], dist[N],n, m;


void dijkstra(vvii &G, int ss, si path[]){
	pq Q;
	Q.emplace(0, ss);
	for(int i = 0; i<N; i++) dist[i] = INF;
	dist[ss] = 0;
	path[ss].insert(-1);
	while(!Q.empty()){
		const auto root = Q.top(); Q.pop();
		for(const auto &next : G[root.S]){
			int d = dist[root.S] + next.F;
			if(d <= dist[next.S] && !used[root.S][next.S]){
				if(dist[next.S] == d) path[next.S].insert(root.S);
				else {
					path[next.S].clear();
					path[next.S].insert(root.S);
				}
				dist[next.S] = d;
				Q.emplace(d, next.S);
			}
		}
	}
	
}

void dfs(int tt, si path[]){
	//cerr << tt << " ";
	for(const auto &next : path[tt]){
		if(next != -1){
		   used[next][tt] = true;
		   dfs(next, path);
		}
	}
}

void solve(vvii &G, int ss, int tt){
	si path[N];
	for(int i = 0; i<N; i++) memset(used[i], false, sizeof used[i]);
	
	dijkstra(G, ss, path);
	dfs(tt, path);
	dijkstra(G, ss, path);
    int ans = dist[tt] == INF ? -1 : dist[tt];
    cout << ans << endl;
}

int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int ss,tt, u, v, w;
	while(cin >> n >> m){
		if(!n&!m) break;
		assert(cin >> ss >> tt);
	    vvii G(n);
		for(int i = 0; i<m; i++){
			assert(cin >> u >>v >> w);
			assert(0<= u && u<n);
			assert(0<=v && v<n);
			G[u].emplace_back(w,v);
		}
	   solve(G, ss, tt);
    }
	
	return 0;
}
