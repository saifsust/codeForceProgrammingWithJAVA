import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{

    private static int GCD(int a, int b)
    {
        if(a == 0) return b;
        return GCD(b % a, a);
    }
    public static void main(String[] args) throws Exception
    {
         Scanner read = new Scanner(System.in);
        /*Scanner read = FileFactory.read();*/
        BufferedWriter write = FileFactory.write();

        int testCase = read.nextInt();
        for(int test = 1; test <= testCase; test++)
        {
            int gcd = read.nextInt();
            int lcm = read.nextInt();
            int mult = gcd * lcm;
            int xx = 0, yy = 0, min = (int) 5e32, _mxx = 0, _myy = 0;
            boolean flag = false;

            for(int i = gcd; i <= (int)mult / 2  && xx <= yy; i++)
            {
                xx = i;
                if(mult % xx == 0)
                    yy = mult / xx;
                int _gcd = GCD(xx, yy);
                int _m = xx * yy;
                int _lcm = _m / _gcd;
                if(_gcd == gcd &&  _lcm == lcm)
                {
                    _mxx = xx;
                    _myy = yy;
                    flag = true;
                    break;
                }
            }

            if(flag)
            {
                write.write(Integer.toString(_mxx) + " " + Integer.toString(_myy) + "\n");
                System.out.println(_mxx + " " + _myy);
            }
            else
            {
                write.write(Integer.toString(-1) + "\n");
                System.out.println(-1);
            }

        }
        FileFactory.close();
        read.close();
    }
}