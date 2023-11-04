
int CountPS(char S[], int N)
{
    
    int ans = 0;
    
    
    for(int i = 0; i<N; i++){
        // odd length palindrome
        
        int left = i - 1, right = i + 1;
        
        while(left >= 0 && right < N && S[left] == S[right]) ++ans, --left, ++right;
        
        
        // even length palindrome
        
        left = i, right = i + 1;
        
        while(left >= 0 && right < N && S[left] == S[right]) ++ans,  --left , ++right;
        
    }
    
    return ans;
    
}
