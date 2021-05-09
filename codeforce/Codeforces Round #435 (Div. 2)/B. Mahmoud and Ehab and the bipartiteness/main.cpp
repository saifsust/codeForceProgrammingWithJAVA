#include<bits/stdc++.h>
using namespace std;
typedef vector<int> vi;
const int N = 100005;
int pnt[N], color[N];
long long cnt[3];
bool visited[N];

void dfs(const vi graph[], int source ){
	 visited[source] = true;
	 cnt[color[source]]++;
	  for(unsigned i = 0; i<graph[source].size(); i++){
	  	 int next = graph[source][i];
	  	  if(!visited[next]){
	  	  	   pnt[next] = source;
	  	  	   if(pnt[source] == -1) color[next] = 1;
			   else color[next] = color[pnt[source]];
	  	  	   dfs(graph, next);
			}
	  }
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	//freopen("in.txt", "r", stdin);
	
	int n; 
	cin >> n;
	vi graph[n+1];
	int u, v;
	for(int i = 0; i< n-1 ; i++){
		cin >> u >> v;
		graph[u].push_back(v);
		graph[v].push_back(u);
	}
	memset(visited, false, sizeof(visited));
	memset(color, -1, sizeof(color));
	color[1] = 0;
	pnt[1] = -1;
	cnt[0]=cnt[1]=0;
	dfs(graph, 1);
    cout << cnt[0] * cnt[1] - (n-1) << endl;
	
	return 0;
}
