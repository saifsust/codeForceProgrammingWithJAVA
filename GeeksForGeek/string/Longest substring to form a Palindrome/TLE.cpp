    int longestSubstring(string s) {
        vector<vector<int>>memory(s.size(), vector<int>(s.size(), -1));
        
        return LPS(s, 0, s.size() - 1, memory);
    }
    
    
    int LPS(string s, int start, int end, vector<vector<int>> &memory){
        if(start == end) return 1;
        
        if(memory[start][end] != -1) return memory[start][end];
        
        if(isPalindrome(s, start, end)) return memory[start][end] = end - start + 1;
        
        int left = LPS(s, start + 1, end, memory);
        int right = LPS(s, start, end - 1, memory);
        
        return memory[start][end] = max(left, right);
        
    }
    
    
    
    bool isPalindrome(string s, int start, int end){
        const int n  = 26;
        vector<int>counter(n, 0);
        for(int i = start; i<= end; i++) ++counter[s[i] - 'a'];
        
        int odd = 0;
        for(int i = 0; i<n; i++) if(counter[i] & 1) ++odd;
        
        return odd <= 1;
    }
