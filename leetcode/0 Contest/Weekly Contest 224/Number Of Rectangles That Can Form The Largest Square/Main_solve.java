class Solution {
    private static Integer count = 0;
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i< nums.length-1; i++){
            for(int j = i + 1; j<nums.length; j++){
                Integer multi = nums[i] * nums[j];
                Integer  freq = map.getOrDefault(multi, 0);
                map.put(multi, freq+1);
            }   
        }
        count = 0;
        map
         .entrySet()
        .stream()
        .forEach(item ->{
            count += (item.getValue() *(item.getValue() - 1)) * 4;
        });
      return count;
        
    }
}
