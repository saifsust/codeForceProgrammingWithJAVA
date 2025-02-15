#include<bits/stdc++.h>
using namespace std;

string getNextLexicographicalWord(string word){
    int pivot = word.size() - 2;
    while(pivot >=0 && word[pivot] >= word[pivot + 1]){
        --pivot;
    }

    if(pivot < 0) return "no answer";

    int right = word.size() - 1;

    while( right >= 0 && word[right] <= word[pivot]){
        --right;
    }

    swap(word[right], word[pivot]);

    reverse(word.begin() + pivot + 1, word.end());

    return word;


}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    vector<string> words(n);
    for(int i = 0; i<n; i++){
        cin >> words[i];
    }

    for(int i = 0; i<n; i++){

        cout << getNextLexicographicalWord(words[i]) << endl;
    }



    return 0;
}
