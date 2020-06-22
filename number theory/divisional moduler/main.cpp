#include<bits/stdc++.h>
using namespace std;

int multiplicative_inverse(int base, int mod){
	int result = 1;
	// fermat's theorem 
	// a^p-1 % p = 1 where p is prime
	// a^p-1/p % p = 1/p %p
	// a^p-2 %p = 1/p %p
	int p = mod - 2;
	
	while(p){
		if(p % 2) p--, result = (result %mod * base % mod)%mod;
		base = (base % mod * base %mod) %mod;
		p /= 2;
	}
	return result;
}

int main(){
	
	int num , p;
	while(cin>>num>>p){
		
		// a/b % m  = (a%m * 1/b%m) %m
		
		cout<<" fermat : "<<multiplicative_inverse(num, p)<<endl;
		// euclid theorem 
		// ax + by = gcd(a, b)
		// ax + py = 1 where p is prime
		// ax %p = 1
		//  x = 1/b
		
		for(int x = 2; x < p; x++){
			if(num * x % p == 1){
				cout<< "euclid : "<< x<< endl;
				break;
			}
		}
		
	}
	return 0;
}
