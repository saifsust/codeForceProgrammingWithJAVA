class Solution {
    private static Integer max =0, maxSqr = 0;
    public int countGoodRectangles(int[][] rectangles) {
          Map<Integer, Integer> maxLen = new HashMap<Integer, Integer>();
          for(int i = 0; i< rectangles.length; i++){
               Integer sqr = Math.max(rectangles[i][0], rectangles[i][1]) - Math.abs(rectangles[i][0] - rectangles[i][1]);
              if(maxLen.get(sqr)==null) maxLen.put(sqr, 1);
              else maxLen.put(sqr, maxLen.get(sqr)+1);
          }
         maxLen.entrySet().stream()
        .forEach(item->{
            if(maxSqr < item.getKey()){
                max = item.getValue();
                maxSqr = item.getKey();
            }
        });
        return max;
        
    }
}
