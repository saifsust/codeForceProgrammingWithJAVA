#include<bits/stdc++.h>
using namespace std;
#define MAX 100000

struct comp{
	
  template<typename t> bool operator()( const t &a, const t &b) const{
     return a>b;
  
  };
};

int main(){
     
     
     string str;
     while(cin>>str){
		
		int freq[26];
		memset(freq, 0, sizeof(freq));
		for(unsigned int i = 0; i<str.size(); i++) freq[int(str[i]-'a')]++;
		
		bool isValid = true;
		bool isRemove = false;
		sort(freq,freq+26, comp());
		
		for(unsigned int i = 0; i<25 && freq[i+1] != 0;){
			//cout<<i<<"  "<<freq[i]<< " ";
			if(freq[i] != freq[i+1]){
			    if(!isRemove){
					
					if(i==0) freq[i]=freq[i]-1;
					else freq[i+1] = freq[i+1]-1;
					isRemove = true;
					sort(freq, freq+26, comp());
					i = 0;
					//cout<<endl;
					continue;
					}
				if(isRemove){
					isValid = false;
					break;
				}
			}
			i++;
		}
		printf(isValid == true ? "YES\n": "NO\n");
	 
	 }   
	return 0;
}


