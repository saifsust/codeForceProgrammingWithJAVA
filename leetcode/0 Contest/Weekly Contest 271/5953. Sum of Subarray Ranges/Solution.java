class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        
        for(int end = 1; end<nums.length; end++){
            for(int start = 0; start< nums.length - end; start++){
                sum += range(nums, start, start + end);
            }
        }
        
        return sum;
    }
    
    private int range(int[] nums,int start, int end){
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for(int i = start; i<=end; i++){
            mn = Math.min(mn, nums[i]);
            mx = Math.max(mx, nums[i]);
        }
        return mx - mn;
    }
    
    
}
