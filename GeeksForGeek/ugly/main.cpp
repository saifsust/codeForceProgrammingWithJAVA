#include<bits/stdc++.h>
using namespace std;
/**
 * The ugly number is the number which has only prime factors are 2,3,5 
 **/
const int N = 1000000;
bool ugly[N+1];
void preproccess(){
	ugly[1]=ugly[2]=ugly[3]=ugly[5] = 1;
	for(int i = 4; i<N; i++){
		ugly[i] = i % 2 == 0 ? ugly[i/2] : i % 3 == 0 ? ugly[i/3]: i% 5 == 0 ? ugly[i/5]: ugly[i]; 
	}	
}

int main(int argc, char* argv[]){
   
     preproccess();
    int num;
    while(scanf("%d", &num)==1){
		printf("%d\n", ugly[num]);
	}
	return 0;
}
