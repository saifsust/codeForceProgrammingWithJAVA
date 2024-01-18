#include<bits/stdc++.h>
using namespace std;
 
 
vector<int> getBests(vector<int> a){
	vector<int> res(3, -1);
 
	for(int i = 0; i<a.size(); i++){
		if(res[0] == -1 || a[i] > a[res[0]]){
			res[2] = res[1];
			res[1] = res[0];
			res[0] = i;
		}else{
			if(res[1] == -1 || a[i] > a[res[1]]){
				res[2] = res[1];
				res[1] = i;
			}else {
				if(res[2] == -1 || a[i] > a[res[2]]){
					res[2] = i;
				}
			}
		}
	}
 
	return res;
}
 
 
int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int T;
	cin >> T;
	for(int t = 1; t<= T; t++){
		int n;
		cin >> n;
		vector<int> a(n), b(n), c(n);
		for(int i = 0; i<n; i++){
			cin >> a[i];
		}
 
		for(int i = 0; i<n; i++){
			cin >> b[i];
		}
 
		for(int i = 0; i<n; i++){
			cin >> c[i];
		}
 
               
	      vector<int> besta = getBests(a);
	      vector<int> bestb = getBests(b);
	      vector<int> bestc = getBests(c);
 
	      int ans = 0;
	      for(int i = 0; i<besta.size(); i++){
		      for(int j = 0; j<bestb.size(); j++){
			      for(int k = 0; k<bestc.size(); k++){
				      if(besta[i] != bestb[j] && besta[i] != bestc[k] && bestb[j] != bestc[k]){
					      ans = max(ans, a[besta[i]] + b[bestb[j]] + c[bestc[k]]);
				      }
			      }
		      }
	      }
 
	      cout << ans << endl;
 
 
	}
	return 0;
}
