 //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    bool isRotated(string str1, string str2)
    {
        if(str1.size() != str2.size() ) return false;
        
        const int n = str1.size();
        
        str1 += str1;
        
        return str1.find(str2) == 2 || str1.find(str2) == n - 2;
        
    }
    
