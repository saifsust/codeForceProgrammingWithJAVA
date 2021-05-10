
struct compare{
  bool operator()(Node *node, Node *node2){
      return node->data > node2->data;
  }  
};    
Node *flatten(Node *root)
{
    struct Node *head = NULL, *next= NULL, *bottom = NULL, *temp= NULL;
    priority_queue<Node*, vector<Node*> , compare>pq;
    
    while(root){
       next = root -> next;
       root->next = NULL;
       pq.push(root);
       root = next;
    }
    while(!pq.empty()){
        Node *top = pq.top();
        pq.pop();
        next = top->next;
        bottom = top -> bottom;
        top->next = NULL;
        top->bottom = NULL;
        if(next){
            pq.push(next);
        }
        if(head == NULL){
            head = top;
            temp = head;
        }else{
            temp->bottom = top;
            temp = temp->bottom;
        }
        
        Node *bottomTemp = NULL;
        while(bottom && next && bottom->data < pq.top()->data){
            //cout << bottom -> data << " ";
            bottomTemp = bottom ->bottom;
            bottom->bottom = NULL;
            temp->bottom = bottom;
            temp = temp->bottom;
            bottom = bottomTemp;
        }
        if(bottom){
         //   cout << "Bottom : " << bottom -> data << endl;
            pq.push(bottom);
        }
        
    }
   return head;
}
