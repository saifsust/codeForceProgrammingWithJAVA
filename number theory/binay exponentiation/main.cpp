#include<bits/stdc++.h>
using namespace std;


int naive_approach(int base, int p){
	int res = 1;
	for(int i = 1; i<=p; i++) res *=base;
	return res; 
} 


int optimization(int base, int p){
	int res= 1;
	while(p){
		 if(p%2){
			 res *=base;
			 p--;
		 }else {
			 base *= base;
			 p/=2;
		 }
	}
	return res;
}

int main(){
	
	
	int b,p;
	while(scanf("%d%d", &b,&p)==2){
		cout<<"naive "<< naive_approach(b, p)<<"  optimal "<< optimization(b,p)<<endl;
	}
	
	return 0;
}
