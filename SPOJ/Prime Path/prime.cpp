#include<bits/stdc++.h>
using namespace std;
#define F first
#define S second

typedef vector<int>vi;
typedef vector<vi>vvi;
typedef pair<int,int>ii;
typedef priority_queue<ii, vector<ii>, greater<ii> > pq;

const int  N = (int)1e4;
const int INF = 1e8;
const int LOG = 20;
bool isPrime[N];
vi primes;
vvi G(N);
int dist[N];

void seive(){
	int sqrtN = (int)sqrt(N);
	for(int i = 3; i<N; i+=2){
		if(!isPrime[i]){
			if(i<=sqrtN){
				for(int j = i*i; j<N; j+=i*2) isPrime[j] = true;
			}
			if(i >=1000) primes.push_back(i); 	
		}
	}
}

bool isChild(int a, int b){
	int cnt = 0;
	while(a){
		if(a % 10 != b % 10) ++cnt;
		a/=10;
		b/=10;
	}
	return cnt == 1 ? true : false ;
}

void build(){
	
	for(int i = 0; i<(int)primes.size(); i++){
		int pnt = primes[i];
		for(int j = i +1; j<(int) primes.size(); j++){
			if(isChild(pnt,primes[j])){
				G[pnt].push_back(primes[j]);
				G[primes[j]].push_back(pnt);
			}
		}
	}
}

int dijkstra(int ss, int tt){
	fill(dist, dist + N, INF);
	dist[ss] = 0;
	pq q;
	q.emplace(0, ss);
	while(!q.empty()){
		ii root = q.top(); q.pop();
		for(const int next : G[root.S]){
			int d = dist[root.S] + 1;
			if(d < dist[next]){
				dist[next] = d;
				q.emplace(d, next);
			}
		}
	}
	return dist[tt] ;
}


int main(int argc, char *argv[]){	
	seive();
	build();
	int test, u, v;
	assert(cin >> test);
	for(int tst = 1; tst <= test; tst++){
		assert(cin >> u >> v);
		if(u==v){
			cout << 0<<endl;
			continue;
		}
		cout << dijkstra(u,v) << endl;
	}
	return 0;
}
