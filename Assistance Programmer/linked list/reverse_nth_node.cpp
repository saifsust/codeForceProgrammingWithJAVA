  struct node *reverse (struct node *head, int k)
    { 
        struct node *next=NULL, *tail=NULL, *root=NULL;
        int counter = 0;
        while(head){
            next = head->next;
            if(counter == k){
                counter = 0;
                if(root == NULL) {
                    root = tail;
                    tail = NULL;
                    continue;
                }
                
                struct node *temp = root;
                while(temp -> next) temp = temp->next;
                temp->next = tail;
                tail = NULL;
            }
            ++counter;
            head->next = tail;
            tail = head;
            head = next;
        }
        if(root == NULL) return tail;
        struct node *temp = root;
        while(temp->next) temp = temp->next;
        temp->next = tail;
        return root;
    }
