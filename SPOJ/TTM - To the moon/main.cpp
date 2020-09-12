#include<bits/stdc++.h>
using namespace std;

#define FIO ios::sync_with_stdio(false); cin.tie(0); cout.tie(0)
#define FIN freopen("in.txt", "r", stdin)
#define FOUT freopen("out.txt", "w", stdout)
#define N 100011
#define M 100003
#define ll long long

typedef map<int,int >mii;
typedef pair<int,int>pii;

struct Node{
    ll sum = 0L, lazy = 0L;
    Node *left, *right;
    Node(){
		scanf("%lld", &this->sum);
		this->left = NULL;
		this->right = NULL;
		this->lazy = 0L;
	}
	Node(ll sum,ll lazy, Node* left, Node* right){
		this->sum = sum;
		this->left = left;
		this->right = right;
		this->lazy = lazy;
	}
	Node* build(int , int);
	Node* update(int,int,ll,int,int);
	ll query(int,int,int,int, ll);
};

Node* root[M];
ll num;

Node* Node::build(int L, int R){
	//cerr << "L " << L << " R " << R << endl;
	if(L == R) return new Node();
	int mid = (L + R)>> 1;
	Node *left  = build(L,  mid);
	Node *right = build(mid+1,R);
	return new Node(left->sum + right->sum, 0L,left, right);
}

ll Node::query(int s, int e, int L, int R, ll lazy){
	if (s > R || e < L) return 0L;
	if(s <= L && R<= e){
		return this-> sum + lazy * (min(R, e) - max(L, s) + 1); 
	}
	int mid = (L + R) >> 1;
	return this->left->query(s,e,L,mid, this->left->lazy + lazy) + this->right->query(s, e, mid + 1, R, this->right->lazy + lazy);
}

Node* Node::update(int s, int e, ll d, int L, int R){
	if(s > R || e < L) return this;
    if(s<=L && R <= e) return new Node(this->sum, this->lazy + d,this->left, this->right);
    int mid = (L + R) >> 1;
    Node* left = this->left->update(s, e, d, L, mid);
    Node* right  = this->right->update(s,e, d, mid + 1, R);
    return new Node(this->sum + d * ((min(e, R) - max(L,s)) + 1),this->lazy,left, right);
}

void show(Node* tree){
	if(tree== NULL) return;
	show(tree->left);
	cerr << tree->sum << " ";
	show(tree->right);
}

int main(int argc, char* argv[]){
	FIO;
	//FIN;
	int n, m;
	scanf("%d%d", &n, &m);
	int L = 1, R = n;
	root[0] = root[0]->build(L, R);	
	int curr = 0, s,e,t;
	ll d;
	char cmd[5];
	for(int q = 1; q <=m; q++){
		scanf("%s", cmd);
		if(cmd[0] == 'Q'){
			scanf("%d%d", &s,&e);
			printf("%lld\n",root[curr]->query(s, e, L, R,0));
		}
		
		if (cmd[0] == 'C'){
			scanf("%d%d%lld", &s, &e, &d);
			root[curr+1] = root[curr]->update(s,e,d, L, R);
			curr++;
		}
		if(cmd[0] == 'H'){
			scanf("%d%d%d", &s, &e,&t);
			printf("%lld\n",root[t] == NULL ? 0 : root[t]->query(s, e, L, R,0));
		}
		if(cmd[0] == 'B'){
			scanf("%d", &curr);
		}
	}
	
	
}
