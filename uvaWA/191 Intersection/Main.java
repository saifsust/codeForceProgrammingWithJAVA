import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{

    public static void main(String[] args) throws Exception
    {


        //Scanner read = new Scanner(System.in);
        Scanner read = FileFactory.read();
        int testCase = read.nextInt();
        double x, y;
        Point solve = null;
        BufferedWriter write = FileFactory.write();
        for(int i = 1; i <= testCase; i++)
        {
            Point start = readPoint(read);
            Point end = readPoint(read);
            Point leftTop = readPoint(read);
            Point rightBottom = readPoint(read);
            Point leftBottom = Point.leftBottom(leftTop, rightBottom);
            Point rightTop = Point.rightTop(leftTop, rightBottom);
            Equation line = new Equation(start, end);
            Equation recTopEq = new Equation(rightTop, leftTop);
            solve = Equation.solveEquations(recTopEq, line);

            if(!crossLimit(start, end, solve) &&  solve.x >= leftTop.x &&  solve.x <= rightTop.x)
            {
                System.out.println("T");
                writer(write, "T");
                continue;
            }

            Equation recLeftEq = new Equation(leftTop, leftBottom);
            solve = Equation.solveEquations(recLeftEq, line);

            if(!crossLimit(start, end, solve) && solve.y >= leftBottom.y && solve.y <= leftTop.y)
            {
                System.out.println("T");
                writer(write, "T");
                continue;
            }

            Equation recBottomEq = new Equation(leftBottom, rightBottom);

            solve = Equation.solveEquations(recBottomEq, line);




            if(!crossLimit(start, end, solve) &&  solve.x >= leftBottom.x && solve.x <= rightBottom.x)
            {
                System.out.println("T");
                writer(write, "T");
                continue;
            }

            Equation recRightEq = new Equation(rightBottom, rightTop);

            solve = Equation.solveEquations(recRightEq, line);
            if(!crossLimit(start, end, solve) && solve.y >= rightBottom.y && solve.y <= rightTop.y)
            {
                System.out.println("T");
                writer(write, "T");
                continue;
            }
            if( start.x >= leftBottom.x && start.x <= rightBottom.x && start.y >= leftBottom.y && start.y <= leftTop.y)
            {
                System.out.println("T");
                writer(write, "T");
                continue;
            }
            if(start.x <= leftBottom.x && start.x >= rightBottom.x && start.y >= leftBottom.y && start.y <= leftTop.y)
            {
                System.out.println("T");
                writer(write, "T");
                continue;
            }
            System.out.println("F");
            writer(write, "F");
        }
        write.close();
        read.close();

    }

    private static boolean crossLimit(Point start, Point end, Point solve)
    {
        if(start.x < solve.x && end.x < solve.x)return true;
        if(start.x > solve.x && end.x > solve.x) return true;
        if(start.x == end.x && start.y < solve.y && end.y < solve.y)return true;
        if(start.x == end.x && start.y > solve.y && end.y > solve.y)return true;
        if(start.y == end.y && start.x < solve.x && end.x < solve.x)return true;
        if(start.y == end.y && start.x > solve.x && end.x > solve.x)return true;
        return false;

    }

    private static void writer(BufferedWriter write, String str)throws Exception
    {
        write.write(str);
        write.newLine();
        write.flush();
    }
    private static Point readPoint(Scanner read)
    {
        double x, y;
        x = read.nextDouble();
        y = read.nextDouble();
        return new Point(x, y);

    }

}

class Equation
{
    public double a, b, c;

    public Equation(Point p1, Point p2)
    {
        this.a = p1.getA(p1, p2);
        this.b = p1.getB(p1, p2);
        this.c = p1.getC(p1, p2);
    }

    public static Point solveEquations(Equation e1, Equation e2)
    {
        try
        {
            double x = e1.b * e2.c - e2.b * e1.c;
            x = x / crossMultiple(e1, e2);
            //System.out.println(crossMultiple(e1, e2));
            double y = e2.a * e1.c - e1.a * e2.c;
            y = y / crossMultiple(e1, e2);
            //return null;
            return new Point(x, y);
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    public static double crossMultiple(Equation e1, Equation e2)
    {
        return e1.a * e2.b - e2.a * e1.b;
    }

    public String toString()
    {
        return "( a,b,c )= ( " + this.a + " , " + this.b + " , " + this.c + " )";
    }

}


class Point
{
    public double x, y;
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;

    }

    public  static double dx(Point p1, Point p2)
    {
        return p2.x - p1.x;
    }
    public static double dy(Point p1, Point p2)
    {
        return p2.y - p1.y;
    }

    public static double sqDx(Point p1, Point p2)
    {
        return Math.pow(dx(p1, p2), 2);
    }
    public static double sqDy(Point p1, Point p2)
    {
        return Math.pow(dy(p1, p2), 2);
    }
    public static double distance(Point p1, Point p2)
    {
        return Math.sqrt(sqDx(p1, p2) + sqDy(p1, p2));
    }
    public static Point leftBottom(Point leftTop, Point rightBottom)
    {
        return new Point(leftTop.x, rightBottom.y);
    }
    public static Point rightTop(Point leftTop, Point rightBottom)
    {
        return new Point(rightBottom.x, leftTop.y);
    }


    public static double getC(Point p1, Point p2)
    {
        return -dy(p1, p2) * p2.x + dx(p1, p2) * p2.y;
    }
    public static double getA(Point p1, Point p2)
    {
        return dy(p1, p2);
    }
    public static double getB(Point p1, Point p2)
    {
        return -dx(p1, p2);
    }


    public String toString()
    {
        return "(x ,y) = ( " + this.x + " ," + this.y + " )";
    }

}