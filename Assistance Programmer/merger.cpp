struct Node* merge(struct Node *root, struct Node *head){
	struct Node *merge = NULL, *mrg=NULL;
   
    while(root && head){ 
		if(root->val > head->val){
			if(merge == NULL) mrg = new Node(head->val);
			else merge->next = new Node(head->val);
		 	head=head->next;
		}else {
			if(merge == NULL) mrg = new Node(root->val);
			else merge->next = new Node(root->val);
			root=root->next;
		}
		if(!merge) merge = mrg;
		else merge = merge->next;
	}
	while(head){
		merge->next = new Node(head->val);
		head  = head ->next;
		merge= merge->next;
	}
	while (root)
	{
		merge -> next = new Node(root->val);
		root = root->next;
		merge = merge -> next;
	}
	
	return mrg;
}
