/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long start = 1, end = n;
        
        while(start < end){
             long mid = (start + end) >> 1;
            //System.out.println(mid);
            if(!isBadVersion((int) mid-1) && isBadVersion((int)mid) && isBadVersion((int)mid + 1)) return (int)mid;
            else if(isBadVersion((int)mid)) end = mid - 1;
            else start = mid + 1;
        }
        
        return (int)start;
    }
}
