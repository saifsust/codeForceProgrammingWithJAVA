#include<bits/stdc++.h>
using namespace std;

struct Node{
	int val;
	Node *next;
	Node(int _val){
		val= _val;
	}
};

void insert(Node *&root, int val){
	if(root ==  NULL){
		root = new Node(val);
		return;
	}
	
	Node *temp = root;
	while(temp->next != NULL) temp = temp -> next;
	temp->next = new Node(val);
}

void printlist(Node *root){
	Node *temp = root;
	int counter = 0;
	while(temp != NULL && counter < 100){
		cout << temp -> val << " ";
		temp = temp->next;
		counter++; 
	}
	cout << endl;
}

void swap(struct Node *&root, int x, int y){
	if(x == y) return;
    struct Node *currX = root, *prevX=NULL, *temp,*temp2, *currY = root, *prevY=NULL;
	while(currX && currX->val != x){
		prevX=currX;
		currX=currX->next;
	}
	while(currY && currY->val != y){
		prevY = currY;
		currY = currY->next;
	}
   if(!currX || !currY) return;
   if(prevX) prevX->next = currY;
   else root = currY;
   if(prevY) prevY->next = currX;
   else root= currX;
   
   temp = currY->next;
   currY->next = currX->next;
   currX->next = temp;
  
}

int main(){
	
	struct Node *root=NULL;
	insert(root,4);
	insert(root,5);
	insert(root, 10);
	insert(root, 12);
	insert(root, 34);
	insert(root, 45);
	printlist(root);
	swap(root, 10,34);
	printlist(root);
	swap(root, 10, 100);
    printlist(root);
	swap(root, 10,34);
	printlist(root);
	swap(root, 45, 4);
	printlist(root);
	return 0;
}
