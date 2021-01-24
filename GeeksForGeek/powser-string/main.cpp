#include<bits/stdc++.h>
using namespace std;

void powerset(string s){
     int pOfn = pow(2, s.size());
     vector<string> vss;
     for(unsigned int i = 1; i<pOfn; i++){
            string temp = "";
           for(unsigned j = 0; j< s.size(); j++){
              if(i & 1<<j){
                  temp += s[j];
              }
           }
           //cout << temp;
           vss.push_back(temp);
     }

     sort(vss.begin(), vss.end());
     for(const string ss : vss){
         cout << ss << endl;
     }
}
int main(int argc, char* agv[]){
    ios::sync_with_stdio(false);
    string s;
    while(cin >> s){
        powerset(s);
    }
    return 0;
}