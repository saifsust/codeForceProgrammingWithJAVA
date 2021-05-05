//Function to check whether the list is palindrome.
    bool isPalindrome(Node *head)
    {
        queue<int>q;
        struct Node *slow = head, *fast = head;
        while(slow && fast && fast->next)
        {
            q.push(slow->data);
            slow = slow ->next;
            fast=fast->next->next;
        }
        struct Node *rev = NULL;
        while(slow){
            struct Node *next = slow->next;
            slow->next = rev;
            rev = slow;
            slow = next;
        }
        
        while(!q.empty() && rev){
            if(q.front() != rev->data) return false;
            q.pop();
            rev = rev->next;
        }
        
        return true;
    }
