   Node* pairWiseSwap(struct Node* head) 
    {
		struct Node *root=NULL, *next = NULL, *next2 = NULL, *tempHead = head, *first, *second;
        
		while(tempHead){
			next2 = next = first = second = NULL;
			first = tempHead;
			next = tempHead->next;
			tempHead->next = NULL;
            
			if(next){
				second = next;
				next2 = next->next;
				next->next = NULL;
			}
            
			if(root == NULL){
				if(second){
					root = second;
					second->next = first;
				}else root = first;
				first->next = NULL;
			}else{
                struct Node *temp = root;
				while(temp->next) temp = temp->next;
				if(second){
					temp->next = second;
					second->next = first;
				}else{
					temp->next = first;
					first->next = NULL;
				}
			}
			if(next2){
				tempHead = next2;
			}else tempHead = next;
		}
		return root;
    }
