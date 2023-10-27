   string longestPalin (string S) {
        const int n= S.size();
        vector<vector<pair<int, string>>> memory(n, vector<pair<int, string>>(n, make_pair(-1, "")));
        pair<int, string> ans  = LPS(S, 0, n - 1, memory);
        return ans.second;
        
    }
    
    pair<int, string> LPS(string str, int start, int end, vector<vector<pair<int, string>>> &memory){
        if(start > end) return make_pair(0, "");
        if(start == end) return make_pair(1, str.substr(start, end - start + 1));
        
        
        if(memory[start][end].first != -1) return memory[start][end];
        
        if(isPalindrome(str, start, end)){
            return memory[start][end] = make_pair(end - start + 1, str.substr(start, end - start + 1));
        }
        
        pair<int, string> left = LPS(str, start + 1, end, memory);
        pair<int, string> right = LPS(str, start , end - 1, memory);

        
        if(left.first > right.first){
            return memory[start][end] = left;

        } 
        
        return memory[start][end] = right;
        
    }
    
    bool isPalindrome(string str, int start, int end){
        
        for(int i = start, j = end; i<j; i++, j--){
            if(str[i] != str[j]) return false;
        }
        
        return true;
    }
