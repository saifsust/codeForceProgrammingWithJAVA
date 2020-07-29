#include<bits/stdc++.h>
using namespace std;

typedef vector<int>vi;
typedef vector<vi>vvi;
typedef queue<int>qi;

const int N = 2e3+3;

int colors[N], pnt[N];
bool visited[N];

bool bfs(int ss, vvi &G){
	qi Q;
	Q.push(ss);
	memset(colors, 0, sizeof colors);
	colors[0] = 1;
	colors[ss] = 0;
	pnt[ss] = 0;
	visited[ss] = true;
	while(!Q.empty()){
		int root = Q.front(); Q.pop();
		for(const int next : G[root]){
			if(next == pnt[root]) continue;
			if(!colors[next]){
				visited[next] = true;
				colors[next] = colors[pnt[root]]; 
				pnt[next] = root;
				Q.push(next);
				
			}else if(colors[root] == colors[next]) return true;
		}
	}
	return false;
}

int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int test;
	assert(cin >> test);
	for(int t = 1; t<= test; t++){
		int n, m, u,v;
		assert(cin >> n >> m);
		vvi G(n+1);
		for(int i = 0 ;i<m; i++){
			assert(cin >> u >> v);
			assert(1<= u && u < N);
			assert(1 <= v && v <N);
			G[u].push_back(v);
			G[v].push_back(u);
		}
		memset(visited, false, sizeof visited);
		cout << "Scenario #" << t << ":"<<endl;
		bool noF = true;
		for(int i = 1; i<= n; i++){
			if(!visited[i]){
				 if(bfs(i, G)) {
					 noF = false;
					 cout << "Suspicious bugs found!";
					 break;
				 }
			}
		}
		if(noF){
			cout << "No suspicious bugs found!";
		}
		cout << endl;
		
		
	}
	return 0;
}
