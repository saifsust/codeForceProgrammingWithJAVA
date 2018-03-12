import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        Scanner read = new Scanner(System.in);
        while(read.hasNext())
        {
            int _size =  read.nextInt();
            int[] digits = new int[_size];
            for(int i = 0; i < _size; i++)digits[i] = read.nextInt();
            int[] arr = sol.plusOne(digits);
            for(int i = 0; i < arr.length ; i++)
                System.out.print(arr[i] + " ");
            System.out.println();

        }
        read.close();
    }
}

/****** solution **********/
class Solution
{
    public int[] plusOne(int[] digits)
    {
        int carry = 1;
         int[] arr;
        //int len = digits.length-1;
        int sum = 0;
        for(int i = digits.length - 1; i >= 0; i--)
        {
            sum = carry + digits[i];
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        if(carry == 1)
        {
             arr = new int[digits.length + 1];
            arr[0] = 1;
            for(int i = 0; i < digits.length; i++)arr[i + 1] = digits[i];
            	return arr;
        }
        return digits;
    }
}