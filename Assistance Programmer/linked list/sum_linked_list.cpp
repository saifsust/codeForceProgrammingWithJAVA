
class Solution
{
    public:
    //Function to add two numbers represented by linked list.
    struct Node* addTwoLists(struct Node* first, struct Node* second)
    {
    	 struct Node *revFirst = NULL, *revSecond = NULL, *next = NULL;
    	 while(first || second){
    	 	if(first){
    	 		next = first -> next;
    	 		first-> next = revFirst;
    	 		revFirst = first;
    	 		first = next;
			 }
			if(second){
				next = second -> next;
				second->next = revSecond;
				revSecond = second;
				second = next;
			}
		 }
		   int carry = 0;
		   struct Node *sumHead = NULL;
		  while(revFirst && revSecond){
		  	    int sum = revFirst->data + revSecond->data + carry;
		  	    carry = sum/10;
		  	    sum %= 10;
		  	    next = revFirst->next;
		  	    revFirst -> next = sumHead;
		  	    revFirst->data = sum;
		  	    sumHead = revFirst;
		  	    revFirst = next;
		  	    revSecond = revSecond->next;
		  }
		  
		  while(revFirst){
		  	 int sum = carry + revFirst -> data;
		  	 carry = sum / 10;
		  	 sum %= 10;
		  	 next = revFirst -> next;
		  	 revFirst -> data = sum; 
			 revFirst -> next = sumHead;
			 sumHead = revFirst;
			 revFirst = next;		  	 
		  }
		  
		  while(revSecond){
		  	int sum = carry + revSecond -> data;
		  	carry = sum / 10;
		  	sum %= 10;
		  	next = revSecond->next;
		  	revSecond->data = sum;
		  	revSecond -> next = sumHead;
		  	sumHead = revSecond;
		  	revSecond = next;
		  }
		  if( carry){
		  	 struct Node *head = new Node(carry);
		  	 head->next = sumHead;
		  	 sumHead = head;
		  }
		  
		  return sumHead;
    }
};
