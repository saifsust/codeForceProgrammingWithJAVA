class Solution {
public:
    string longestPalindrome(string s) {
        size_t maxLen = 0;
        size_t start = 0;
        for(size_t i =0 ; i< s.size(); i++){
            for(size_t j = i; j < s.size(); j++){
                int len = j - i + 1;
                bool isPalindrome = true;
                for(size_t k = 0; k< len >>1; k++){
                    if(s[i + k] != s[j - k]){
                        isPalindrome = false;
                        break;
                    }      
                }
                
                if(isPalindrome && len > maxLen){
                    start = i;
                    maxLen = len;
                }
                
            }
        }
        
        return s.substr(start, maxLen);
    }
};
