#include<bits/stdc++.h>
using namespace std;
namespace{
  const int NN = 1000;
};


long long permu[NN][NN];

void preCal(){
  for(int i =0; i<NN; i++) permu[i][1] = i;
  permu[0][0] = 1;
  for(int i = 2; i<NN; i++){
    for(int j = 2 ; j <= i; j++){
      permu[i][j] = j * permu[i-1][j-1] + permu[i-1][j]; 
    }
  }
}

int main(int argc, char* argv[]){
    ios::sync_with_stdio(false);
    preCal();
    int n, k;
    while(scanf("%d%d", &n, &k)==2){
      printf("%lld\n", permu[n][k]);
    }
    return 0;
}