#include<bits/stdc++.h>
using namespace std;

namespace {
	const int NN = 1000;
};
long long catalan[NN];

void precalculation(){
	catalan[0] = catalan[1] = 1;
	for(int i = 2; i<NN; i++){
		for(int j = 0; j<i ; j++){
			catalan[i]+= catalan[j] * catalan[i - j-1];
		}
	}
}

int main(int argc, char* argv[]){
	precalculation();
	for(int i  = 0; i<= 100; i++){
		printf("%lld ", catalan[i]);
	}
 return 0;
}
