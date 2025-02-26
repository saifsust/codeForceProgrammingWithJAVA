#include<bits/stdc++.h>
using namespace std;

bool backspaceCompare(string s, string t) {
        vector<char> actual, expected;

        for(unsigned i = 0; i<s.size(); i++){
            if(s[i] == '#'){
                if(!actual.empty()){
                    actual.pop_back();
                }
            }else{
                actual.push_back(s[i]);
            }
        }

        for(unsigned i = 0; i<t.size(); i++){
            if(t[i] == '#'){
                if(!expected.empty()){
                    expected.pop_back();
                }
            }else{
                expected.push_back(t[i]);
            }
        }

        if(actual.size() != expected.size()) return false;

        for(unsigned i = 0; i<actual.size(); i++){
            if(actual[i] != expected[i]){
                return false;
            }
        }

        return true;

    }

int main(){
 ios::sync_with_stdio(false);
 cin.tie(0);
 string s, t;
 while(cin >> s >> t){
    cout << backspaceCompare(s, t) << endl;
 }
 return 0;
}
