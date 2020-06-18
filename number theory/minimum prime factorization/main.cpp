// minimum prime factorization using seive
#include<bits/stdc++.h>
using namespace std;
#define M 10000000
#define ll long long

ll min_prime_factor[M+1];

void seive(){
	memset(min_prime_factor, -1, sizeof min_prime_factor);
	
	for(int i = 2; i<=M; i+=2) min_prime_factor[i] = 2;
	int sqrtM = sqrt(M);
	for(int i = 3; i<= M; i+=2){
		if(min_prime_factor[i] == -1){
			if(i<= sqrtM){
				for(int j = i*i ; j<= M; j+=i*2) min_prime_factor[j] = i;
			}
			min_prime_factor[i]=i;
		}
		
	}
	
}


int main(){
	
	seive();

    int num;
	while(scanf("%d", &num)==1){
		
		cout<< min_prime_factor[num]<<endl;
	}
	
	return 0;
}
