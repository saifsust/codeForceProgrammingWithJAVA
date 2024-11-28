#include<bits/stdc++.h>
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);
  string str;
  while(cin >> str){
    int ans = 0;
    int counter = 1;
    for(unsigned i = 1; i <str.size(); i++){
        if(str[i] == str[i -1]){
            ++counter;
        }else{
            ans = max(ans, counter);
            counter = 1;
        }
    }
    ans = max(ans, counter);
    cout << ans << endl;
  }

  return 0;
}
