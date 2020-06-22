#include<bits/stdc++.h>
using namespace std;
const int N =1000000;
int phi[N];

// euler totient functiion 
// euler totient mean number of co primes upto N  
void init(){
	for(int i =1; i<N; i++) phi[i] = i;
	for(int i = 2;i< N; i++){
		if(phi[i] == i){
			for(int  k = i; k< N; k+= i){
				phi[k]/= i;
				phi[k] *= (i-1);
			}
		}
	}
}

int main(){
	init();
	int num;
	while(scanf("%d", &num)){
		cout<< phi[num]<<endl;
	}
	
	return 0;
}
