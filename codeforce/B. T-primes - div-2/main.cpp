#include<bits/stdc++.h>
using namespace std;
#define lli long long int
#define sqr(n) ((n)*(n))
const int N = 1000001;
lli divs[N+1];
vector<lli>primes;
bool isTPrime(lli num){
	
	if(num <= N) return divs[num] == 3;
	lli sqrtN = sqrt(num);
	return divs[sqrtN] == 2 && num == sqrtN*sqrtN;
}

void seive(){
	for(int i = 1; i<=N; i++)divs[i]= 1;
	
	for(int i = 2; i<=N; i++){
		if(divs[i] == 1){
			for(int j = i; j<=N; j += i){
				divs[j] += divs[j/i];
			}		
		}
	}
	
}
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	seive();
    lli nums, num;
    scanf("%I64d", &nums);
    for(lli i = 0; i< nums; i++){
		scanf("%I64d", &num);
		printf("%s\n",isTPrime(num) == true ? "YES" : "NO");
	}
	return 0;
}
