#include<bits/stdc++.h>
using namespace std;

long long inversion ;

struct Node{
	int val;
	long long size=0;
	Node *left=NULL;
	Node *right=NULL;
	Node (){}
	Node (int v){val = v;}
};
void insert(Node* &root, int val){
	if(root == NULL){
		root = new Node(val);
		root -> size = 1;
		return;
	}
	
	if(root->val < val){
	  insert(root->right, val);
	}else {
	 insert(root->left, val);
	 int right  = 0;
	 if(root->right) right += root->right->size;
	 inversion += 1 + right;
	}
	long long size=1;
	if(root->left != NULL) size +=root->left->size;
	if(root->right != NULL) size +=root->right->size;
	root->size = size;
}

void show(Node *root){
	if(root==NULL) return;
	show(root->left);
	cerr << root -> val << " -> " << root->size << " | ";
	show(root->right);
}

int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int test;
	assert(cin >> test);
	for(int tt = 1; tt <= test; tt++){
		int n, val;
		Node *root= NULL;
		assert(cin >> n);
		inversion = 0;
		for(int i = 0; i<n; i++){
			assert(cin >> val);
			insert(root, val);
		}
		
		cout << inversion << endl;
		
	}
	return 0;
}
