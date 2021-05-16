#include<bits/stdc++.h>
using namespace std;
const int64_t N = 1000;
const int64_t INF = int(1e10);
int64_t dp[N][N];
int64_t editDistance(string str1, string str2, int first, int second){
    if(first > str1.size() && second > str2.size()) return 0;
    if(first > str1.size()) return 1 + editDistance(str1, str2, first, second + 1);
    if(second > str2.size()) return 1 + editDistance(str1, str2, first + 1, second);
    if(str1[first] == str2[second]) return editDistance(str1, str2, first + 1, second + 1);
    int64_t insert = 1 + editDistance(str1, str2, first + 1, second);
    int64_t replace = 1 + editDistance(str1, str2, first + 1, second + 1);
    int64_t remove = 1 + editDistance(str1, str2 , first, second + 1);
    return min(insert, min(replace, remove));
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string str1, str2;
    while(cin >> str1  >> str2){
        cout << editDistance(str1, str2, 0, 0) << endl;
    }
    return 0;
}
