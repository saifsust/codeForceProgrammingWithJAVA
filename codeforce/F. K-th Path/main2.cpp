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
typedef pair <long long , pair<int, ii>> ppp;
typedef priority_queue<ppp, vector<ppp> , greater<ppp> > pq;
typedef vector<li>vli;
typedef vector<vli>vvli;
typedef vector<int>vi;
typedef set<ii>sii; 
const long long INF = LONG_LONG_MAX;
const int N = 2e5+5;
int n,m,k;

void dijkstra(vvli &G){
	pq Q;
	sii used;
	for(int i = 1; i<=n; i++){
		Q.PS(MP(G[i][0].F, MP(0, MP(i,i))));
		used.emplace(i,i);
	}	
	k*=2;
	while(!Q.empty()){
		ppp pnt = Q.top(); Q.pop();
		long long w = pnt.F;
		int index = pnt.S.F;
		int start = pnt.S.S.F;
		int dest = pnt.S.S.S;
		int next = G[dest][index].S;
		//cerr << "PNT ";
		//cerr << start << "  " << dest << " " << " i " <<index << " " << w << endl;
		if(index + 1 < (int) G[dest].size()){
			long long next_w = w - G[dest][index].F + G[dest][index + 1].F;
			Q.PS(MP(next_w, MP(index + 1, MP(start, dest))));
		}
	    if(!used.count(MP(start, next))){
		   used.emplace(start,next);
		   cerr << "visited ";
		   cerr << start << " " << next << " " << w << endl;
		   k--;
		   if(!k){
			   cout << w << endl;
			   return;
		   }
		   Q.PS(MP(w+G[next][0].F,MP(0,MP(start,next))));
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
