class Solution {
    public int tupleSameProduct(int[] nums) {
       // Arrays.sort(nums);
        int count  = 0, a,b,c,d;
        for(int i = 0; i<nums.length; i++){
             a = nums[i];
            for(int j = nums.length -1; j - i >= 3; j--){
                b = nums[j];
                if(a == b) continue;
                for(int k = i + 1; k<j-1; k++){
                    c = nums[k];
                    if( c == a || c == b) continue;
                    for(int p = j - 1; p > k; p--){
                        d = nums[p];
                        if(d == c || d == a || b == d) continue;
                        if( a * b == c * d || a *c == d*b || a * d == b * c){
                            ++count;
                           //System.out.printf(" %d %d %d %d " ,a,b,c, d);       
                        } 
                    }
                    //System.out.println();
                }
                //System.out.println();
            }
        }
      return count * 8;
        
    }
}
