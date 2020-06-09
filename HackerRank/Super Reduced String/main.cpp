#include<bits/stdc++.h>
using namespace std;
#define MAX 100000
bool isAdjacentDiff(string);

int main(){
     
     string str, temp;
     while(cin>>str){
		
		temp ="";
		while(true){
			if(str == "" || isAdjacentDiff(str)) break;
			temp = "";
			for(unsigned int i = 0; i<str.size();){
			  
			  if(i+1< str.size() && str[i]==str[i+1]){
				  i+=2;
				  continue;
			  }
			  
			  temp+=str[i];
			  i++;	   
			}
			str = temp;
		}
		
		cout<<(str == ""? "Empty String" : str)<<endl;
	 
	 }	
	    
	return 0;
}


bool isAdjacentDiff(string s){
    for(unsigned int i = 0; i<s.size()-1; i++){
        if (s[i] == s[i+1]) return false;
    }
    return true;
}

