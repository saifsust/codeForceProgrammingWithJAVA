#include<bits/stdc++.h>
using namespace std;
#define F first
#define S second
#define MP make_pair
#define PB push_back
#define PS push
#define SZ(a) (a.size())
#define ALL(a) (a).begin(), (a).end()
typedef pair<int, int > ii;
typedef pair<long long,int>li;
typedef vector<li>vli;
typedef vector<vli>vvli;
typedef vector<int>vi;
typedef set<ii>sii; 
const long long INF = LONG_LONG_MAX;
const int N = 2e5+5;
int n,m,k;

struct Node{
	long long weight;
	int start, dest, index;
	Node(int s, int d, long long w, int i){
		start = s;
		dest = d;
		weight = w;
		index = i;
	}
	bool operator < (const Node &next) const{
		return weight > next.weight;
	};
};
typedef priority_queue<Node> pq;

void dijkstra(vvli &G){
	pq Q;
	sii used;
	for(int i = 1; i<=n; i++){
		Q.PS(Node(i,i, G[i][0].F, 0));
		used.emplace(i,i);
	}
	k*=2;
	int cnt = 1;
	while(!Q.empty()){
		Node curr = Q.top(); Q.pop();
		//cerr << "PNT ";
		//cerr << curr.start << " " << curr.dest << " " << curr.weight << endl;
		int next = G[curr.dest][curr.index].S;
		if(!used.count(MP(curr.start, next))){
			used.emplace(curr.start, next);
			cerr << "cnt: " << cnt << " visited ";
			cerr << curr.start << "  nxt " << next << " w " << curr.weight << " " << G[next][0].F<< endl;
			++cnt; 
			k--;
			if(k==0){
				cout << curr.weight << endl;
				return;
			}
			Q.PS(Node(curr.start, next, curr.weight + G[next][0].F, 0));
		}
		if((curr.index + 1) < (int) G[curr.dest].size()){
			//cerr << " Good friend ";
			//cerr << curr.index << " " << G[curr.dest].size() << endl;
			long long w = curr.weight - G[curr.dest][curr.index].F + G[curr.dest][curr.index + 1].F;
			Q.PS(Node(curr.start, curr.dest, w, curr.index + 1));
		}
	}
	
	
}


int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cerr.tie(0);
	assert(cin >> n >> m >> k);
	long long C;
	int A,B;
	vvli G(n+1);
	for(int i = 0; i<m; i++){
		assert(cin >> A >> B >> C);
		G[A].emplace_back(C, B);
		G[B].emplace_back(C, A);
	}
	for(int i = 1 ; i<= n; i++){
		sort(ALL(G[i]));
	} 
	dijkstra(G);
	return 0;
}
