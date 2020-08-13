#include<bits/stdc++.h>
using namespace std;
const int N = 1e6+4;

long long  ph[N] , sum_div[N];

void seive(){
	
	for(int i = 1; i<N; i++){
		ph[i] = i;
		sum_div[i] = 1;
	}
	
	for(int i = 2; i<N; i++){
		if(ph[i] == i){
			for(int j = i ; j<N; j += i){
				ph[j]/= i;
				ph[j]*=(i-1);
			}
		}
	}
	
	for(int i  = 2; i<N; i++){
		for(int j = i; j<N; j += i){
			sum_div[j] += i*ph[i];
		}
	}
}


int main(int argc, char *argv[]){
   ios::sync_with_stdio(false);
   cin.tie(0);
   cout.tie(0);
   seive();
   int test;
   assert(cin >> test);
   
   for(int t = 1; t<= test; t++){
	   int n;
	   assert(cin >> n);
	   long long ans = sum_div[n] + 1;
	    ans /= 2;
	    ans *= n;
	   cout << ans << endl;
	   
   }    
   return 0;
}
