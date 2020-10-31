#include<bits/stdc++.h>
using namespace std;

#define fastio ios::sync_with_stdio(false); cin.tie(0); cout.tie(0)

bool isLucky(int num){
	if(!num) return false;
	while(num){
		if(num % 10 != 4 &&  num % 10 != 7) return false;
		num /=10;
	}
	return true;
}

int main(int argc,char *argv[]){
	string num;
	int count = 0;
	assert(cin >> num);
	for(unsigned i = 0; i < num.size(); i++) if (num[i] == '4' || num[i] == '7') ++count;
	
	cout << (isLucky(count) == true ? "YES" : "NO") << endl;

	return 0;
}
