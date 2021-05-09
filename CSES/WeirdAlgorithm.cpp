#include<bits/stdc++.h>
using namespace std;
int main(){
    //freopen("in.txt", "r", stdin);
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
   
    long long num;
    cin >> num;

    while(num != 1){
        cout << num << " " ;
        if(num % 2 == 0) num/=2;
        else {
            num  *= 3;
            num++;
        }
    }
    cout << num<< endl;


    return 0;
}
