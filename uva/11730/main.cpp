#include<iostream>
#include<cstdio>
#include<vector>
#include<queue>
#include<algorithm>
#include<bitset>
#include<cmath>
using namespace std;

typedef queue<int> qi;
typedef vector<int> vi;

const int INF =10000000;

const int MAX_SIZE = 1001;
qi q;
vi primeFactor,primes;
bitset<MAX_SIZE> isPrime;

void seive();
int minimumDist(int start,int dest);

vector<int> getPrimeFactors(int num);


  

int main(){

	//freopen("in.txt","r",stdin);
     seive();

   /*  for(int i=0;i<10;i++) printf("%d ",primes[i]);

     	cout<<endl<<"\n\n";

      vi primeFactors = getPrimeFactors(245);

      for(int i=0;i<primeFactors.size();++i) cout<<primeFactors[i]<<" ";

      cout<<endl;*/

     int start,dest,testCase=0;

     while(scanf("%d%d",&start,&dest)){

     	if(start ==0 && dest ==0) break;

     	//cout<<start<<endl;

     	//vi graph = getPrimeFactors(start);

     	/*for(int i=0 ; i<graph.size();++i){
     		cout<<graph[i]<<" ";
     	}*/



     	printf("Case %d: %d\n",++testCase,minimumDist(start,dest));

     }





	return 0;
}





int minimumDist(int start,int dest)
{
	if(isPrime[start]==0)return -1;
	q.push(start);
    
    int dists[2*MAX_SIZE];

    
    for(int i=0;i<2*MAX_SIZE;++i){
    dists[i]=INF;	
    } 

	dists[start]=0;

		while(!q.empty()){
			int peek = q.front();
			q.pop();
             
             if(peek >= dest || isPrime[peek]==0)continue;       
           vi graph = getPrimeFactors(peek);

           for(register int i=0;i<graph.size();++i){
           	int next = peek + graph[i];
           	//cout<<graph[i]<<endl;
           	int dist = dists[peek]+1;
           	if(dist<dists[next]){
           		dists[next]=dist;
           		q.push(next);
           	}
           }
		}

		return dists[dest] == INF  ? -1: dists[dest];

}
//prime factor finder

vi getPrimeFactors(int num){

   vi primeFactors;

   int isSame[num+1];

    for(int i=0;i<primes.size() && primes[i]<=num ; ++i){
    	
    	int p = primes[i];
    	if(num%p==0){
    	primeFactors.push_back(p);
    	//cout<<p<<endl;	
    	}


    	

    	while(num >1 && num%p==0){
           num/=p;
    	}
    }

   return primeFactors;
}


// seive for prime finding
void seive(){

	primes.push_back(2);
      isPrime[1]=1;
	for(int i=4;i<MAX_SIZE;i+=2) isPrime[i]=1;

    int SQRT = (int)sqrt(MAX_SIZE);

	for(int i=3;i<MAX_SIZE;i+=2){
         
         if(isPrime[i]==0){

         	if(i<=SQRT)
         	for(int j=i*i;j<MAX_SIZE;j+=i*2)isPrime[j]=1;

         	primes.push_back(i);
         }
	}

}

