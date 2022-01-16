class Solution {
    private static final int N = 26;
    public String[] divideString(String s, int k, char fill) {
        String temp = "";
        
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i<s.length(); i++){
            temp += s.charAt(i);
            if(temp.length() == k){
                list.add(temp);
                temp = "";
            }
        }
        if(temp != ""){
            int start = temp.length();
            for(int i = start+1; i<= k; i++) temp+= fill;
            list.add(temp);
        }
        
        return list.stream().toArray(String[]::new);
    }
}
