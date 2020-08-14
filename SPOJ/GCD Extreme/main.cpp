#include<bits/stdc++.h>
using namespace std;
const int N = 1e6+2;

long long phi[N], s[N];

void seive(){
	phi[1] = 1;
	 for(int i = 2; i<N; i++){
		 s[i] = 0;
		 if(phi[i] == 0){
			 for(int j = i; j<N; j+= i){
				 if(phi[j] == 0) phi[j] = j;
				 phi[j] /= i;
				 phi[j] *= (i -1);
			 }
		 }
	 }
	 
	 
	 for(int i = 1; i<N; i++){
		 for(int j = i+i; j<N; j+=i){
			 s[j] +=  i * phi[j/i]; 
		 }
	 }
	 
	 for(int i = 1; i<N; i++) s[i] += s[i-1];
	 
}

int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	seive();
	int n;
	while(cin >>n){
		if(!n) return 0;
		assert(n>=1);
		cout << s[n] << endl;
		
	}
	return 0;
}
