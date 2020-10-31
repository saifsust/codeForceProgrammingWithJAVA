#include<bits/stdc++.h>
using namespace std;

#define fastio ios::sync_with_stdio(false); cin.tie(0); cout.tie(0)

int main(int argc, char *argv[]){
	
	int n, t;
	assert(cin >> n >> t);
	char que[n+1];
	scanf("%s", que);
	while(t--){
		for(unsigned i = 0; i< strlen(que)-1; i++){
			if(que[i] == 'B' && que[i+1] == 'G'){
				 swap(que[i], que[i+1]);
				 i++;
			}
		}
	}
	printf("%s\n", que);
	return 0;
}
