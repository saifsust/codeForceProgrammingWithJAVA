import java.util.*;
import java.io.*;
import java.lang.*;
class Main
{

    public static void main(String[] args)
    {

        Scanner read = new Scanner(System.in);

        while(read.hasNext())
        {

            int size = read.nextInt();
            int[] nums = new int[size];
            for(int i = 0; i < size; ++i)
            {
                nums[i] = read.nextInt();
            }
            int target = read.nextInt();

            System.out.println(new Solution().fourSum(nums, target));

        }
        read.close();

    }
}

class Solution
{
    private final int mod = 100000007;
    private final int X = 37;
    public List<List<Integer>> fourSum(int[] nums, int target)
    {

        List<List<Integer>> sumList = new ArrayList<>();
        HashMap<Long, Integer> isHash = new HashMap<>();
        //System.out.println(prime);
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3 ; ++i)
        {
            for(int j = i + 1; j < nums.length - 1; ++j)
            {
                for(int k = j + 1; k < nums.length - 1; ++k)
                {
                    for(int m = k + 1; m < nums.length; ++m)
                    {
                        int sum = nums[i] + nums[j] + nums[k] + nums[m];
                        //System.out.println(nums[i]+"  "+nums[j]+" "+nums[k]+" "+nums[m]);

                        if(sum == target)
                        {
                            List<Integer> elements = new ArrayList<>();
                            long hash = hashCode(nums[i], nums[j], nums[k], nums[m]);
                            //System.out.println(hash);
                            elements.add(nums[i]);
                            elements.add(nums[j]);
                            elements.add(nums[k]);
                            elements.add(nums[m]);
                            //Collections.sort(elements);

                            if(sumList.isEmpty())
                            {

                                sumList.add(elements);
                                isHash.put(hash, sumList.size() - 1);
                            }
                            else
                            {

                                if(isHash.get(hash) != null)
                                {
                                    continue;
                                }
                                else
                                {
                                    sumList.add(elements);
                                    isHash.put(hash, sumList.size() - 1);
                                }


                            }
                        }
                    }
                }
            }
        }


        return sumList;
    }
    private long hashCode(int a, int b, int c, int d)
    {
        return (a * (int)Math.pow(X, 3) + b * (int)Math.pow(X, 2) + c * X + d) % mod;
    }


}