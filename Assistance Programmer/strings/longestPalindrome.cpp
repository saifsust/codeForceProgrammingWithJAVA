
// Longest Palindrome using recursion 
string palindrome(string s, int start, int end){
     static string store = "";
     if(end - start + 1  < store.size()) return store;
     if(start == end) return to_string(s[start]);
     //cout << s.substr(start, end - start +1) << endl;
     bool isPalindrome = true;
     for(int i = start, j=end; i<j;i++, j--){
         if(s[i] != s[j]){
             isPalindrome = false;
             break;
         }
     }
     if(isPalindrome){
         store = s.substr(start, end-start + 1);
         return store;
     } 
     string left = palindrome(s, start, end - 1);
     string right = palindrome(s, start + 1 , end);
     if(left.size() > right.size()) return left;
     return right;
}
