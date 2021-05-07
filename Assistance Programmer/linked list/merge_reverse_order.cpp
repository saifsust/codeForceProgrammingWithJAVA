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





