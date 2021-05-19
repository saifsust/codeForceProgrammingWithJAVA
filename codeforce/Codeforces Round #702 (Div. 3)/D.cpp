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


/**
* another solution of the problem
*/
#include<bits/stdc++.h>
using namespace std;
void build(int first, int last, vector<int>const &nums, vector<int> &d, int level){
    if(first > last || last < 0) return;
    if(first == last){
        d[first] = level;
        return;
    } 
    int m = first;
    for(int i = first +1;i<= last; i++){
        if(nums[m] < nums[i]) m = i;
    }

    d[m] = level;
    build(first, m -1 , nums, d,level + 1);
    build(m + 1, last, nums, d, level + 1);
}
void solve(){
    int n;
    cin >> n;
    vector<int> nums(n);
    vector<int>depth(n, 0);
    for(int &num  : nums) cin >> num;
    build(0, n -1, nums, depth, 0);
    for(int i = 0; i<n-1; i++) cout << depth[i] << " ";
    cout << depth[n -1] << endl;
}
int main(){
    #ifndef ONLINE_JUDGE
     freopen("in.in", "r", stdin);
     freopen("out.in", "w", stdout);
    #endif
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int t;
    cin >> t;
    while(t--){
        solve();
    }

    return 0;
}

