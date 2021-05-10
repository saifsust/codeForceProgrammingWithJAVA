/**
* linked list rotated according to counter-clockwise with reversing the second part 
*/

//Function to rotate a linked list.
    Node* rotate(Node* head, int k)
    {
		struct Node *temp = head, *rev = NULL, *next = NULL;
		while(temp && k){
			next = temp -> next;
			temp -> next = rev;
			rev = temp;
			temp = next;
			k--;
		}
		struct Node *rotated = temp;
		if(temp){
			while(temp ->next)  temp = temp->next;
			temp->next = rev;
		}else rotated = rev;
		return rotated;		     	   
    }

// rotated the linked list without reversing the second part
  //Function to rotate a linked list.
    Node* rotate(Node* head, int k)
    {
		struct Node *temp = head,*prev = NULL, *rotated = NULL, *next = NULL;
		while(temp && k){
			prev = temp;
			temp = temp-> next;
			k--;
		}
	  
	   if(temp){
	   	 rotated = temp;
		while(temp -> next)	temp = temp -> next;
		 if(prev){
		 	prev -> next = NULL;
		   temp->next = head;	
		 }
		 return rotated;
	   }else return head;		     	   
    }
