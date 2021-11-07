class Solution {
    public int countVowelSubstrings(String word) {
        int counter = 0;
        
        for(int i = 0; i<=word.length() - 5 ; i++){
            for(int j = i + 4; j<word.length(); j++){
                if(isVowelsSubstring(word, i, j)){
                    //System.out.printf("%d %d\n", i, j);
                    ++counter;
                }
            }
        }
        return counter;
    }
    
    private boolean isVowelsSubstring(String word, int start, int end){
        int counter[] = new int[6];
        for(int i = start; i<=end; i++){
            if(!isVowel(word.charAt(i))) return false;
            ++counter[index(word.charAt(i))];
        }
        for(int i = 0; i<5; i++){
            if(counter[i] == 0) return false;
        }
       return true;
    }
    
    private boolean isVowel(char chr){
        return chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u';
    }
    private int index(char chr){
        switch(chr){
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
        }
        return 4;
    }
}
