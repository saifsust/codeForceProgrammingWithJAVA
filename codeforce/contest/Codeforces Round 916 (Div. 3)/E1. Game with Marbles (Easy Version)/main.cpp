#include<bits/stdc++.h>
using namespace std;
 
struct Node{
	int val;
	int idx;
 
       bool operator<(const Node node)const{
	   return node.val < val;
	}
 
};
 
int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int T;
	cin >> T;
 
	for(int t = 1; t<= T; t++){
		int n;
		cin >> n;
		vector<int> a(n), b(n);
 
		for(int i = 0; i<n; i++){
			cin >> a[i];
		}
 
		for(int i = 0; i<n; i++){
			cin >> b[i];
		}
 
		vector<Node> com(n);
 
		for(int i =0; i <n; i++){
			com[i].val = a[i] + b[i];
			com[i].idx = i;
		}
 
 
		sort(com.begin(), com.end());
 
		/**
		for(int i = 0; i<n; i++){
			cout <<"(" <<com[i].val << " " << com[i].idx <<" ) ";
		}
 
		cout << endl;
		**/
 
		long long  ans = 0;
 
		for(int i = 0; i<n; i++){
 
			if( i & 1){
				ans -= b[com[i].idx] - 1;
			}else{
				ans += a[com[i].idx] - 1;
			}
		}
 
		cout << ans << endl;
 
 
	}
}
