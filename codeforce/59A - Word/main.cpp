#include<bits/stdc++.h>
using namespace std;

#define fastio ios::sync_with_stdio(false); cin.tie(0); cout.tie(0)


int main(int argc,char *argv[]){
	fastio;
	string text;
	assert(cin >> text);
	int lCount = 0, uCount = 0;
	string lTemp = "", uTemp = "";
	int diff = 'A' - 'a';
	for(unsigned i = 0; i<text.size(); i++){
		if(text[i] >= 'a' && text[i] <= 'z'){
			++lCount;
			lTemp += text[i];
			uTemp += text[i]+diff;
		}
		if(text[i] >= 'A' && text[i] <= 'Z'){
			++uCount;
			uTemp += text[i];
			lTemp += text[i] - diff;
		}
	}
	
	cout << (lCount < uCount ? uTemp : lTemp) << endl; 
	
	return 0;
}
