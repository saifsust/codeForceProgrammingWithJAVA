import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


public class Main{


   private static class Node{
   	 public int data;
   	 public Node next;
   	 
   	 public Node(int data){
   	 	this.data =data;
   	 	this.next = null;
   	 }

   }


 private static Node root;


// insert a value into a linked list back

   private static void push_back(int data){

     if(root == null){
     	root = new Node(data);
     	return;
     }

     Node temp =root;

     while(temp.next != null){
     	temp=temp.next;
     }

     temp.next = new Node(data);

   }


// print a linked list

   private static void printAll(){

    Node temp =root;

    while(temp != null){
    	System.out.print(temp.data+"-->");
    	temp = temp.next;
    }
    System.out.println("null");


   }




// insert a value into a linked list front

   private static void push_front(int data){

    if(root == null){
    	root = new Node(data);
    	return;
    }

    Node temp = root;
    Node front = new Node(data);
    front.next = temp;
    root = front;
   }



// pop a value from back
    private static int pop_back(){
      
        if(root == null) return -1;
        Node temp = root,prev = null,next = null,tempRoot = null;
        if(temp.next == null) {
        	root = null;
        	return 1;
        }
        while(temp.next != null){

        	if(temp.next.next == null){
        		temp.next=null;
        		break;
        	}
        	temp = temp.next;
        }
        return 1;
    }



    // pop a value from a linked list front


    private static int pop_front(){

    	if(root == null ) return -1;
    	if(root.next == null) {
    	     root = null;
    	  	return 1;
    	}


    	Node temp = root,next = null,prev=null;
    	next = temp.next;
    	temp.next = null;
    	root = next;
    	return 1;

    }



// insert a list into linked list back

    private static void push_back_list(List<Integer > list){
    	Node temp = root;
    	while(root !=null && temp.next != null ){
    		temp = temp.next;
    	}
    	for(int data : list){
    		
    		if(root == null){
    			root = new Node(data);
    			temp = root;
    			continue;

    		}else{
    			temp.next = new Node(data);
    		}

    		temp = temp.next;
    	}

    }


// insert a list into a linked list  front

    private static void push_front_list(List<Integer> list){


    	Node temp = root;


    	for(Integer data : list){

              if(root == null){
              	root = new Node(data);
              	temp = root;
              	continue;
              }else{

              	Node next = temp;
              	Node head = new Node(data);
              	head.next = next;
              	temp = head;
              }
    	}
    	root = temp;

    }


// find the middle point of a list

    private static int middle(){
    	Node fast= root,slow = root;

    	while(fast.next != null && fast.next.next != null){
    		fast = fast.next.next;
    		slow=slow.next;
    	}

    	return slow.data;
    }




	public static void main(String[] args){
     

         //push_back(10);
         push_back(13);
         push_front(11);
         push_back(14);
         push_front(10);
         push_back(15);
         printAll();
         pop_back();
         pop_back();

         printAll();

         List<Integer> list = new ArrayList<>();

         list.add(120);
         list.add(130);

         push_back_list(list);

         push_front_list(list);

         printAll();
         System.out.println(middle());

         pop_front();
          pop_front();
         printAll();


	}
}