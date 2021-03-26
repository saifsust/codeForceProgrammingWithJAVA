#include<bits/stdc++.h>
using namespace std;
const int N = 10000;
bool prime[N+100];
vector<int> primes;
void seive(){
    memset(prime, true, sizeof(prime));
    for(int i = 0; i<N; i+= 2) prime[i] = false;
    prime[1] = false;
    primes.push_back(2);
    for(int i = 3; i<N; i+= 2){
        if(prime[i]){
            if(i<= (int) sqrt(N)) for(int j = i *i; j<N; j+= i * 2) prime[j] = false;
            primes.push_back(i);
        }
    }
}

int main(int argc, char* argv[]){
  seive();
  for(int i = 0; i<100; i++) cout << primes[i] << " ";
  cout << endl;

 return 0;
}
