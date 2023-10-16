// method is used to remove duplicate

string rremove(string s){
        
        
        if(s.empty() || isUnique(s)) return s;
        
        
        const int n = s.size();
        
        for(int i = 0; i<n; i++){
            bool isDuplicated  = false;
            for(int j = i + 1 ; j<n; j++){
                if(s[i] == s[j]){
                    s[j] = '\0';
                    isDuplicated = true;
                }else break;
            }
            
            if(isDuplicated) s[i] = '\0';
        }
        
        
        string temp = "";
        
        for(int i = 0; i<n; i++){
            if(s[i] != '\0') temp += s[i];
        }
        
        
        return rremove(temp);
    }

// method is used to identify the unique string
    bool isUnique(string s){
        for(int i = 1; i<s.size(); i++){
            if(s[i] == s[i -1]) return false;
        }
        return true;
    }
