#include<bits/stdc++.h>
using namespace std;

#define fastio ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define flin freopen("in.txt", "r", stdin);

const int N = 1e5+5;

struct Node{
	int containNums=0;
	Node *left, *right;
	Node (int containNums){
		this->containNums = containNums;
		this->left = NULL;
		this->right = NULL;
	}
	
	Node (int containNums, Node *left, Node* right){
		this->containNums = containNums;
		this->left = left;
		this->right = right;
	}
	Node* build(int L, int R, int in);
};

typedef map<int, int> mii;


int nums[N], INDX[N];
mii MP_INDX;
Node* null = new Node(0);
Node *root[N];

Node* Node::build(int L, int R, int in){
	//cerr << "L "<< L << " R " << R << endl;
	if(L<= in && in <= R){
		if(L == R) return new Node(this->containNums + 1, null, null);
		int mid = (L + R) >> 1;
		return new Node(this->containNums + 1, this->left->build(L, mid , in), this->right->build(mid+1, R, in));
	}
	return this;
}

int query(int L, int R, int K , Node* start, Node* end){
	if(L == R) return L;
	int mid = (L + R) >> 1;
	int totalNums = end->left->containNums - start->left->containNums;
	if(totalNums >= K) return query(L, mid, K, start->left, end->left);
	return query(mid + 1, R, K - totalNums, start->right, end->right);
}


void show(Node *tree){
	if(tree == null) return;
	show(tree->left);
	cerr << tree->containNums << " ";
	show(tree->right);
}

void debug(Node *tree){
	show(tree);
	cerr << "\n\n";
}

int main(int argc, char *argv[]){
	fastio;
	//flin;
	int n, m;
	scanf("%d%d", &n, &m);
	for(int i = 0; i<n; i++){
		scanf("%d", &nums[i]);
		MP_INDX[nums[i]];
	}
	int maxLen = 0;
	/**
	 * data compress
	 **/
	for(auto it = MP_INDX.begin(); it != MP_INDX.end(); it++){
		MP_INDX[it->first] = maxLen;
		INDX[maxLen++] = it->first;
	}
	int L = 0, R = n -1;
	null->left = null->right = null;
	for(int i = 0; i<n; i++){
		root[i] = (i == 0 ? null : root[i-1])->build(L, R, MP_INDX[nums[i]]);
	}
	//debug(root[0]);
	//debug(root[1]);
	//debug(root[5]);
	int S, E, K;
	for(int q =1; q<= m; q++){
		scanf("%d%d%d", &S,&E, &K);
		assert(E - S + 1 >= K);
		S--, E--;
		int index = query(L, R, K, S==0? null: root[S-1], root[E]);
		printf("%d\n", INDX[index]);
	}
}
