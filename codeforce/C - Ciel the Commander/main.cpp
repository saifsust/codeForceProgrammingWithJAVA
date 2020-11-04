#include<bits/stdc++.h>
using namespace std;
				
#define FAST ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)
#define FIN freopen("in.txt", "r", stdin)

typedef vector<int>vi;
typedef vector<vi>vvi;
typedef vector<bool>vbl;
typedef pair<int,int>ii;

int getCentroid(int start , const vvi &g, const vbl &used);
void decompose(int start,const vvi &g);

int main(int argc, char *argv[]){
	FAST;
	//FIN;
	int n;
	assert(cin >> n);
	vvi g(n+2);
	int u,v;
	for(int i = 1; i<n; i++){
		assert(cin >> u >> v);
		g[u].push_back(v);
		g[v].push_back(u);
	}
	decompose(1, g);
	return 0;
}

void decompose(int n,const vvi &g){
	static vbl used(g.size()+1, false);
	int level[g.size()+1];
	memset(level, 0, sizeof(level));
	int mx = INT_MIN;
	vi ranks[g.size()+5];
	function<void (int, int)> decomposer = [&](int source, int parent){
		int centroid = getCentroid(source, g, used);
		//cout<< centroid << " ";
		if(parent == -1) parent = centroid;
		level[centroid] = level[parent] + 1;
		ranks[level[centroid]].push_back(centroid);
		mx = max(mx, level[centroid]);
		used[centroid] = true;
		for(const int next : g[centroid]){
			if(used[next]) continue;
			decomposer(next, centroid);
		}
	};
	decomposer(1, -1);
	map<int, char>mp;
	for(int i = 0; i<mx; i++){
		for(const int v : ranks[i+1]) mp[v]='A' + i;
	}
	for(auto v : mp) cout <<v.second<< " ";
	cout << endl;
	
}

int getCentroid(int start , const vvi &g, const vbl &used){
	static vi tsz(g.size(), 0);
	function<void (int, int)> DFS = [&](int source, int parent){
		tsz[source] = 1;
		for(const int next : g[source]){
				if(next == parent || used[next]) continue;
				DFS(next, source);
				tsz[source] += tsz[next]; 
		}
	};
	DFS(start, -1);
	int n = tsz[start] >> 1;
	function<int (int,int)> centroid =[&](int source, int parent){
		for(const int next : g[source]){
			if(next == parent || used[next]) continue;
			if(tsz[next] > n) return centroid(next, source);	
		}
		return source;
	};
	return centroid(start, -1);
}
