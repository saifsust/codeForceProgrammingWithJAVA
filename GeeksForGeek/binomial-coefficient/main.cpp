#include<bits/stdc++.h>
using namespace std;
namespace {
    const int NN = 100;
};

long long binomial[NN][NN];

void preCal(){
    binomial[0][0] = 1;
    for(int i = 1 ; i<NN; i++){
        binomial[i][0]=1;
        for(int j = 1; j<i; j++){
            binomial[i][j] = binomial[i-1][j-1] + binomial[i-1][j];
        }
    }
}

int main(int argc, char* argv[]){
    preCal();
    for(int i = 0; i< 10; i++){
        for(int j = 0; j< i; j++){
            printf("%lld ", binomial[i][j]);
        }
        printf("\n");
    }
    return 0;
}