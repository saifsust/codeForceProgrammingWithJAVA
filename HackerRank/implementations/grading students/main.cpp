#include<bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    int grades[n];
    
    for(int i = 0; i<n; i++){
        cin >> grades[i];
    }
    
    for(int i =0; i<n; i++){
        if(grades[i] < 38){
            continue;
        }else if( 5 - grades[i] % 5 < 3){
            grades[i] += 5 - grades[i] % 5;
        }
    }
    
    for(int i = 0; i<n; i++){
        cout << grades[i] << endl;
    }
    
    
    return 0;
}
