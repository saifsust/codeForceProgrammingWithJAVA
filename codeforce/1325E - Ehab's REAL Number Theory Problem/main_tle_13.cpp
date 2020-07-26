#include<bits/stdc++.h>
using namespace std;
#define pb push_back
#define mp make_pair
#define ep emplace
#define F first
#define S second

typedef pair<int,int>ii;
typedef  vector<int>vi;
typedef vector<vi>vvi;
typedef queue<pair<long long ,ii>> qpair;
typedef set<int>si;
const int N = 1e6+5;
const long long INF = LONG_LONG_MAX;

int max_divs[N], n, a, good;
long long ans,dist[N];
vi primes, divs[N];
vvi G;
bool visited[N];
si start;

void seive(){
	//memset(max_divs, 0, sizeof max_divs);
	primes.pb(1);
	for(int i = 2; i<N; i++){
		if(!max_divs[i]){
			for(int j = i; j<N; j+=i) max_divs[j] = i;
			primes.pb(i);
		}
		divs[i] = divs[i/max_divs[i]];
		auto it = find(divs[i].begin(), divs[i].end(), max_divs[i]);
		if(it !=  divs[i].end()) divs[i].erase(it);
		else divs[i].pb(max_divs[i]);
	}
}

void max_self(int &a,int b){
	a=max(a,b);
}

void min_self(long long &a, long long b){
	a = min(a,b);
}


void dijkstra(int p){
	for(auto prm : start){
		visited[prm] = false;
		dist[prm] = 0;
	}
    qpair Q;
    Q.ep(0,mp(p,p));
    while(!Q.empty()){
		auto root = Q.front(); Q.pop();
		//cerr <<"s "<< root.S.F << " p " << root.S.S << " d " << root.F << endl;
		long long  d = root.F;
		int ss = root.S.F;
		int pnt = root.S.S;
		dist[ss] = d;
		visited[ss] = true;
		bool singleLoop = false;
		for(const int next : G[ss]){
			if(next !=  pnt || singleLoop){
				if(!visited[next]){
					Q.ep(dist[ss] + 1,mp(next,ss));
				}else{
					min_self(ans, dist[ss] + dist[next] + 1);
				}
			}else singleLoop = true;
		}
	}
}

int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	seive();
	assert(cin >> n);
	good = 0;
	G.resize(N);
	for(int i = 1; i<= n; i++){
		assert(cin >> a);
		max_self(good, a);
		if(divs[a].empty()){
			cout << 1 << endl;
			return 0;
		}
		if(divs[a].size() == 1) divs[a].pb(1);
		start.insert(divs[a][0]);
		start.insert(divs[a][1]);
		G[divs[a][0]].pb(divs[a][1]);
		G[divs[a][1]].pb(divs[a][0]);
	}
	ans = INF;
	for(const auto p : start){
		if(p*p > good) break;
		dijkstra(p);
	}
	if(ans == INF) cout << -1 << endl;
	else cout << ans << endl;
	return 0;
}
