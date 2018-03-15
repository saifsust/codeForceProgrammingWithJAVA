import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args) throws Exception
    {
        //Scanner read = new Scanner(System.in);
        Scanner read = FileFactory.read();
        BufferedWriter writer = FileFactory.write();
        int n = read.nextInt();
        for(int i = 1; i <= n + 2; i++)
        {
            if(i == 1)
            {
                System.out.println("INTERSECTING LINES OUTPUT");
                write(writer, "INTERSECTING LINES OUTPUT");
                continue;
            }
            if(i == n + 2)
            {
                System.out.println("END OF OUTPUT");
                write(writer, "END OF OUTPUT");
                continue;
            }

            Point p1 = readPoint(read);
            Point p2 = readPoint(read);
            Point p3 = readPoint(read);
            Point p4 = readPoint(read);
            Equation eq1 = new Equation(p1, p2);
            Equation eq2 = new Equation(p3, p4);
            System.out.println(eq1 + "  " + eq2);
            if(isInLine(eq1, eq2))
            {
                System.out.println("LINE");
                write(writer, "LINE");
                continue;
            }

            if(isParallel(eq1, eq2))
            {
                System.out.println("NONE");
                write(writer, "NONE");
                continue;
            }

            Point intersect = Equation.intersection(eq1, eq2);


            System.out.printf("POINT %.2f %.2f\n", intersect.x, intersect.y);
            write(writer, "POINT " + String.format("%.2f %.2f", intersect.x, intersect.y));

            //System.out.println(eq1 + " " + eq2);



        }
        read.close();
        writer.close();

    }
    private static void write(BufferedWriter write, String str)throws Exception
    {
        write.write(str);
        write.newLine();
        write.flush();
    }

    private static boolean isInLine(Equation eq1, Equation eq2)
    {
        if(Math.abs(eq1.a) == 0.0 && Math.abs(eq2.a) == 0.0 && Math.abs(eq1.c) == 0.0 && Math.abs(eq2.c) == 0.0)return true;
        if(Math.abs(eq1.a) == 0.0 && Math.abs(eq2.a) == 0.0 && Math.abs(eq1.c) != 0.0 && Math.abs(eq2.c) != 0.0 && eq1.b / eq2.b == eq1.c / eq2.c)return true;
        if(Math.abs(eq1.b) == 0.0 && Math.abs(eq2.b) == 0.0 && Math.abs(eq1.c) == 0.0 && Math.abs(eq2.c) == 0.0)return true;
        if(Math.abs(eq1.b) == 0.0 && Math.abs(eq2.b) == 0.0 && eq1.a / eq2.a == eq1.c / eq2.c)return true;
        if(Math.abs(eq1.c) == 0.0 && Math.abs(eq2.c) == 0.0 && eq1.a / eq2.a == eq1.b / eq2.b)return true;
        if(eq1.a / eq2.a == eq1.b / eq2.b  && eq1.a / eq2.a == eq1.c / eq2.c && eq1.b / eq2.b == eq1.c / eq2.c)return true;
        return false;
    }

    private static boolean isParallel(Equation eq1, Equation eq2)
    {
        if(Math.abs(eq1.a) == 0.0 && Math.abs(eq2.a) == 0.0 && ( Math.abs(eq1.c) == 0.0 || Math.abs(eq2.c) == 0.0 ))return true;
        if(Math.abs(eq1.a) == 0.0 && Math.abs(eq2.a) == 0.0 && eq1.b / eq2.b != eq1.c / eq2.c )return true;
        if(Math.abs(eq1.b) == 0.0 && Math.abs(eq2.b) == 0.0 && ( Math.abs(eq1.c) == 0.0 || Math.abs(eq2.c) == 0.0 ))return true;
        if(Math.abs(eq1.b) == 0.0 && Math.abs(eq2.b) == 0.0 && eq1.a / eq2.a != eq1.c / eq2.c )return true;
        if(eq1.a / eq2.a == eq1.b / eq2.b  && eq1.c != eq2.c)return true;
        return false;

    }

    private static Point readPoint(Scanner read)
    {
        return new Point(read.nextDouble(), read.nextDouble());
    }

 

}

class Equation
{
    public double a, b, c;

    public Equation(Point p1, Point p2)
    {
        this.a = Point.dy(p1, p2);
        this.b = -Point.dx(p1, p2);
        this.c = Point.dx(p1, p2) * p2.y - Point.dy(p1, p2) * p2.x;

    }


    public static double dd(Equation eq1, Equation eq2)
    {
        return eq1.a * eq2.b - eq2.a * eq1.b;
    }
    public static Point intersection(Equation eq1, Equation eq2)
    {

        double x = eq1.b * eq2.c - eq2.b * eq1.c;
        x = x / dd(eq1, eq2);
        double y = eq2.a * eq1.c - eq1.a * eq2.c;
        y = y / dd(eq1, eq2);
        return new Point(x, y);
    }

    public String toString()
    {
        return "(a,b,c)=(" + this.a + "," + this.b + "," + this.c + ")";
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

    public static double dx(Point p1, Point p2)
    {
        return p2.x - p1.x;
    }
    public static double dy(Point p1, Point p2)
    {
        return p2.y - p1.y;
    }


    public double distance(Point p1, Point p2)
    {
        double sqr = Math.pow(dx(p1, p2), 2) + Math.pow(dy(p1, p2), 2);
        return Math.sqrt(sqr);
    }

    public String toString()
    {
        return "(x,y)=(" + this.x + "," + this.y + ")";
    }

}