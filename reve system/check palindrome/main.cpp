#include<bits/stdc++.h>
using namespace std;

bool isPalindromeNum(long long num){
    while(num / 10 != 0){
        cout << num << endl;
        long long last = num % 10;
        num /= 10;
        long long first = 0, counter = 1, temp = 0;
        // find the first digit of the number.
        while(num / 10 != 0){
            temp += num %10 * counter;
            num/= 10;
            counter *= 10;
        }
        if(num != last) return false;
        num = temp;
    }
    return true;
}

int main(int argc, char* argv[]){
    ios::sync_with_stdio(true);
    cin.tie(NULL);

    long long num;
    while(cin >> num){
        bool test = isPalindromeNum(num);
        cout << "Answer : ";
        cout << (test == true ? "Palindrome" : "Not Palindrome")  << endl;
    }
    return 0;
}