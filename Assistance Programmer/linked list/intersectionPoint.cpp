//Function to find intersection point in Y shaped Linked Lists.
int intersectPoint(Node* head1, Node* head2)
{
      map<Node*, bool> mapper;
      while(head1 || head2){
      	if(head1){
      		if(mapper[head1]) return head1->data;
      		mapper[head1] = true;
      		head1 = head1->next;
		  }
		 if(head2){
		 	if(mapper[head2]) return head2->data;
		 	mapper[head2] = true;
		 	head2 = head2->next;
		 } 
	  }
         
      return -1;
}
