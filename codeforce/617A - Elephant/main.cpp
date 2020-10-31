#include<bits/stdc++.h>

using namespace std;

#define fastio ios::sync_with_stdio(false); cin.tie(0); cout.tie(0)


int main(){
	fastio;
	int x;
	assert(cin >> x);
	int step = 0;
	while(x){
		if(x >= 5) x-= 5;
		else if (x >= 4) x-=4;
		else if (x >= 3) x -= 3;
		else if(x >= 2) x -= 2;
		else if (x>= 1) x -= 1;
		++step;
	}
	cout << step << endl;
	return 0;
}
