#include<bits/stdc++.h>
using namespace std;

#define sm first
#define mx second
#define mp make_pair

const int N = 1e5+5;
typedef pair<long long, long long > pll;
long long nums[N];
int n;
pll tree[N*3];

void build(int ss,int ee, int node){
	 if(ss == ee){
		 tree[node] = mp(nums[ss], nums[ss]);
		 return;
	 }
	 int m = (ss + ee) >> 1;
	 build(ss, m, node << 1);
	 build(m +1, ee, node << 1 | 1);
     long long lmx = tree[node << 1].mx;
     long long rmx = tree[node << 1 | 1].mx;
     long long smmx = max(tree[node<<1].sm, tree[node<<1|1].sm);
     tree[node] = mp(max(smmx, lmx+rmx), max(lmx,rmx));
}

pll query(int ss, int ee, int node, int L, int R){
	if(ss > R || ee < L || L > R || R < 1) return mp(-1,-1);
	if(ss <= L && R <= ee) return tree[node];
	int m = (L + R) >> 1;
	pll l = query(ss, ee, node<<1, L, m);
	pll r = query(ss, ee, node<<1|1, m+1, R);
	
	if(l.sm == -1) return r;
	if(r.sm == -1) return l;
	
	long long lmx = l.mx;
	long long rmx = r.mx;
	long long smx  = max(l.sm, r.sm);
	return mp(max(smx, lmx + rmx), max(lmx, rmx));
	
}

void update(int L, int R, int node, int in,int x){
	if(L > R || R < 1) return;
	if (L>in || R<in) return;
	if(L==R && L == in){
		nums[in] = x;
		tree[node]=mp(nums[in], nums[in]);
		return;
	}
	int m = (L+R) >> 1;
	update(L,m, node << 1, in, x);
	update(m+1, R, node << 1 | 1, in, x);
	long long lmx = tree[node<<1].mx;
	long long rmx = tree[node<<1|1].mx;
	long long smx = max(tree[node<<1].sm, tree[node<<1|1].sm);
	tree[node] = mp(max(smx, lmx+rmx), max(lmx, rmx));
}

int main(int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	assert(cin >> n);
	for(int i = 1; i<=n; i++)assert(cin >> nums[i]);
	build(1, n, 1);
	//cout << tree[2].sm << " " << tree[2].mx << endl; 
	int qry, a,b;
	assert(cin >> qry);
	char cmd;
	for(int q = 1; q<= qry; q++){
		assert(cin >> cmd >> a >> b);
		if(cmd == 'Q'){
			cout << query(a,b , 1, 1,n).sm <<endl;
		}
		if(cmd == 'U'){
			update(1,n,1,a,b);
		}
	}
	
	return 0;
}
