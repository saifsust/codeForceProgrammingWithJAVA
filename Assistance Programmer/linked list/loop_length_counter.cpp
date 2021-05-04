int countNodesinLoop(struct Node *head)
{
    map<Node*, bool>mapper;
    struct Node *walk = head;
    bool isLoop= false;
    int counter = 0;
    while(walk != NULL){
        if(mapper[walk]){
            isLoop = true;
            break;
        } 
        ++counter;
        mapper[walk] = true;
        walk = walk->next;
    }
    if(isLoop){
    struct Node *temp = head;
    while( temp != walk){
        --counter;
        temp=temp->next;
    }
    return counter;
    }
    return 0;
    
}
