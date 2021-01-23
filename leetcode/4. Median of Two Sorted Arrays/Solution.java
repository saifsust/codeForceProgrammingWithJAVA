class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int nums[] = new int[nums1.length + nums2.length];
         int countNum1 = 0, countNum2 = 0, count = 0;
        while(countNum1 < nums1.length && countNum2 < nums2.length){
             if(nums1[countNum1] < nums2[countNum2]){
                 nums[count++] = nums1[countNum1++];
             }else nums[count++] = nums2[countNum2++];
        }
        
        if(countNum1 == nums1.length) while(countNum2 < nums2.length) nums[count++] = nums2[countNum2++];
        else while(countNum1<nums1.length) nums[count++] = nums1[countNum1++];
        
        for(int i  =0 ; i<nums.length; i++) System.out.printf("%d ",nums[i]);
        
        int sum = nums1.length + nums2.length;
        int median = sum >> 1;
        if(sum % 2 == 0){
            return (double) (nums[median-1] + nums[median]) / 2.0D;
        }
        return (double) nums[median];
    }
}
