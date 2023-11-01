string LongestPalindromeSubString(string text)
{
    const int n = text.size();
    vector<int> P(2 * n + 1, 0);
    
    string str = "$";
    for(int i = 0; i<n; i++){
        str += text[i];
        str += '$';
    }
    
    
    int L = 0, R = 0, maxLen = 0,  maxCenter = 0;
    
    for(int i = 0; i< 2 * n + 1; i++){
        if(P[i] < R){
            P[i] = min(P[L + R - i], R - i);
        }
        
        int left = i - P[i];
        int right = i + P[i];
        
        while(left >= 0 && right < 2 * n + 1 && str[left] == str[right]) --left, ++right, ++P[i];
        
        
        if(P[i] > maxLen){
            maxLen = P[i];
            maxCenter = i;
        }
        
        if(right - 1 > R){
            R = right - 1;
            L = left + 1;
        }
    }
    
    
    string ans = "";
    
    for(int i = maxCenter - maxLen + 1; i < maxCenter + maxLen; i++){
        if(str[i] == '$')  continue;
        
        ans += str[i];
    }
    
    return ans;
    
    
}
