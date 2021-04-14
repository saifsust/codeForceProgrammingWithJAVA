struct Node* reverse_according_to_n(struct Node *head, int n){
	struct Node *prev_from_head=NULL, *prev_from_tail=NULL, *next=NULL;
	while(head){
		next = head->next;
		if(n>0){
			head->next= prev_from_head;
			prev_from_head = head;
		}else{
			head->next = prev_from_tail;
			prev_from_tail = head;
		}
        n--;
		head = next;
	}
	struct Node *temp= prev_from_head;
	while(temp->next) temp = temp->next;
	temp->next = prev_from_tail;
	return prev_from_head;
}

/**
 * better than first solution
**/


struct Node* reverse_according_to_n(struct Node *head, int n){
	struct Node *prev_from_head=NULL, *prev_from_tail=NULL, *next=NULL, *tail=NULL;
	while(head){
		next = head->next;
		if(n>0){
			head->next= prev_from_head;
			if(prev_from_head == NULL) tail = head;
			prev_from_head = head;
		}else{
			head->next = prev_from_tail;
			prev_from_tail = head;
		}
        n--;
		head = next;
	}
	tail->next = prev_from_tail;
	return prev_from_head;
}
