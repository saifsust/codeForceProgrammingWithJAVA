string longestPalin (string S)
{
    int maxLen = 0, start = 0;
    
    for(int i = 0; i<S.size(); i++){
        for(int j = i; j<S.size(); j++){
            bool isPalindrome = true;
            int len = (j - i + 1);
            for(int k = 0; k< len >> 1 ; k++){
                if(S[i + k] != S[j - k]){
                    isPalindrome = false;
                    break;
                }
            }
            if(isPalindrome && maxLen < len){
                maxLen = len;
                start = i;
            }
        }
    }
    
    return S.substr(start, maxLen);
}
