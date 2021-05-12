#include<bits/stdc++.h>
using namespace std;

struct Node{
	int data;
	Node *next;
	Node(){}
	Node(int _data){
		data = _data;
		next = NULL;
	}
};

void push(Node **head, int data){
	if(*head == NULL){
		*head = new Node(data);
		return;
	}
	Node *temp = *head;
	while(temp -> next) temp = temp->next;
	temp->next = new Node(data);
}
void print(Node *head){
	while(head){
		cout << head ->data << " ";
		head = head -> next;
	}
	cout << endl;
}

Node *rotated(Node *head, int k , int d){
	vector<Node*> ss;
	Node *next = NULL;
	while(head){
		int p = k;
		ss.push_back(head);
		while(head->next && p>1){
			head = head->next;
			p--;	
		}
	    next = head -> next;
	    head->next = NULL;
	    head = next;
	}
	
     for(unsigned i = 0; i<ss.size(); i++){
     	 next = ss[i];
     	 if(d >=0){
     	 	int p = d;
     	 	while(p>=1){
     	 		
     	 		Node *prev = NULL;
     	 		while(next->next){
     	 			prev = next;
     	 			next = next->next;
				  }
				 // cout << prev -> data << " " << next->data << endl;
				  prev->next = NULL;
				  next -> next = ss[i];
				  ss[i] = next;
				  next = ss[i];
     	 		--p;	
			  }
		  }
		  
		if(d < 0){
		     int p = d;
		     Node *root = NULL;
		     while(p < 0){
		     	++p;
		     	Node *first = next;
				root = next -> next;
				next->next = NULL;
				Node *temp = root;
				while(temp->next) temp = temp->next;
				temp->next = first;
		     	next = root;
			 }
			ss[i] = root;
		}
	 }
	 
	 Node *temp = ss[0];
	 while(temp->next) temp = temp->next;
	 for(int i = 1; i< ss.size(); i++){
	 	temp->next = ss[i];
	 	while(temp->next) temp = temp->next;
	 }
	 	
	return ss[0];
}
int main(){
	#ifndef ONLINE_JUDGE
	 	freopen("in.txt", "r", stdin);
	 //	freopen("out.txt", "w", stdout);
	#endif
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int val, n, k, d;
    cin >> n;
    Node *root = NULL;
    for(int i = 0; i<n; i++){
    	cin >> val;
    	push(&root, val);
	}
	cin >> k >> d;
	 Node *ans=rotated(root, k, d);
    print(ans);
	
	return 0;
}
