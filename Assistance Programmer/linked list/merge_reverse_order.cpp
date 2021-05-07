// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

/* Link list Node */
struct Node
{
    int data;
    struct Node* next;
};

void print(struct Node *Node)
{
    while (Node!=NULL)
    {
        cout << Node->data << " ";
        Node = Node->next;
    }
}

struct Node * mergeResult(struct Node *node1,struct Node *node2);

Node *newNode(int data)
{
    Node *temp = new Node;
    temp->data = data;
    temp->next = NULL;
    return temp;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	freopen("in.txt", "r", stdin);
	
    int T;
    cin>>T;
    cout << T << endl;
    while(T--)
    {
        int nA;
        cin>>nA;
        int nB;
        cin>>nB;

        struct Node* headA=NULL;
        struct Node* tempA = headA;

        for(int i=0;i<nA;i++)
        {
            int ele;
            cin>>ele;
            if(headA==NULL)
            {
                headA=tempA=newNode(ele);

            }else{
                tempA->next = newNode(ele);
				tempA=tempA->next;
            }
        }

        struct Node* headB=NULL;
        struct Node* tempB = headB;


        for(int i=0;i<nB;i++)
        {
            int ele;
            cin>>ele;
            if(headB==NULL)
            {
                headB=tempB=newNode(ele);

            }else{
                tempB->next = newNode(ele);
				tempB=tempB->next;
            }
        }

        struct Node* result = mergeResult(headA,headB);

        print(result);
        cout<<endl;


    }
}
// } Driver Code Ends


/*

The structure of linked list is the following

struct Node
{
int data;
Node* next;
};

*/

struct Node * mergeResult(Node *node1,Node *node2)
{
	 struct Node *rev = NULL, *rev2 = NULL, *root = NULL, *next = NULL;
	 
	 next = NULL;
	 while(node1){
	 	//cout << node1 -> data << endl;
	 	next = node1->next;
	 	node1->next = rev;
	 	rev = node1;
	 	node1 = next;
	 }
	 
	 next = NULL;
	 while(node2){
	 	next = node2->next;
	 	node2 -> next = rev2;
	 	rev2 = node2;
	 	node2 = next;
	 }
	 
	 next = NULL;
	 if( rev && rev2 && rev->data > rev2->data){
	 	next = rev->next;
	 	rev->next = NULL;
	 	root = rev;
	 	rev = next;
	 }else{
	 	next = rev2->next;
	 	rev2->next = NULL;
	 	root = rev2;
	 	rev2 = next;
	 }
	 struct Node *temp = root;
	 while(rev && rev2){
	 	next = NULL;
	 	if(rev -> data > rev2->data){
			next = rev -> next;
			rev ->next = NULL;
	 		temp->next = rev;
	 		rev = next;
		 }else{
		 	next = rev2->next;
		 	rev2->next = NULL;
		 	temp->next = rev2;
			rev2 = next;
		 }
		 temp=temp->next;
	 }
	 next = NULL;
	 
	 while(rev){
	 	next = rev->next;
	 	rev->next  =  NULL;
	 	temp->next = rev;
	 	temp = temp->next;
	 	rev = next;
	 }
	 
	 while(rev2){
	 	next = rev2->next;
	 	rev2->next = NULL;
	 	temp->next = rev2;
	 	temp = temp->next;
	 	rev2 = next;
	 }
	 
	 
	 return root;
	
    
}





