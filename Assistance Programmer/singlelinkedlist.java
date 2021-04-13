import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    private void solution(){
        insert(4);
        insert(8);
        insert(10);
        insert(13);
        insert(34);
        print();
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            Node node = getNthNodeFromHead(n);
            System.out.printf("nth node from head of the single linked list : ");
            System.out.println(node == null ? -100000 : node.val);
            node = getNthNodeFromTail(n);
            System.out.printf("nth node from tail of th single linked list : ");
            System.out.println(node == null ? -100000: node.val);
        }
         
     }
    
    
    private Scanner scanner = new Scanner(System.in);
    /**
     * Single LinkedList Node 
     */
    private class Node{
        public int val;
        public Node next;
        public Node(){}
        public Node(int _val){
            this.val = _val;
            this.next = null;
        }
    }
   /**
    * head of the single linkedlist
    */
    private Node root = null;

    /**
     * signle linkedlist insert node
     */
    private void insert(int val){
        if(root == null) {
            root = new Node(val);
            return;
        }
        Node temp = root;
        while(temp.next != null) temp = temp.next;
        temp.next = new Node(val);
    }

    /**
     * print the single linked list
     */
    private void print(){
        Node temp = root;
        while(temp != null){
            System.out.printf("%d ", temp.val);
            temp = temp.next;
        }
        System.out.println();
    }
    private void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.printf("%d ", temp.val);
            temp = temp.next;
        }
        System.out.println();
    }
    /**
     * nth node from head
     */
    private Node getNthNodeFromHead(int n){
          Node temp = root;
          while(temp != null && n > 1){
              temp = temp.next;
              n--;
          }
          if(temp == null) return null;
          return temp;
    }

  /**
   * nth node from tail
   */
   private Node getNthNodeFromTail(int n){
       Node temp = root;
       Node prev = null;
       while(temp != null){
           Node tail = temp.next;
            temp.next = prev;
            prev = temp;
            temp = tail;
       }
       while(prev != null && n > 1){
          n--;
          prev = prev.next;
       }
       return prev;
   }
    
      /**
    * print middle of the linked list
    */

    private void middle(){
          Node doubleNext=root, singleNext= root;
          while(doubleNext != null && doubleNext.next != null){
             doubleNext = doubleNext.next.next;
              singleNext=singleNext.next;
          }
          System.out.printf("%d", singleNext.val);
    }

  

    public static void main(String... args){
        new Main().solution();   
    }
}
