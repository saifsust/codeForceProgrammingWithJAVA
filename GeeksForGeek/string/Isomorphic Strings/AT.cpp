    bool areIsomorphic(string str1, string str2)
    {
        map<char, char>map1, map2;
        
        
        if(str1.size() != str2.size()) return false;
        
        
        for(int i = 0; i < str1.size(); i++){
            if(map1.find(str1[i]) == map1.end() && map2.find(str2[i]) == map2.end()){
                map1[str1[i]] = str2[i];
                map2[str2[i]] = str1[i];
            }else if( map1.find(str1[i]) != map1.end()){
                if(map1[str1[i]] != str2[i]) return false;
            } else if(map2.find(str2[i]) != map2.end()){
                if(map2[str2[i]] != str1[i]) return false;
            }
        }
        
        return true;
        
        
    }
