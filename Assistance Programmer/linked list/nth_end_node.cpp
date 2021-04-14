void nthEndNode(struct Node *head,int k){
	struct Node *temp, *temp2;
	temp  = temp2 = head;
	while(temp){
		if(k<=0){
			temp2=temp2->next;
		}
		k--;
		temp = temp->next;
	}
 
 printf("%d", temp2 == NULL ? -1000: temp2->val);
}
