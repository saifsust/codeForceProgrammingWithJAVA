#include<bits/stdc++.h>
using namespace std;
const int dim=2;


void mult(int A[][dim], int B[][dim]){
	int res[dim][dim];
	
	for(int i = 0; i<dim; i++){
		for(int k = 0; k<dim; k++){
			res[i][k] = 0;
			for(int p = 0; p<dim; p++){
				res[i][k] += A[i][p] * B[p][k];	 				
			}
		}
	}
	
	for(int i = 0; i<dim; i++){
		for(int p = 0;p<dim; p++) A[i][p] = res[i][p];
	}
}


void power( int M[][dim], int n){
     
      int res[dim][dim];
      for(int i = 0; i<dim; i++){
		  for(int j = 0; j<dim; j++){
			  if(i == j) res[i][j] = 1;
			  else res[i][j] = 0;
		  }
	  }
     
     while(n){
       if(n%2 == 1) mult(res, M), n--;
       else mult(M,M), n/=2;
	 }
	 
	for(int i = 0; i<dim; i++){
		for(int p = 0;p<dim; p++) M[i][p] = res[i][p];
	}
     	
}


int main(){
	
    int num;
    while(scanf("%d",&num)==1){
	 int fib[]={0,1};
     int A[][dim]={{0,1},{1,1}};
     if(num == 0){
		 cout<<"0"<<endl; 
		 continue;
	 }
       
     power(A, num-1);	  
     int res[2];
     for(int i = 0; i<dim; i++){
		 res[i] = 0;
		 for(int j = 0;j<dim; j++){
			 res[i]+= fib[j] * A[j][i];
		 }
	 }
	 
     cout<<res[1]<<endl;	 
	  
		
	}
	return 0;
}
