class Solution {
    private final int ROD = 10;
    public int countPoints(String rings) {
        
        int counter[][] = new int[ROD][3];
        
        for(int i = 0; i<ROD; i++){
            for(int j = 0; j<3; j++) counter[i][j] = 0;
        }
        
        for(int i = 0; i<rings.length(); i+=2){
            counter[rod(rings.charAt(i+1))][index(rings.charAt(i))]++;
        }
        
        
        int ans = 0;
        for(int i = 0; i<ROD; i++){
            if(counter[i][0] > 0 && counter[i][1] > 0 && counter[i][2] > 0) ++ans;
        }
        
        return ans;
        
    }
    
    
    private int rod(char chr){
        return (int) (chr - '0');
    }
    
    private int index(char chr){
        switch(chr){
            case 'R': return 0;
            case 'B': return 1;
            case 'G': return 2;
            default : return -1;
        }
    }
    

}
