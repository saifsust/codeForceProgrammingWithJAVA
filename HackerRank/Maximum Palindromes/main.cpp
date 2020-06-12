#include<bits/stdc++.h>
using namespace std;
#define MOD 1000000007
#define SIZE 26
#define ll long long
#define MAX 100001 

ll fracts[MAX];
ll invMod[MAX];

void fractorial();
ll inverseModMult(ll, ll);

int main(){
	fractorial();
    
    string s;
    cin>>s;
    
    int counter[s.size()+1][SIZE];
    
    memset(counter[0], 0, sizeof(counter[0]));
    
    for(unsigned int i = 1; i<=s.size(); i++){
		for(int j = 0; j< SIZE; j++) counter[i][j] = counter[i-1][j];
		counter[i][s[i-1]-'a'] = counter[i-1][s[i-1]-'a']+ 1;
	}
	
    int queries;
    scanf("%d", &queries);
    
    for(int q = 1; q<= queries; q++){
		unsigned int l, r;
		scanf("%u%u", &l,&r);
		
		int diff;
		
		ll even = 0;
		ll odd = 0;
		ll inv = 1;
		
		for(int i = 0; i<SIZE; i++){
			diff = counter[r][i]-counter[l-1][i];
			even+=diff/2;
			odd += diff%2;
			inv = (inv % MOD * invMod[diff/2]) % MOD;
		}
		ll combinations = fracts[even];
		combinations = (combinations * inv ) % MOD;
		if (odd != 0) 
			combinations = combinations * odd % MOD;
        printf("%lld\n", combinations);		
	}

	
	return 0;
}



void fractorial(){
	fracts[0]=1;
	fracts[1]=1;
	invMod[0]=1;
	for(int i = 1; i<MAX; i++){
		fracts[i]=(fracts[i-1] * (ll)i) % MOD;
		invMod[i]= inverseModMult(fracts[i], MOD-2);
	}
}

ll inverseModMult(ll num, ll x){
	if(x == 0) return 1;
	ll p = inverseModMult(num, x/2) % MOD;
	p = (p*p)%MOD;
	return  x % 2 == 0 ? p : num * p % MOD;
}
