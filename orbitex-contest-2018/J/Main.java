import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/**
 *
 *@NAME SAIFUL ISLAM
 *@BATCH SUST CSE 2013-14
 *@Email : saiful.sust.cse@gmail.com
 *@Facebok : https://www.facebook.com/SaifulIslamLitonSust
*/

public class Main
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader rread = new Reader();
    private static Scanner fread = FileFactory.read();

    private static Node root;



    public static void main(String[] args)
    {

        buildTree();

        lavelOrderTraverse();

    }




    private static void lavelOrderTraverse()
    {

        Queue<Node> Q = new LinkedList<>();

        Q.add(root);

        while(!Q.isEmpty()){
            Node peek = Q.poll();
            System.out.println(peek.data);
            if(peek.left != null){
                Q.add(peek.left);
            }
            if(peek.right != null){
                Q.add(peek.right);
            }
        }
    }



    private static void buildTree()
    {

        int num = fread.nextInt();
        root = new Node(num);

        while(fread.hasNext())
        {
            num = fread.nextInt();
            add(num, root);
            //System.out.println(num);
        }

        show(root);

    }

    private static void add(int data, Node node)
    {

        if(node == null)
        {
            return;
        }

        if(node.left == null && node.data > data)
        {
            node.left = new Node(data);
            return;
        }
        if(node.right == null && node.data <= data)
        {
            node.right = new Node(data);
            return;
        }

        if(data < node.data)
        {
            add(data, node.left);
        }
        if(data >= node.data)
        {
            add(data, node.right);
        }
    }


    private static void show(Node root)
    {
        if(root == null) return;
        show(root.left);
        System.out.print(root.data + " ");
        show(root.right);
    }



    // tree node
    private static class Node
    {
        int data;
        Node left, right;
        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
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