  bool detectLoop(Node* head)
    {
       struct Node *walk = head;
       map<long long , bool>mapper;
       while(walk != NULL){
           long long address = (long long) walk;
           if(mapper[address] == true) return true;
           mapper[address] = true;
           walk=walk->next;
       }
       
       return false;
    }
