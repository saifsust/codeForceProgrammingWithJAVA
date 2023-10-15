#include<bits/stdc++.h>
using namespace std;
const int LOG = 17;


int main(){
        ios::sync_with_stdio(false);
        cin.tie(NULL);
        string str;
        while(cin >> str){
                const int n = (int)str.size();
                vector<pair<int, pair<int,int>>> suffixs(n, make_pair(0, make_pair(0, 0)));
                vector<vector<int>> pwr(LOG, vector<int>(n, 0));

                for(int i = 0; i<n; i++){
                        pwr[0][i] = str[i] - 'a';
                }

                //cout << str << endl;

                for(int l = 1, k = 1; k< n; k*=2, l++){

                        //cout << "done" << endl;

                        for(int i = 0; i<n; i++){
                                suffixs[i].first = i;
                                suffixs[i].second.first = pwr[l-1][i];
                                suffixs[i].second.second = i + k < n ? pwr[l - 1][i + k] : -1;
                        }

                        sort(suffixs.begin(), suffixs.end(), [&](const pair<int, pair<int,int >> &a , const pair<int, pair<int,int>> &b){
                                          return a.second.first == b.second.first ? (a.second.second < b.second.second ? 1 : 0) : (a.second.first < b.second.first ? 1 : 0);
                                        });

                        for(int i = 0; i<n; i++){
                                pwr[l][suffixs[i].first]  = i > 0 &&
                                        suffixs[i].second.first == suffixs[i - 1].second.first &&
                                        suffixs[i].second.second == suffixs[i - 1].second.second ? pwr[l - 1][suffixs[i - 1].first] : i;
                        }
                }



                //cout << "done";
                for(int i = 0; i<suffixs.size(); i++){
                        cout << suffixs[i].first << " ";
                }
                cout << endl;

        }
        return 0;
}
~   
