#include<bits/stdc++.h>
using namespace std;
#define MX 100000
#define SZ 26
int alph[SZ];
bool isPrime[MX+2];
void seive();

int main(){
	seive();
	int t;
	scanf("%d", &t);
	for(int c = 1; c<=t; c++){
	   string s;
	   cin>>s;
	   memset(alph, 0, sizeof alph);
	   for(int i = 0; i<s.size(); i++) alph[s[i]-'a']++;
       int len = 0;
	   bool isPrimeStr = true;
	   for(int i = 0; i<SZ; i++){
		   if (isPrime[alph[i]] && alph[i]){
			   isPrimeStr = false;
			   break;
		   }
		   if(alph[i]) ++len;
	   }
	   if(isPrime[len]) isPrimeStr = false;
	   printf("%s\n", isPrimeStr == true? "YES" : "NO");
	}
	
	return 0;
}

void seive(){
  isPrime[0] = 1;
  isPrime[1] = 1;
  int sqrtN = sqrt(MX);
  for(int i = 4; i<MX; i+= 2) isPrime[i] = 1;
  for(int i = 3; i<MX; i +=2){
	  if(!isPrime[i]){
		  if(i<=sqrtN)
		  for(int j = i * i; j<=sqrtN; j += i*2) isPrime[j] = 1;
	  }
  }
}


