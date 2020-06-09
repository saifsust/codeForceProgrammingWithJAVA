#include<bits/stdc++.h>
using namespace std;
#define MAX 100000

int main(){
	
	int n, k;
	int rq,cq;
	
	while(scanf("%d%d",&n,&k)==2){
		scanf("%d%d",&rq,&cq);
		
	    int drd = 0, urd = 0, dld = 0, uld = 0;
	    
	     for( int drdx = rq+1, drdy = cq-1; drdx <= n && drdy >=1 ; drdx++, drdy--) ++drd;
	
	     for(int urdx = rq-1, urdy = cq+1; urdx>=1 && urdy<=n; urdx--, urdy++) ++urd;
	     
	     for(int dldx= rq+1, dldy = cq+1; dldx <= n && dldy<=n; dldx++, dldy++) ++dld;
	     
	     for(int uldx = rq-1, uldy = cq-1; uldx>=1 && uldy>=1; uldx--, uldy--) ++uld;
		 
		// printf(" drd = %d urd = %d dld= %d uld = %d \n", drd, urd, dld, uld);
		
		int hl = rq-1, hr = n-rq, vu = n - cq , vd = cq-1;
		int x, y;
		
		for(int i = 1; i<= k ; i++){
			scanf("%d%d",&x,&y);
			
			if(abs(rq-x) == abs(cq-y)){
				 int dist = abs(rq-x)-1;
				if(x>rq && y< cq) drd = min(drd, dist);
				else if( x<rq && y>cq) urd = min(urd, dist);
				else if(x>rq && y>cq) dld = min(dld, dist);
				else uld = min(uld, dist);
			}
			
			if(rq == x){
				int dist = abs(y-cq)-1;
				if(cq < y) vu = min(vu, dist);
				else vd = min(vd,dist);
			}else if( cq == y){
				int dist = abs(rq-x)-1;
				if(rq >x) hl = min(hl, dist);
				else hr = min(hr, dist);
			}
		}
	
	 printf("%d\n",drd+urd+dld+uld+hl+hr+vu+vd);
		 
		
		}
		
	return 0;
}
