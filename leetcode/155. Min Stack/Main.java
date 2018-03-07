import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{


    public static void main(String[] args)
    {
        MinStack stack = new MinStack();
        stack.push(-12);
         stack.pop();
        stack.push(22);
        stack.push(23);
        stack.pop();
        stack.pop();

        //stack.pop();
        // stack.pop();
        //stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());


    }

}

class MinStack
{

    /** initialize your data structure here. */
    private int stack[], index, minEl;
    public MinStack()
    {
        stack = new int[100000];
        this.index = 0;
        this.minEl = 100000000;
    }

    public void push(int x)
    {

        stack[++this.index] = x;
        this.minEl = Math.min(minEl, stack[this.index]);



    }

    public void pop()
    {
        if(this.index > 0)
        {
            --this.index;
            int min = 2147483647;
            for(int i = 1; i <= this.index; i++)
            {
                if(min > stack[i])
                {
                    min = stack[i];
                }
            }
            this.minEl = min;
        }

    }

    public int top()
    {
        //System.out.println(stack[index]);
        return stack[this.index];
    }

    public int getMin()
    {

        return this.minEl;
    }
}