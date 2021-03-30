#include<bits/stdc++.h>

using namespace std;


bool isOper(char ch){
	switch(ch){
		case '+':
		case '-':
		case '/':
		case '*':
		case '^':
		 return true;
		default : return false;
	};
	return false;
}

int main(){
 
    string exp;
    while(cin >> exp){
		cout << exp << endl;
		string ans = "";
		stack<char>s;
		queue<char>q;
		
		// exp must contain proper paranthesis
		for(unsigned i = 0; i<exp.size(); i++){
			if((exp[i] >= 'a' && exp[i] <= 'z') || (exp[i] >= 'A' && exp[i] <= 'Z')){
				q.push(exp[i]);
			}else if(isOper(exp[i])){
				if(q.empty()) ans = exp[i] + ans;
				else ans += exp[i];
			}else if(exp[i] == '(') s.push(exp[i]);
			else if(exp[i] == ')'){
				s.pop();
				while(!q.empty()){
					ans += q.front();
					q.pop();
				}
			} 
		}
		
		while(!q.empty()){
			ans += q.front();
			q.pop();
		}
		
		cout << ans << endl;
	}
	
	return 0;
}




