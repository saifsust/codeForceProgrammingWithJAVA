#include<bits/stdc++.h>
using namespace std;
#define w first
#define nd second

typedef pair<int,int>ii;
typedef vector<ii>vii;
typedef vector<vii>vvii;
typedef priority_queue<ii, vector<ii>, greater<ii> > pq;

const int N  = 1e4+5;
const int INF = INT_MAX;
const int LOG = 15;

void dijkstra(const int ss, const vvii &G ,long long *dist){
	pq Q;
	Q.emplace(0, ss);
	dist[ss] = 0;
	while(!Q.empty()){
		const auto root = Q.top(); Q.pop();
		for(const auto &next : G[root.nd]){
			long long d = dist[root.nd] + next.w;
			if(d < dist[next.nd]){
				dist[next.nd] = d;
				Q.emplace(d, next.nd);
			} 
		}
	}
}


void min_self(long long &a, long long b){
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
		long long dist[n+2], dist2[n+2];
		vvii G(n+1), RG(n+1);
		for(int i = 0; i<m; i++){
			assert(cin >> u >> v >> w);
			G[u].emplace_back(w, v);
			RG[v].emplace_back(w,u);
		}
		
		for(int i = 1; i<=n; i++){
			dist[i] = dist2[i] = INF;
		}
		
		dijkstra(ss, G, dist);
		dijkstra(tt, RG, dist2); 
		
		long long ans = dist[tt];
		for(int i = 0; i<k; i++){
			assert(cin >> u >> v >> w);
			assert(1<=u && u<= n);
			assert(1<= v && v<= n);
			
			min_self(ans, min(dist[u] + w + dist2[v], dist2[u] + w + dist[v]));
		}
		ans  = ans >= INF ? -1 : ans;
		cout << ans << endl;
		
	}
	return 0;
}
