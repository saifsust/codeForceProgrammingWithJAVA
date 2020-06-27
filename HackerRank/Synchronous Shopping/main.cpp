#include<bits/stdc++.h>
using namespace std;

typedef pair<int, int > pii;
typedef pair < int , pii> pp;
typedef vector<pp>vpp;
const int maxNaN = 1033;
const int INF = 1e8;

vpp roads[maxNaN];
int cost[maxNaN][maxNaN], fishes[maxNaN];
int n,m,k;


void reset(){
	for(int i = 1; i<= n; i++){
		for(int j = 0; j<= 1<<k; j++){
			cost[i][j] = INF;
		}
	}
}

void min_self(int &a, int b){
	a = min(a, b);
}
int cal(pii source){
	queue<pp> q;
	q.emplace(make_pair(1, source));
	reset();
	cost[1][source.second] = 0;
	
	while(!q.empty()){
		pp pnt = q.front();
		q.pop();
		for( const auto &child : roads[pnt.first]){
			int d = cost[pnt.first][pnt.second.second] + child.second.first;
			int fish = pnt.second.second | child.second.second;
			if(d < cost[child.first][fish]){
				cost[child.first][fish] = d;
				q.emplace(child.first, make_pair(child.second.first, fish));
			}
		}
	}
	
	int lmt = 1 << k;
	int best = INF;
	for(int i = 0; i<=lmt; i++){
		for(int j = i; j<= lmt; j++){
			if((i|j) == lmt - 1){
			   min_self(best, max(cost[n][i], cost[n][j]));
			}
		}
	}
	return best;
}


int main(){
	ios::sync_with_stdio(false);
	cin.tie(0);
	freopen("in.txt", "r", stdin);
	
	cin>> n>> m>> k;
	int x;
	memset(fishes, 0 , sizeof fishes);
	for(int i = 1 ; i<= n; i++){
		cin>> x;
		for(int j = 1; j<= x; j++){
			int fish;
			cin>> fish;
			if(fish)
			fishes[i] |= 1 << (fish-1);
		}
	}
	int u, v, w;
	for(int i = 1; i<= m; i++){
		cin>>u>>v>>w;
		roads[u].emplace_back(v, make_pair(w, fishes[v]));
		roads[v].emplace_back(u, make_pair(w, fishes[u]));
	}
	
	 cout<< cal(make_pair(0, fishes[1])) << endl;
	
	return 0;
}
