/**
 * data persistency basic problem solving spoj
 * @Author Saiful Islam
 * @gmail saiful.sust.cse@gmail.com
 * @CSE SUST
 **/

#include<bits/stdc++.h>
using namespace std;

#define FIO ios::sync_with_stdio(false);cin.tie(0);cout.tie(0);
#define FIN freopen("in.txt", "r", stdin);
#define FOUT freopen("out.txt", "w", stdio); 
#define mp make_pair
#define pb push_back
#define eb emplace_back
#define ll long long
#define N 100011


typedef pair<int,int>ii;
typedef map<int,int>mii;

struct Node{
	ll sum = 0;
	Node *left, *right;
	Node(ll sum){
		this->sum = sum,this->left = NULL, this->right = NULL;
	}
	Node (ll sum , Node* left , Node* right){
		this->sum=sum, this->left = left, this->right = right;
	}
	
	Node* build(int, int);
	Node* update(int,int, ll, int, int);
	ll query(int, int, int , int);
};

ll A[N];
Node* root[N];

/**
 * build segment tree
 **/
Node* Node::build(int L, int R){
	//cerr << "L " << L << " R " << R << endl;
	if(L == R) return new Node(A[L]);
	int M = (L + R) >> 1;
	Node* left = this->build(L, M);
	Node* right = this->build(M + 1, R);
	return new Node(left->sum+ right->sum, left, right);
}
/**
 * update segment tree
 **/
Node* Node::update(int s, int e, ll d, int L, int R){
	//cerr << "L " << L << " R " << R << endl;
	if(s>R || e< L) return this;
	if(L == R) return new Node(this->sum + d);
	int M = (L + R) >> 1;
	Node* left = this->left->update(s,e,d,L,M);
	Node* right = this->right->update(s,e, d, M + 1, R);
	return new Node(left->sum + right->sum, left, right);
}

/**
 * query into segment tree
 **/
 
ll Node::query(int s, int e, int L, int R){
	if(s > R || e<L) return 0;
	if(s <= L && R<= e) return this->sum;
	int M = (L + R) >> 1;
	return this->left->query(s, e, L, M) + this->right->query(s, e, M+ 1, R);
}


void show(Node* tree){
	if(tree== NULL) return;
	show(tree->left);
	cerr << tree->sum << " ";
	show(tree->right);
}

void debug(Node* tree){
	show(tree);
	cerr << endl;
}


int main(int argc, char *argv[]){
	FIO;
	//FIN;
	int n, m;
	assert(cin >> n >> m);
	int L = 0, R = n-1;
	for(int i = 0; i < n; i++) assert(cin >> A[i]);
	root[0] = root[0]->build(L, R);
	//debug(root[0]);
	char cmd[5];
	int s,e, t, curr=0;
	ll d;
	for(int i = 0; i<m; i++){
	   scanf("%s", cmd);
		//cin >> cmd;
		
		if(cmd[0] == 'C'){
		  scanf("%d%d%lld",&s,&e, &d);
		  s--,e--;
		  curr++;
          root[curr] = root[curr-1]->update(s, e, d, L, R);
		}
		
		if(cmd[0] == 'Q'){
			scanf("%d%d", &s, &e);
			s--,e--;
			printf("%lld\n", root[curr]->query(s,e, L, R));
		}
		
		if(cmd[0] == 'H'){
			scanf("%d%d%d", &s,&e,&t);
			s--,e--;
			if(!root[t]) continue;
			printf("%lld\n",root[t]->query(s,e, L, R));
		}
		
		if(cmd[0]  == 'B'){
			scanf("%d", &t);
			curr=t;
		}
	}
	return 0;
}
