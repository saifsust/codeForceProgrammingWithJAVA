// { Driver Code Starts
// C program to find n'th Node in linked list
#include <stdio.h>
#include <stdlib.h>
#include<iostream>
using namespace std;

/* Link list Node */
struct Node
{
    int data;
    struct Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
    
};

void append(struct Node** head_ref, struct Node **tail_ref,
            int new_data)
{
    struct Node* new_node = new Node(new_data);
    
    if (*head_ref == NULL)
        *head_ref = new_node;
    else
        (*tail_ref)->next = new_node;
    *tail_ref = new_node;
}

/* Function to get the middle of the linked list*/
int maxPalindrome(Node *);


/* Driver program to test above function*/
int main()
{
    int T,n,l;
    cin>>T;

    while(T--)
    {
        struct Node *head = NULL,  *tail = NULL;

        cin>>n;
        for (int i=1; i<=n; i++)
        {
            cin>>l;
            append(&head, &tail, l);
        }
      

       cout << maxPalindrome(head)<<endl;
    }
    return 0;
}


// } Driver Code Ends


/* The Node is defined 
  /* Link list Node
struct Node
{
    int data;
    struct Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
    
};
*/

/*The function below returns an int denoting
the length of the longest palindrome list. */
int maxPalindrome(Node *head)
{
    Node *prev = NULL, *temp = head, *next = NULL;
    int curr = 0, start = 0, last = 0, maxLen = 0;
    while(temp){
        ++curr;
        next = temp->next;
        Node *palin = prev;
        //if(prev) cout << prev -> data << " " << temp ->data << endl;
        if(!start){
            if(prev){
              if( prev->data == temp->data){
                    start = curr-1;
                    last = curr;
                  
              }
              if(prev->next){
                if(prev->next->data == temp->data){
                    start = curr-2;
                    last = curr;
                }
                maxLen = max(maxLen , last - start + 1);
            }
            }
        }else{
             int currIn = curr;
             cout <<"Head : " <<temp -> data << endl;
             cout << "M : ";
            while(palin && currIn >start ){
                cout << palin->data << " ";
                palin = palin->next;
                --currIn;
            }
            cout << endl;
            if(palin) cout <<"last : "<< palin->data << endl;
            if(palin && palin->data == temp->data){
                --start;
                last = curr;
                maxLen = max(maxLen , last - start + 1);
            }else start = 0;
        }
       
        temp->next = prev;
        prev = temp;
        temp = next;
    }
    return maxLen;
}
