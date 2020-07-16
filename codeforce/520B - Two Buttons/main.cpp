#include<bits/stdc++.h>
using namespace std;
const int N= 2e4+5;
const long long INF = LONG_LONG_MAX;
long long dist[N],m,n;
void binary(long long n){
	//cout << n << endl;
    int d = dist[n] + 1;
    if(dist[n<<1] > d && n <= m){
		dist[n<<1] = d;
		binary(n << 1);
	}
	if(dist[n-1] > d && n>1){
		dist[n-1] = d;
		binary(n-1);
	}
   
}

int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	while(cin >> n >> m){
	for(int i = 0; i<N; i++) dist[i] = INF;
	dist[n]=0;
	binary(n);
	cout << dist[m] << endl;
    }
	return 0;
}
