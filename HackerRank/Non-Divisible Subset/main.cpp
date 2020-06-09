#include<bits/stdc++.h>
using namespace std;
#define MAX 100

int main(){
	
	
	 int n, k;
	 while(scanf("%d%d",&n, &k)==2){
		 int rem[k];
		 int m;	
		 memset(rem, 0, sizeof(rem));
		 for( int i =0; i<n; i++){
			scanf("%d", &m);
			rem[m%k]++;	
		 }
		 
		 int  mid = (int)k/2;
		 int count = 0;
		 if(k%2==0) mid--;
		 for(int i = 1; i<= mid;i++){
			count += max(rem[i], rem[k-i]);
		 }
		 
		 if(rem[0]) count++;
		 if(k%2 == 0 && rem[k/2]) count++;
		 printf("%d\n", count);
	}
	return 0;
}
