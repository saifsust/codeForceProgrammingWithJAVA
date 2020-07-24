#include<bits/stdc++.h>
using namespace std;
#define mp make_pair

struct Node{
	int weight, index;
	long long num;
	Node(long long nm, int w, int i){
		num = nm;
		weight = w;
		index = i;
	}
	bool operator< (const Node &next) const {
		return weight > next.weight;
	}
};

typedef priority_queue<Node>pq;
typedef pair<int,int>ii;
typedef set<long long >sll;

const int N = 1e5;

int  n;
pq q;
sll used;

bool isPerfectSquare(long long num){
	long long sqrtN = (long long)sqrt(num);
	return sqrtN * sqrtN == num; 
}
void dijkstra( long long arr[]){
	while(!q.empty()){
		Node root = q.top(); q.pop();
		long long num = root.num;
		int in = root.index;
		int w = root.weight;
		int next = in + 1;
		cerr << num << "  " << in << " " << w << endl;
		if(next <n){
			long long next_num = num * arr[next];
			if(isPerfectSquare(next_num)){
				cout << w + 1 << endl;
				return;
			}
			q.push(Node(next_num, w + 1, next));
		}
	}
	cout << -1 << endl;
}



int main( int argc, char *argv[]){
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	assert(cin >> n);
	long long nums[n];
	for(int i = 0; i<n; i++){
		assert(cin >> nums[i]);
		if(isPerfectSquare(nums[i])){
			cout << 1 << endl;
			return 0;
		}
		q.push(Node(nums[i],1, i));
	}
	dijkstra(nums);
	return 0;
}
