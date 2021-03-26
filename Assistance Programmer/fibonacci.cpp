#include<bits/stdc++.h>
using namespace std;

const int N = 500;
long long fibo[N];

int fibonacci(int n){
    if(n == 0) return 0;
    if(n == 1) return 1;
    return fibonacci(n -1) + fibonacci(n -2);
}

void preCalcul(){
   fibo[0] = 0;
   fibo[1] = 1;
   for(int i = 2; i<N; i++){
     fibo[i]=fibo[i-1] + fibo[i-2];
   }
}


int main(int argc, char* argv[]){
     preCalcul();
     for(int i = 0; i<100; i++) cout << fibo[i] << " ";
     cout << endl;
     int n;
     while(cin >> n){
        cout << fibonacci(n) << endl;
     }
    return 0;
}
