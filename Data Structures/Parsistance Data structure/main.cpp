#include<bits/stdc++.h>
using namespace std;

#define fastio ios::sync_with_stdio(false); cin.tie(NULL), cout.tie(NULL);

const int N = 1e4;

struct Parsistant{
     int val;
     Parsistant *next;
     
     Parsistant(int v){
		 this->val = v;
		 this->next = NULL;
	 }
};
void insert(int arr[], int n, Parsistant* &root){
	Parsistant *temp=NULL;
	for(int i = 0; i<n; i++){
		if(!i){
			root = new Parsistant(arr[i]);
			temp = root;
			continue;
		}
		
		temp->next = new Parsistant(arr[i]);
		temp = temp->next;
	}
	return;
}

void show(Parsistant *root){
	Parsistant *temp = root;
	while(temp != NULL){
		cout << temp -> val << " ";
		temp = temp->next;
	}
	cout << endl;
}

void update(int *arr, int n, Parsistant* &head, Parsistant* &root){
	Parsistant *tempHead = head;
	for(int i = 0; i<n;i++) tempHead = tempHead->next;
	root = new Parsistant(arr[0]);
	Parsistant *temp = root;
	for(int i = 1; i<n; i++){
		temp->next = new Parsistant(arr[i]);
		temp = temp->next;
	}
	temp->next = tempHead;
	
}

int main(int argc, char *argv[]){
	fastio;
	
	int n;
	assert(cin >> n);
	int arr[n];
	for(int i = 0; i<n; i++){
		assert(cin >> arr[i]);
	}
	
	Parsistant *head[N];
	
	insert(arr, n, head[0]);
	show(head[0]);
	int nn, prev;
	int cnt = 1;
	string cmd;
	while(cin >> cmd){
		if(!cmd.compare("new")){
		assert(cin >> nn);
		assert(1<= nn && nn<n);
		for(int i = 0; i<nn; i++) assert(cin >> arr[i]);
		update(arr,nn, head[0], head[cnt]);
		show(head[cnt++]);
	}
	if (!cmd.compare("prev")){
		assert(cin >> prev);
		show(head[prev]);
	}
	}
	
	return 0;
}
