#include<bits/stdc++.h>
using namespace std;

int main(){
    
	int t;
	scanf("%d", &t);
	for(int i = 0; i<t; i++){
		int n;
		scanf("%d", &n);
		int a, mxx ,mnx,mxy,mny;
		mxx = mxy = -1e9;
		mnx = mny = 1e9;
		for(int i = 0; i<n; i++){
			scanf("%d", &a);
			mxx = max(mxx, a-i);
			mnx = min(mnx, a-i);
			mxy = max(mxy, a+i);
			mny = min(mny, a+i);
		}
        
		printf("%d\n",max(mxx-mnx, mxy-mny));

	}

	return 0;
}
