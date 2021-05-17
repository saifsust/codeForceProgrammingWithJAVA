#include<bits/stdc++.h>
using namespace std;
struct Node{
    int data;
    Node *left, *right;
    Node(){
        left = NULL;
        right = NULL;
    }
     Node(int _data){
         data = _data;
         left = NULL, right = NULL;
     }
};

typedef pair<int, int> ii;
void build(int first, int last, int permutation[],Node **tree);
ii maximum( int first, int last, int permutation[]);
void dfs(int depth[], Node *tree);
int main(){
    #ifndef ONLINE_JUDGE
     freopen("in.in", "r", stdin);
     freopen("out.in", "w", stdout);
    #endif
    int t;
    cin >> t;
    while(t--){ 
        int n;
        cin >> n;
        int permutation[n+5];
        for(int i = 0; i<n; i++) cin >> permutation[i];
        struct Node *root = NULL;
        build(0, n-1, permutation, &root);
        int depth[10000];
        depth[root->data] = 0;
        dfs(depth, root);
        for(int i = 0; i< n -1; i++){
            cout << depth[permutation[i]] << " ";
        }
        cout << depth[permutation[n-1]]<<endl;
    }

    return 0;
}
/**
 * build binary tree 
 */
void build(int first, int last, int permutation[], Node **tree){
    if( first > last || last < 0) return;
    ii mx = maximum(first,last,permutation);
   // cout << mx.first << " first "<< first<< " " << "last "  << last<< endl;
    *tree = new Node(mx.first);
    build(first, mx.second-1, permutation, &(*tree)->left);
    build(mx.second + 1, last, permutation, &(*tree)->right);
      
}

ii maximum(int first, int last, int permutation[]){
    ii mx = make_pair(0,0);
    for(int i = first ; i<= last; i++){
        if( mx.first < permutation[i]){
            mx = make_pair(permutation[i], i);
        }
    }
    return mx;
}

void dfs(int depth[], Node *tree){
    if(tree == NULL) return;
    if(tree->left){
        depth[tree->left->data] = depth[tree->data] + 1;
        dfs(depth, tree->left);
    }
    if(tree->right){
        depth[tree->right->data] = depth[tree->data] + 1;
        dfs(depth, tree->right);
    }
}
