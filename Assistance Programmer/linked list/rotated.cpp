/**
* linked list rotated according to counter-clockwise. 
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
