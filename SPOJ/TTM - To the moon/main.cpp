#include<bits/stdc++.h>
using namespace std;

#define FIO ios::sync_with_stdio(false); cin.tie(0); cout.tie(0)
#define FIN freopen("out.txt", "r", stdin)
#define FOUT freopen("out.txt", "w", stdout)
#define N 100011
#define M 4000005
#define ll long long

typedef map<int,int >mii;
typedef pair<int,int>pii;

struct Node{
    ll sum = 0L;
    Node *left, *right;
    Node(){
		scanf("%lld", &this->sum);
		this->left = NULL;
		this->right = NULL;
	}
	Node(ll sum, Node* left, Node* right){
		this->sum = sum;
		this->left = left;
		this->right = right;
	}
	Node* build(int , int);
	Node* update(int,int,ll,int,int);
	ll query(int,int,int,int);
};

Node* root[M];
ll num;

Node* Node::build(int L, int R){
	//cerr << "L " << L << " R " << R << endl;
	if(L == R) return new Node();
	int mid = (L + R)>> 1;
	Node *left  = this->build(L,  mid);
	Node *right = this->build(mid+1,R);
	return new Node(left->sum + right->sum, left, right);
}

ll Node::query(int s, int e, int L, int R){
	if (s > R || e < L) return 0L;
	if(s <= L && R<= e) return this->sum;
	int mid = (L + R) >> 1;
	return this->left->query(s,e,L,mid) + this->right->query(s, e, mid + 1, R);
}

Node* Node::update(int s, int e, ll d, int L, int R){
	if(s > R || e < L) return this;
	if(L == R) return new Node(this->sum + d, NULL, NULL);
	int mid = (L + R) >> 1;
	Node *left = this->left->update(s, e, d, L, mid);
	Node *right = this->right->update(s, e, d, mid + 1, R);
	return new Node(left->sum + right->sum , left, right);
}

int main(int argc, char* argv[]){
	FIO;
	FILE *file = FIN;
	if(file == NULL) return 1;
	int n, m;
	scanf("%d%d", &n, &m);
	int L = 1, R = n;
	root[0] = root[0]->build(L, R);
	
	//fclose(file);
	
	int curr = 0, s,e,t;
	ll d;
	char cmd[5];
	for(int q = 1; q <=m; q++){
		scanf("%s", cmd);
		if(cmd[0] == 'Q'){
			scanf("%d%d", &s,&e);
			cout << root[curr]->query(s, e, L, R) << endl;
		}
		
		if (cmd[0] == 'C'){
			scanf("%d%d%lld", &s, &e, &d);
			root[curr+1] = root[curr]->update(s,e,d, L, R);
			curr++;
		}
		if(cmd[0] == 'H'){
			scanf("%d%d", &s, &e);
			cout << (root[t] == NULL ? 0 : root[t]->query(s, e, L, R)) << endl;
		}
		if(cmd[0] == 'B'){
			scanf("%d", &t);
			for(int i = t + 1; i<= curr; i++) free(root[i]), root[i] = NULL;
			curr = t;
		}
	}
	
	
}
