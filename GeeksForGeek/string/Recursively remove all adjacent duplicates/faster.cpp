    string rremove(string s){
        
        
        if(s.empty() || isUnique(s)) return s;
        
        
        const int n = s.size();
      
      
        string temp = "";
        
        for(int i = 0; i<n; i++){
            if(i + 1 < n && s[i] == s[i + 1]){
                while(i < n - 1 && s[i] == s[i + 1]) i++;
            }else if( i + 1 == n && s[i] == s[i - 1]){
                i++;
                continue;
            }else temp += s[i];
        }
        
    
        
        return rremove(temp);
    }
    
    bool isUnique(string s){
        for(int i = 1; i<s.size(); i++){
            if(s[i] == s[i -1]) return false;
        }
        return true;
    }
