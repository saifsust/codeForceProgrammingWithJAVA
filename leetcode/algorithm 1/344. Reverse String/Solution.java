class Solution {
    public void reverseString(char[] s) {
        for(int i = s.length-1, j = 0; i>j; j++, i--){
            swap(s, i,j);
        }
    }
    
    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
