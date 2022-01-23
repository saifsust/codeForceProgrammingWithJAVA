class Solution {
    public int countElements(int[] nums) {
        List<Integer> counter = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
             int value = nums[i];
             int max = Integer.MIN_VALUE;
             int min  = Integer.MAX_VALUE;
             for(int j = 0; j<nums.length; j++){
                 if(max < nums[j]) max = nums[j];
                 if(min > nums[j]) min = nums[j];
             }
            if(min < value && value < max){
                counter.add(value);
            }
            
         }   
        return counter.size();
    }
}
