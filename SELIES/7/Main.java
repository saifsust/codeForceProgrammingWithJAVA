import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader read = new Reader();
    private static Scanner fread = FileFactory.read();

    public static void main(String[] args)
    {


        System.out.println("Enter Root : ");

        int data = sread.nextInt();
        Tree root = new Tree(data);
        while(sread.hasNext())
        {
            System.out.println("Enter child : ");

             data = sread.nextInt();

            root.addNode(data, root);
            Tree.inorderPrint(root);




        }
        /*
                Tree root = new Tree(1000);
                root.addNode(999, root);
                root.addNode(100000, root);
                Tree.inorderPrint(root);*/





    }


    private static class Tree
    {
        public static Tree root;
        public Tree left, rigth;
        public int data;
        public static int node_w = 1;



        public Tree()
        {

        }
        public Tree(int data)
        {
            this.left = null;
            this.rigth = null;
            this.data = data;
        }





        public  static void addNode(int data, Tree head)
        {
            if(head == null)
            {
                head = new Tree(data);
                return;
            }


            if(head.left == null && head.data>data)
            {
                head.left = new Tree(data);
                return;
            }
            if(head.rigth == null && head.data<=data)
            {
                head.rigth = new Tree(data);
                return;
            }

            if(head.data > data)
            {
                addNode(data, head.left);
            }
            if(head.data <= data)
            {
                addNode(data, head.rigth);
            }


        }


        public static void inorderTraverse()
        {
            inorderPrint(root);
        }

        public static void inorderPrint(Tree root)
        {

            if(root == null) return;


            inorderPrint(root.left);
            System.out.print(root.data + "  ");
            inorderPrint(root.rigth);
        }




    }





    //faster input reader

    private static class Reader
    {
        private BufferedReader buffered;
        private StringTokenizer  tokenizer;
        public Reader()
        {
            this.buffered = new BufferedReader(new InputStreamReader(System.in), 31768);
            this.tokenizer = null;
        }

        public String nextLine()
        {
            try
            {
                return buffered.readLine();

            }
            catch(Exception ex)
            {
                return "eof";
            }
        }

        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                tokenizer = new StringTokenizer(nextLine());
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

        public long nextLong()
        {
            try
            {
                return Long.parseLong(next());
            }
            catch(Exception ex)
            {
                return -1;
            }
        }

        public double nextDouble()
        {
            try
            {
                return Double.parseDouble(next());
            }
            catch(Exception ex)
            {
                return -1.0;
            }
        }


    }
}