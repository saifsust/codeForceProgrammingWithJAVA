Node* findIntersection(Node* head1, Node* head2)
{
    
      struct Node *intersected = NULL, *next = NULL, *temp = NULL;
      while(head1 && head2){
      	 // cout << head1 -> data << " " << head2 -> data << endl;
      	 next = NULL;
      	if(head1 -> data == head2->data){
           // cout << head1 -> data << endl;
      		next = head1->next;
      		head1->next = NULL;
      		if(intersected == NULL){
      			 intersected = head1;
      			 temp = intersected;
			  }else{
			  	temp->next = head1;
			  	temp = temp->next;
			  }
			  head1= next;
			  head2= head2->next;
		}else{
			if(head1->data < head2 -> data) head1 = head1->next;
			else head2 = head2->next;
		}
	  }
    return intersected;
    
}
