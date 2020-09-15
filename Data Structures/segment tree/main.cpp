#include<bits/stdc++.h>
using namespace std;

#define FIO ios::sync_with_stdio(false); cin.tie(0);cout.tie(0)
#define FIN freopen("in.txt", "r", stdin)
#define FOUT freopen("out.txt", "w", stdout)
#define F first
#define S second
#define N 1011
#define Q 100011

int L[N], R[N], sum[N], root[Q], lazy[N];
int next_free_index = 0;

/** 
 * l = 1, r = 6
 * L[] = {1,3,7,5, 0, 0, 0, 9, 0 ,0}
 * R[] = {2,4,8,6, 0, 0, 0, 10, 0, 0}
 * sum[] = {6,3,3,2,1 1 1, 2,1 1 1}
 * 
 **/
void build(int id,int l, int r){
	//cerr << "L " << l << " R " << r << " N " << next_free_index <<  endl;
	if(l == r){
		sum[id] = 1;
		return;
	}
	
	int mid = (l + r) >> 1;
	L[id] = ++next_free_index;
	R[id] = ++next_free_index;
	build(L[id], l, mid);
	build(R[id], mid+1, r);
	sum[id] = sum[L[id]] + sum[R[id]];
	return;
}

/**
 * without lazy propagation
 **/
void update(int s, int e, int l, int r, int id, int x){
	if(s > r || e<l) return;
	if(l == r){
		sum[id]+= x;
		return;
	}
	int mid = (l + r) >> 1;
	update(s,e,l, mid, L[id], x);
	update(s, e, mid + 1, r, R[id], x);
	sum[id] = sum[L[id]] + sum[R[id]];
	return ;
}

/**
 * query without lazy propagation 
 **/
 
 int query(int s, int e, int l, int r, int id){
	if(s > r || e < l) return 0;
	if(s<= l && r<= e) return sum[id];
	int mid = (l + r) >> 1;
	int left = query(s, e, l, mid, L[id]);
	int right = query(s,e,mid + 1, r, R[id]);
	return left + right; 
 }
 
 
 /**
  * with lazy propagation update
  **/
  
 void up_with_lazy(int s, int e, int l, int r, int id, int x){
	 if(s > r || e < l) return;
	 if(s<=l && r<= e){
		 lazy[id] += x;
		 sum[id] += (min(r, e) - max(s, l) + 1)*x;
		 return;
	 }
	 int mid = (l + r) >> 1;
	 up_with_lazy(s, e, l, mid, L[id], x);
	 up_with_lazy(s,e, mid + 1, r, R[id], x);
	 sum[id] = sum[L[id]] + sum[R[id]];
	 return;
 }

/**
 * query with lazy propagation
 **/
 
 int query_with_lazy(int s, int e, int l, int r, int id){
	 if(s > r || e < l) return 0;
	 if(s <= l && r <= e){
		 return sum[id];
	 }
	 cerr << "L " << l << " R " << r << endl;
	 int mid = (l + r) >> 1;
	 int left = query_with_lazy(s,e, l, mid, L[id]);
	 int right = query_with_lazy(s,e, mid + 1, r, R[id]);
	 return left + right + (min(e,r) - max(s,l) + 1) * lazy[id];
 }

void show(int id){
	if(L[id] == 0){
		cerr << sum[id] << " ";
		return;
	}
	show(L[id]);
	cerr << sum[id] << " ";
	show(R[id]);
}




int main(int argc, char* argv[]){
	FIO;
	next_free_index  = 0;
	int l = 1, r = 6, id = 0; 
	build(id,l, r);
    show(id);
    cerr << endl;
    int s, e, x;
    string cmd;
    memset(lazy, 0, sizeof(lazy));
    while(cin >> cmd){
		if(cmd[0] == 'Q'){
			assert(cin >> s >> e);
			cout << query_with_lazy(s, e, l, r, id) << endl;
			//cout << query(s, e, l,r, id) << endl;
		}
		if(cmd[0] == 'U'){
			assert(cin >> s >> e >> x);
			up_with_lazy(s, e, l, r, id, x);
			cout << lazy[3] << endl;
			//update(s, e, l, r, id, x);
		}
	}
	return 0;
}
