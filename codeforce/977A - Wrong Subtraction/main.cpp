#include<bits/stdc++.h>
using namespace std;

#define fastio ios::sync_with_stdio(0);cin.tie(0); cout.tie(0)



int main(){
	fastio;
    int n, k;
    
    assert(cin >> n >> k);
    
    while(k--){
		if(n % 10) n--;
		else n /= 10;
	}
	
	cout << n << endl;
	
	return 0;
}
