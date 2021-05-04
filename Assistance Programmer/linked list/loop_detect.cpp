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
/// using floyd's cycle finding algorithm. it is the faster algorithm
  bool detectLoop(Node* head)
    {
       struct Node *walk = head, *faster = head;
       
       while(walk && faster && faster->next){
           walk = walk->next;
           faster = faster->next->next;
           if(walk == faster) return true;
       }
       
       return false;
    }
