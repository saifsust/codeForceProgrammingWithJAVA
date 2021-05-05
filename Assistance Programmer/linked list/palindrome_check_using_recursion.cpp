 bool isPalindrome(struct Node **head, struct Node *tail){
        if(tail == NULL) return true;
        bool check = isPalindrome(head, tail->next);
        check = check & ((*head)->data == tail->data);
        if(!check) return false;
        //cout << (*head) -> data << " " << tail->data << endl;
        *head = (*head)->next;
        return check;
    }
    
