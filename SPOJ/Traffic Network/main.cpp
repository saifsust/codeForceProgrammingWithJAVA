#include<bits/stdc++.h>
using namespace std;
#define w first
#define nd second.first
#define in second.second
#define mp make_pair


typedef pair<int,int>ii;
typedef pair<int , ii > iii;
typedef vector<ii>vii;
typedef vector<vii>vvii;
typedef priority_queue<iii, vector<iii>, greater<iii> > pq;
typedef set<int>si;

const int N  = 1e4+5;
const int INF = INT_MAX;
const int LOG = 15;

int dist[N][2], ans;

void dijkstra(vvii &G , vvii &B, int ss){
	pq Q;
	Q.emplace(0, mp(ss, 0));
	dist[ss][0] =0;
	while(!Q.empty()){
		const auto  top = Q.top(); Q.pop();
		int root = top.nd;
		int inn = top.in;
		for(const auto &next : G[root]){
		   int d = dist[root][inn] + next.w;
		   if(d < dist[next.second][inn]){
			   dist[next.second][inn] = d;
			   Q.emplace(d, mp(next.second,inn));
		   }
		}
		if(inn == 1) continue;
		
		for(const auto next : B[root]){
			int d = dist[root][0] + next.w;
			if(d < dist[next.second][1]){
				dist[next.second][1] = d;
				Q.emplace(d, mp(next.second, 1));
			}
		}
	}
		
	
}

void min_self(int &a, int b){
	a = min(a,b);
}

int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int test;
	assert(cin >> test);
	for(int  t = 1; t<= test; t++){
		int n, m,k,ss,tt;
		assert(cin >> n >> m >> k >> ss >> tt);
		assert(2<= n && n<=10000);
		assert(1<= ss && ss <= n);
		assert(1<= tt && tt <= n);
		int u,v,w;
		vvii G(n+1);
		for(int i = 0; i<m; i++){
			assert(cin >> u >> v >> w);
			G[u].emplace_back(w, v);
			dist[u][0]=dist[u][1]=dist[v][0]=dist[v][1]=INF;
		}
		vvii B(n+1);
		for(int i = 1; i<= k ; i++){
			assert(cin >> u >> v >> w);
			assert(1<= u && u<=n);
			assert(1 <= v && v <= n);
			B[u].emplace_back(w,v);
			B[v].emplace_back(w,u);
		}
		dist[tt][0] = dist[tt][1] = INF;
		dijkstra(G, B,ss);
        ans = INF;
        min_self(ans, min(dist[tt][0], dist[tt][1]));
        ans = ans == INF ? -1 : ans;
        cout << ans << endl;
	}
	
	return 0;
}
