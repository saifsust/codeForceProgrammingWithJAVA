#include <bits/stdc++.h>

using namespace std;

/*
 * Complete the 'encryption' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */
string removal(string s){
    string temp = "";
    for(int i = 0; i<s.size(); i++){
        if(s[i] == ' ') continue;
        temp+= s[i];
    }
    return temp;
}
string encryption(string s) {
    s = removal(s);
    
    int row    = floor(sqrt(s.size()));
    int column = ceil(sqrt(s.size()));
    
    if(row * column < s.size()) ++row;
    
    char arr[row+1][column+ 1];
    // fresh arrary
    for(int i = 0; i <= row; i++){
        for(int j = 0; j <= column; j++){
            arr[i][j] = ' ';
        }
    }
    // main algorithm
    for(int i = 0, rr = 0; i<(int)s.size(); i+=column, rr++){
        for(int j = i; j < (int)s.size() && j < (i + column); j++){
            arr[rr][j-i] = s[j];
            cout << s[j];
        }
        cout << endl;
    }
    
    string ans = "";
    // prepare answer
    for(int col = 0; col <column; col++){
        for(int rr = 0; rr < row; rr++){
            if(arr[rr][col] == ' ') continue;
            ans+= arr[rr][col];
        }
        ans +=' ';
    }
    return ans;
    
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = encryption(s);

    fout << result << "\n";

    fout.close();

    return 0;
}
