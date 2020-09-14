#include<bits/stdc++.h>
using namespace std;

#define FIO ios::sync_with_stdio(false); cin.tie(0); cout.tie(0)
#define FIN freopen("in.txt", "r", stdin)
#define FOUT freopen("out.txt", "w", stdout)
#define F first
#define Q 100011

typedef map<int,int>mii;
typedef pair<int,int>pii;

struct Node{
	uint32_t books=0, m=0;
	Node *left, *right;
	Node(uint32_t m){
		this->books = 0;
		this->m = m;
		this->left = NULL;
		this->right = NULL;
	}
	Node(uint32_t book, uint32_t m, Node* left, Node* right){
		this->books = book;
		this->m = m;
		this->left = left;
		this->right= right;
	}
	Node* build(uint32_t, uint32_t, uint32_t);
	Node* invert(uint32_t, uint32_t,uint32_t,uint32_t);
	Node* change(uint32_t, uint32_t, uint32_t, uint32_t);
	uint32_t query(uint32_t, uint32_t,uint32_t,uint32_t);
};

Node* null = new Node(0);

Node* Node::build(uint32_t L, uint32_t R, uint32_t m){
	//cerr << "L " << L << " R " << R << endl;
	if(L == R) return new Node(0,m, null, null);
	uint32_t mid = (L + R) >> 1;
	return new Node(this->left->books + this->right->books, m ,this->left->build(L,mid, m), this->right->build(mid+1, R,m));
}

Node* Node::invert(uint32_t s, uint32_t e, uint32_t L , uint32_t R){
	if(s > R || e < L) return this;
	if(L==R) return new Node(this->books ^ 1, this->m, this->left, this->right);
	uint32_t mid = (L + R) >> 1;
	Node* left = this->left->invert(s,e,L, mid);
	Node* right = this->right->invert(s,e, mid+ 1, R);
	return new Node(left->books + right->books,left->m, left, right);
}

Node* Node::change(uint32_t index, uint32_t v, uint32_t L, uint32_t R){
	if(R < index || index < L) return this;
	if(L == R) return new Node(v, this->m, null, null);
	uint32_t mid  = (L + R) >> 1;
	Node* left = this->left->change(index, v, L, mid);
	Node* right = this->right->change(index, v, mid+1, R);
	return new Node(left->books + right->books, this->m, left, right);
}


uint32_t Node::query(uint32_t s, uint32_t e, uint32_t L, uint32_t R){
	if(s>R || e < L) return 0;
	if(s<= L && R <= e) return this->books ;
	uint32_t mid = (L + R) >> 1;
	uint32_t left = this->left->query(s, e, L,mid);
	uint32_t right = this->right->query(s,e, mid + 1, R);
	return left + right;
}

uint32_t index(uint32_t i, uint32_t j, uint32_t m){
	return (i-1) * m + j;
}

void show(Node* tree){
	if(tree == null) return ;
	show(tree->left);
	cerr << tree->books << " ";
	show(tree->right);
}

int main(int argc, char *argv[]){
	FIO;
	uint32_t n,m, q;
	Node* root[Q];
	assert(cin >> n >> m >> q);
	uint32_t L  =1;
	uint32_t R = n*m;
	null->left = null->right=null;
	root[0] = null;
	root[0] = root[0]->build(L, R, m);
	uint32_t cmd , i,j, curr=0, cnt = 0;
	for(uint32_t t = 1; t<= q; t++){
		cnt++;
		assert(cin >> cmd);
		if(cmd == 1){
			assert(cin >> i>>j);
			if(root[curr]) root[cnt] = root[curr]->change(index(i,j,m), 1,L,R);
			curr=cnt;
			uint32_t  ans = root[curr]==NULL ? 0 : root[curr]->books;
			cout << ans << endl;
			
		}
		if(cmd == 2){
			assert(cin >> i>>j);
			if(root[curr]) root[cnt] = root[curr]->change(index(i,j,m), 0, L, R);
			curr=cnt;
			uint32_t  ans = root[curr]==NULL ? 0 : root[curr]->books;
			cout << ans << endl;
			
		}
		if(cmd == 3){
			assert(cin >> i);
			if(root[curr]) root[cnt] = root[curr]->invert(index(i,1,m), index(i,m,m),L, R);
			curr=cnt;
			uint32_t  ans = root[curr]==NULL ? 0 : root[curr]->books;
			cout << ans << endl;
		}
		if(cmd == 4){
			assert(cin>>i);
			root[cnt] = root[i];
			uint32_t  ans = root[i]==NULL ? 0 : root[i]->books;
			cout << ans << endl;
			curr=i;
		}
	}
	return 0;
}
