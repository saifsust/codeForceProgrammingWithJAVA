#include<bits/stdc++.h>
using namespace std;

int main(){
		
	int n, k;
	
	
	while(scanf("%d%d", &n, &k)==2){	
		char num[n];
		scanf("%s",num);
		
		int changed[n/2+2];
		memset(changed, 0, sizeof(changed));
		
		for(int i = 0, j = n-1; i<j; i++, j--){
			if(num[i] != num[j]){
				num[i]=num[j] = max(num[i], num[j]);
				changed[i]=1;
				--k;
			}
		}
		
		if(k>0){
			for(int i = 0, j= n-1; i<j && k>0; i++, j--){
				if(num[i]=='9') continue;
				
				if(changed[i]){
					num[i]=num[j]='9';
					k--;
				}
				else if(k>=2){
					num[i]=num[j]='9';
					k-=2;
				}
			}
			if(k>0 && n%2==1){
				num[n/2]='9';
				changed[n/2]=1;
				--k;
			}				
		}
		
		printf("%s\n",k<0? "-1" : num);
	}
	return 0;
}



