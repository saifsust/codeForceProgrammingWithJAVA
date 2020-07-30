#include<bits/stdc++.h>
using namespace std;

#define node second
#define wght  first

typedef pair<int,int>ii;
typedef priority_queue< ii, vector<ii>, greater<ii> > pq;
typedef vector<ii>vii;
typedef vector<vii>vvii;

const int N = 505;
const int INF = INT_MAX;

int dist[N+3];

void dijkstra(int ss, vvii &G){
	fill(dist, dist+N, INF);
	dist[ss] = 0;
	pq Q;
	Q.emplace(0, ss);
	while(!Q.empty()){
		const auto root = Q.top(); Q.pop();
		for(const auto &next : G[root.node]){
			int d =  dist[root.node] + next.wght;
			if(d < dist[next.node]){
				dist[next.node] = d;
				Q.emplace(d, next.node);
			}
		}
	}
}




int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int n ;
	assert(cin >> n);
	vvii G(N);
	int u,v,w;
	for(int i = 0; i<n;i++){
		assert(cin >> u >> v >> w);
		assert(0 <= u && u<= 500);
		assert(0<= v && v <= 500);
		G[u].emplace_back(w, v);
		G[v].emplace_back(w, u);
	}
	
	int ss;
	assert(cin >> ss);
	assert(0<=ss && ss <= 500 );
	dijkstra(ss, G);
	int qry;
	assert(cin >> qry);
	for(int q = 1; q <= qry; q++){
		int tt;
		assert(cin >> tt);
		assert(0<= tt && tt<= 500);
		if(dist[tt] == INF){
			cout << "NO PATH" << endl;
			continue;
		}
		cout << dist[tt] << endl;
	}
	
	return 0;
}
