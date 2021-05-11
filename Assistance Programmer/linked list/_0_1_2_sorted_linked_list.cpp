   //Function to sort a linked list of 0s, 1s and 2s.
    Node* segregate(Node *head) {
        
        Node *_1s = NULL, *_2s = NULL, *_0s = NULL, *temp0=NULL,*temp1=NULL, *temp2=NULL, *next = NULL;
        while(head){
            next = head -> next;
            head->next = NULL;
            if(head -> data == 0){
                if(_0s == NULL){
                    _0s = head;
                    temp0=_0s;
                }else{
                    temp0->next = head;
                    temp0 = temp0->next;
                }
            }
            if(head -> data == 1){
                if(_1s == NULL){
                     _1s = head;   
                     temp1 = _1s;
                    }else{
                        temp1->next = head;
                        temp1 = temp1->next;
                    }
            }
            if(head -> data == 2){
                if(_2s == NULL){
                    _2s = head;
                    temp2 = head;
                }else{
                    temp2->next = head;
                    temp2 = temp2->next;
                }
            }
            head = next;
        }
        if(temp0 && temp1 && temp2){
            temp0->next = _1s;
            temp1->next = _2s;
        }else if(temp0 && temp2){
             temp0->next = _2s;
        }else if( temp1 && temp2){
            temp1->next = _2s;
        }else if(temp0 && temp1){
            temp0->next = _1s;
        }
        if(_0s) return _0s;
        if(_1s) return _1s;
         return _2s; 
    }
