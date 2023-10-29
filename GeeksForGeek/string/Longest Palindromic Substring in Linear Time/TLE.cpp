string LongestPalindromeSubString(string text)
{
    int start = 0, len = 1;
    const int n = text.size();
    
    for(int i = 0; i<n; i++){
        // odd len palindrome
        
        
        int left = i, right = i;
        
        while( left >= 0 && right < n && text[left]==text[right]) --left, ++right;
        
        if(len < right - left - 1){
            len  = right -  left - 1;
            start = left + 1;
        }
        
        // even length palindrome
        
        left = i, right = i + 1;
        
        while(left >= 0 && right < n && text[left] == text[right]) --left, ++right;
        
        if(len < right - left - 1){
            len = right - left - 1;
            start = left + 1;
        }
        
    }
    
    return text.substr(start, len);
}
