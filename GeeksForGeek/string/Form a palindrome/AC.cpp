    int countMin(string str){
        if(isPalindrom(str)) return 0;
        const int N = str.size();
        vector<vector<int>> memory(N + 1, vector<int>(N, -1));
        return palindromic(str, 0, N - 1, memory);
    }
    
    
    int palindromic(string str, int start, int end, vector<vector<int>> &memory){
            if(start > end) return 0;
            
            if(memory[start][end] != -1) return memory[start][end];
            
            if(str[start] == str[end]) return memory[start][end] = palindromic(str, start + 1, end - 1, memory);
            
            int left = palindromic(str, start + 1, end, memory);
            int right = palindromic(str, start, end - 1, memory);
            
            return memory[start][end] = 1 + min(left, right);
            
    }
    
    
   bool isPalindrom(string str){
       for(int i = 0, j = str.size() - 1; i < j ; i++, j--){
           if(str[i] != str[j]) return false;
       }
       return true;
   }
