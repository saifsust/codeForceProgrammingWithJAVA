  string longestCommonPrefix (string arr[], int N)
    {
        string prefix= arr[0];
		for(int count = 1; count < N; count++) {
		//	cout << prefix << endl;
			string temp = "";
			for(int i = 0; i<prefix.size() && i<arr[count].size(); i++) {
				if(prefix[i] != arr[count][i]) break;
				temp += prefix[i];
			}
			if(temp.compare("")) temp+='\0';
			prefix= temp;
		}
		return prefix == "" ? "-1" : prefix;
    }
