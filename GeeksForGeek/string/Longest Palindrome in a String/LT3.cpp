 string longestPalin (string S) {
        const int n= S.size();
        
        pair<int, string> ans = make_pair(1, S.substr(0, 1));
        
        for(int i = 0; i < n; i++){
            
            int right = n - 1;
            
            while(right > i){
                
                if(S[right] == S[i]){
                    if(isPalindrome(S, i, right)){
                        if(ans.first < (right - i + 1)){
                            ans.first = right - i + 1;
                            ans.second = S.substr(i, right - i + 1);
                        }
                    }
                }
                
                right--;
                
            }
            
 
        }
        
        return ans.second;
        
    }
    
    
    bool isPalindrome(string str, int start ,  int end){
        for(int i = start, j= end; i < j; i++, j--){
            if(str[i] != str[j]) return false;
        }
        
        return true;
    }
