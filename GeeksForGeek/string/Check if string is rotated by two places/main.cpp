    bool isClockWise(string str1, string str2){
        if(str1.compare(str2) == 0 || str1.size() != str2.size() || str1.size() <= 2) return false;
        const int n = (int) str1.size();
        
        string temp = str1 + str2;
        
        for(int k = 0; k<temp.size(); k++){
            if(temp[k] == temp[n]){
               int i = k;
               int j = n;
               int counter = 0;
               while(i < n && temp[i] == temp[j]) i++, j++, counter++;
               i = 0;
               while( i < k && temp[i] == temp[j]) i++, j++, counter++;
               
               if(counter == n) return true;
            }
        }
        
        return false;

    }
