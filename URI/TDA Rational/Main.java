
import java.util.*;
import java.io.*;
public class Main
{


    public static void main(String[] args)
    {

        Reader read = new Reader();

        //System.out.println(gcd(read.nextInt(), read.nextInt()));
        int testCase = read.nextInt();
        for(int test = 1; test <= testCase; ++test)
        {
            int n = read.nextInt();
            char op2 = read.next().charAt(0);
            int d = read.nextInt();

            Relation r1 = new Relation(n, op2, d);
            //System.out.println(r1);
            char op = read.next().charAt(0);

            n = read.nextInt();
            op2 = read.next().charAt(0);
            d = read.nextInt();
            Relation r2 = new Relation(n, op2, d);
            //System.out.println(r2);
            final int cons = Integer.MAX_VALUE;
            int ansR1 = cons, ansR2 = cons;
            int priority = operator(r1.op);
            // System.out.println(priority);
            if( priority < 4)
            {
                if(priority == 1) ansR1 = r1.n - r1.d;
                else if(priority == 2)ansR1 = r1.n + r1.d;
                else if(priority == 3)ansR1 = r1.n * r1.d;
            }
            //System.out.println(ansR1);
            priority = operator(r2.op);

            if( priority < 4)
            {
                if(priority == 1) ansR2 = r2.n - r2.d;
                else if(priority == 2)ansR2 = r2.n + r2.d;
                else if(priority == 3)ansR2 = r2.n * r2.d;
            }

            int opPriority = operator(op);
            int ans = 0;
            //System.out.println(ansR1 + "  " + ansR2);
            /**
            *  x ,(-,+,*,/), x2
            **/
            if(ansR1 != cons && ansR2 != cons)
            {
                if(opPriority == 1)
                {
                    r1.n = ansR1;
                    r1.d = ansR2;
                    r1.op = '-';
                    ans = ansR1 - ansR2;
                    print(r1, ans);
                    continue;
                }
                else if(opPriority == 2)
                {
                    r1.n = ansR1;
                    r1.d = ansR2;
                    r1.op = '+';
                    ans = ansR1 + ansR2;
                    print(r1, ans);
                    continue;
                }
                else if(opPriority == 3)
                {
                    r1.n = ansR1;
                    r1.d = ansR2;
                    r1.op = '*';
                    ans = ansR1 + ansR2;
                    print(r1, ans);
                    continue;
                }
                else if(opPriority == 4)
                {
                    /**
                    * x,/,x2
                    **/
                    r1.n = ansR1;
                    r1.d = ansR2;
                    r1.op = '/';
                    int g = gcd(ansR1, ansR2);
                    //  System.out.println(g);
                    ansR1 = ansR1 / g;
                    ansR2 = ansR2 / g;
                    r2.n = ansR1;
                    r2.d = ansR2;
                    r2.op = '/';
                    print(r1, r2);
                    continue;
                }
            }


            //System.out.println(r1 + "  " + r2);


            //else
            //{
            /**
            *  x/y ,/, x2
            **/
            if(ansR1 != cons && ansR2 == cons && opPriority == 4)
            {
                r1.n = ansR1 * r2.d;
                r1.d = r2.n;
                r1.op = '/';
                int g = gcd(r1.n, r1.d);
                r2.n = r1.n / g;
                r2.d = r1.d / g;
                r2.op = '/';
                print(r1, r2);
            }
            else
            {
                /**
                  *  x ,/, x2/y2
                  **/
                if(ansR1 == cons && ansR2 != cons && opPriority == 4)
                {
                    r1.d = r1.d * ansR2;
                    r1.op = '/';
                    int g = gcd(r1.n, r1.d);
                    r2.n = r1.n / g;
                    r2.d = r1.d / g;
                    r2.op = '/';
                    print(r1, r2);
                }
                else
                {
                    /**
                    *  x/y ,/, x2/y2
                    **/
                    if(ansR1 == cons && ansR2 == cons && opPriority == 4)
                    {
                        r1.n = r1.n * r2.d;
                        r1.d = r1.d * r2.n;
                        r1.op = '/';
                        int g = gcd(r1.n, r1.d);
                        r2.n = r1.n / g;
                        r2.d = r1.d / g;
                        r2.op = '/';
                        print(r1, r2);
                    }
                    else
                    {
                        if(opPriority < 4)
                        {

                            /**
                            *  x/y,(-,+,*) ,x2/y2
                            **/
                            if(ansR1 == cons && ansR2 == cons)
                            {
                                //int lcm = (r1.d * r2.d) / gcd(r1.d, r2.d);
                                /**
                                *  x/y - x2/y2
                                **/
                                if(opPriority == 1)
                                {
                                    r1.n = r1.n * r2.d - r2.n * r1.d;
                                    r1.d = r1.d * r2.d;
                                    r1.op = '/';
                                    int g = Math.abs(gcd(r1.n, r1.d));
                                    r2.n = r1.n / g;
                                    r2.d = r1.d / g;
                                    r2.op = '/';
                                    print(r1, r2);

                                }
                                /**
                                *  x/y + x2/y2
                                **/
                                else if(opPriority == 2)
                                {
                                    r1.n = r1.n * r2.d + r2.n * r1.d;
                                    r1.d = r1.d * r2.d;
                                    r1.op = '/';
                                    int g = gcd(r1.n, r1.d);
                                    r2.n = r1.n / g;
                                    r2.d = r1.d / g;
                                    r2.op = '/';
                                    print(r1, r2);
                                }
                                /**
                                *  x/y * x2/y2
                                **/
                                else if(opPriority == 3)
                                {
                                    r1.n = r1.n * r2.n;
                                    r1.d = r1.d * r2.d;
                                    r1.op = '/';
                                    int g = gcd(r1.n, r1.d);
                                    r2.n = r1.n / g;
                                    r2.d = r1.d / g;
                                    r2.op = '/';
                                    print(r1, r2);
                                }
                            }
                            else
                            {
                                /**
                                *  x,(-,+,*) ,x2/y2
                                **/
                                if(ansR1 != cons && ansR2 == cons)
                                {
                                    if(opPriority == 1)
                                    {
                                        r1.n = ansR1 * r2.d - r2.n;
                                        r1.d = r2.d;
                                        r1.op = '/';
                                        int g = gcd(r1.n, r1.d);
                                        r2.n = r1.n / g;
                                        r2.d = r1.d / g;
                                        r2.op = '/';
                                        print(r1, r2);

                                    }
                                    else if(opPriority == 2)
                                    {
                                        r1.n = ansR1 * r2.d + r2.n;
                                        r1.d = r2.d;
                                        r1.op = '/';
                                        int g = gcd(r1.n, r1.d);
                                        r2.n = r1.n / g;
                                        r2.d = r1.d / g;
                                        r2.op = '/';
                                        print(r1, r2);
                                    }
                                    else if(opPriority == 3)
                                    {
                                        r1.n = ansR1 * r2.n;
                                        r1.d = r2.d;
                                        r1.op = '/';
                                        int g = gcd(r1.n, r1.d);
                                        r2.n = r1.n / g;
                                        r2.d = r2.d / g;
                                        r2.op = '/';
                                        print(r1, r2);
                                    }
                                }
                                else
                                {
                                    /**
                                    *  x/y,(-,+,*) ,x2
                                    **/
                                    if(ansR1 != cons && ansR2 == cons)
                                    {
                                        if(opPriority == 1)
                                        {
                                            r1.n = r1.n - r1.d * ansR2;
                                            r1.op = '/';
                                            int g = gcd(r1.n, r1.d);
                                            r2.n = r1.n / g;
                                            r2.d = r1.d / g;
                                            r2.op = '/';
                                            print(r1, r2);

                                        }
                                        else if(opPriority == 2)
                                        {
                                            r1.n = r1.n + r1.d * ansR2;
                                            r1.op = '/';
                                            int g = gcd(r1.n, r1.d);
                                            r2.n = r1.n / g;
                                            r2.d = r1.d / g;
                                            r2.op = '/';
                                            print(r1, r2);
                                        }
                                        else if(opPriority == 3)
                                        {
                                            r1.n = r1.n * ansR2;
                                            r1.op = '/';
                                            int g = gcd(r1.n, r1.d);
                                            r2.n = r1.n / g;
                                            r2.d = r2.d / g;
                                            r2.op = '/';
                                            print(r1, r2);
                                        }
                                    }

                                }
                            }

                        }


                    }

                }

            }

            // }

            //int p1 =
            //}


        }

    }

    static void print(Relation r, int ans)
    {
        System.out.println(r.n + "" + r.op + "" + r.d + " = " + ans);
    }
    static void print(Relation r1, Relation r2)
    {
        System.out.println(r1 + " = " + r2);
    }

    static int gcd(int m, int n)
    {
        if(m == 0) return n;
        //System.out.println(m + "  " + n);
        return gcd(n % m, m);
    }


    static int operator(char chr)
    {
        switch(chr)
        {
        case '-':
            return 1;
        case '+':
            return 2;
        case '*' :
            return 3;
        case '/' :
            return 4;
        }
        return Integer.MAX_VALUE;
    }
    static class Relation
    {
        public int n, d;
        public char op;
        public Relation(int n, char op, int d)
        {
            this.n = n;
            this.d = d;
            this.op = op;
        }
        public  String toString()
        {
            return this.n + "" + this.op + "" + this.d;
        }
    }



    // faster input

    static class Reader
    {
        private BufferedReader buffer;
        private StringTokenizer tokenizer;
        public Reader()
        {
            this.buffer = new BufferedReader(new InputStreamReader(System.in), 31768);
            this.tokenizer = null;
        }
        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try
                {
                    tokenizer = new StringTokenizer(buffer.readLine());

                }
                catch(Exception ex)
                {
                    return "";
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt()
        {
            try
            {
                return Integer.parseInt(next());
            }
            catch(Exception ex)
            {
                return -1;
            }
        }
    }
}