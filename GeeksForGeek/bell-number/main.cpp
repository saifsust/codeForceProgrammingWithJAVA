#include<bits/stdc++.h>
using namespace std;
namespace {
 const int NN = 80;
};
long long bellNum[NN][NN];
void preCal(){
    bellNum[0][0] = 1;
    for(int i = 1; i< NN; i++){
        bellNum[i][0] = bellNum[i-1][i-1];
        for(int j = 0; j<i; j++){
            bellNum[i][j+1]= bellNum[i-1][j] + bellNum[i][j];
        }
    }
}
int main(int argc, char* argv[]){
    preCal();
    for(int i =0; i<=80; i++) printf("%lld ", bellNum[i][i]);
    return 0;
}
