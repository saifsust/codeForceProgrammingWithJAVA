/**
 * Parsistance Segment Tree
 * @Author Saiful Islam
 * @SUST CSE
 **/
#include<bits/stdc++.h>
using namespace std;
#define fastio ios::sync_with_stdio(false);cin.tie(0); cout.tie(0);

const int N = 1e4;

typedef struct Node{
	Node *left, *right;
	int val;
	Node(int val){
		this->val = val;
		this->left = NULL;
		this->right = NULL;
	}
	Node* build(int s, int e);
	int query(int s, int e, Node *node, int L, int R);
	Node* update(int s, int e, int *vals, Node *prev , int L, int R);
} Tree;

int base[N];

/**
 * build parsistant segment tree
 **/
Tree* Tree::build(int s, int e){
	if(s==e){
		return new Node(base[s]);
	}
	
	int mid = (s+e)>> 1;
	Tree *left = build(s, mid);
	Tree *right = build(mid +1, e);
	int sum = left->val + right->val;
	Tree *tree = new Tree(sum);
	tree->left = left;
	tree->right = right;
	return tree;
}
/**
 * query in parsistant segment tree
 **/
int Tree::query(int s, int e,Node *node, int L, int R){
	cerr << "L " << L << " R " << R<<endl; 
	if(s > R || e < L) return 0; 
	if(s <= L && R <= e) return node->val;
	int mid = (L + R) >> 1;
	int left = query(s, e, node -> left, L, mid);
	int right = query(s, e, node -> right , mid + 1, R);
	return left + right;
}

/**
 * update parsistant segment tree
 **/
 
 Node* Tree::update(int s, int e, int *vals , Node *prev , int L, int R){
	if(s > R || e < L){
		cerr << "C L " << L << " R " << R;
		cerr <<" v "<<  prev->val << endl;
		return prev;
	}
	if(L == R){
		cerr << (e < L) << endl;
		cerr << "L " << L << " R " << R<< endl;
		return new Node(vals[L]);
	}
	cerr << " -> L " << L << " R " << R<< endl;
	int mid = (L + R) >> 1;
	
	Node* left=update(s,e,  vals, prev->left, L, mid);
	Node* right=update(s,e, vals, prev->right, mid+1,R);
	
	Node * tree = new Node(left->val + right->val);
	tree->left = left;
	tree->right = right;
	return tree;
}

void show(Tree *tree){
	if(tree == NULL) return;
	show(tree->left);
	cout << tree->val << " ";
	show(tree->right);
}

int main(int argc, char *argv[]){
	fastio;
	Tree* root[N];
    int n;
    assert(cin >> n);
    for(int i = 0; i<n; i++){
		assert(cin >> base[i]);
	}
	int L = 0, R = n-1, cnt=0;
	root[cnt]=root[cnt]->build(L, R);
	cnt++;
    int s, e, rt;
    show(root[1]);
    cout << endl;
    string cmd;
    while(cin >> cmd){
		if(!cmd.compare("Q")){
			cin >> s >> e >> rt;
		cout << root[1]->query(s, e, root[rt], L, R)<< endl;
		}
		
		if(!cmd.compare("U")){
			cin >> s >> e;
			assert(s<=e);
			int arr[e+1];
			for(int i = s; i<=e; i++) cin >> arr[i];
			root[cnt] = root[cnt]->update(s, e, arr, root[cnt-1], L, R);
			cnt++;
		}
	}
		
	return 0;
}
