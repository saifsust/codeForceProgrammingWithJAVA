bool isPalindrome(Node *head)
    {
        struct Node *rev = NULL, *walk = head, *root = NULL, *temp = NULL, *next=NULL;
        while(walk){
            if(root == NULL){
                root = new Node(walk->data);
                temp = root;
            }
            else{
                temp->next = new Node(walk->data);
                temp = temp -> next;
            }
            next = walk->next;
            walk->next = rev;
            rev = walk;
            walk = next;
        }
        while(rev){
            //cout << root->data << " " << rev->data << endl;
            if(root->data != rev->data) return false;
            root=root->next;
            rev=rev->next;
        }
        return true;
    }
