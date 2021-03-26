#include<bits/stdc++.h>
using namespace std;
struct Node{
	int val;
	Node *next;
	Node(){}
	Node(int _val){
		val = _val;
		next = NULL;
	}
};

Node *root;

void insert(int val){
	if(root == NULL){
		root = new Node(val);
		return;
	}
	Node *temp = root;
	while(temp->next != NULL) temp = temp -> next;
	temp->next = new Node(val);
}

void print(Node *head){
	while(head != NULL){
		cout << head -> val << " ";
		head = head->next;
	}
	cout << endl;
}

int main(){
	
	insert(2);
	insert(3);
	insert(4);
	insert(5);
	insert(6);
	print(root);
	return 0;
}
