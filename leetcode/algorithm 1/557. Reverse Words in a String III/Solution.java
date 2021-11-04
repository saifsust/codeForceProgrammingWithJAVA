class Solution {
    public String reverseWords(String s) {
        String [] arr = s.split(" ");
        String temp= "";
        for(int i = 0; i< arr.length -1; i++){
            temp  += reverse(arr[i]);
            temp += " ";
        }
        
        return temp + reverse(arr[arr.length - 1]);
    }
    private String reverse(String s){
        char[] arr = s.toCharArray();
        for(int i = arr.length -1, j = 0; i>j ; i--, j++){
            
            swap(arr, i, j);
        }
        return String.valueOf(arr);
    }
    private void swap(char arr[], int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
