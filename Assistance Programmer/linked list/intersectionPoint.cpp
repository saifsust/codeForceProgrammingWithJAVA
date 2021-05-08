int intersectPoint(Node* head1, Node* head2)
{
      struct Node *root1 = head1, *root2 =  head2;
      while(root1 != root2){
      	 root1 = root1->next;
      	 root2 = root2->next;
      	 if(root1 == NULL){
      	 	root1 = head2;
		   }
		 if(root2 == NULL){
		 	root2 = head1;
		 }
	  }
      return root1 == NULL ? -1 : root1 -> data;
}
