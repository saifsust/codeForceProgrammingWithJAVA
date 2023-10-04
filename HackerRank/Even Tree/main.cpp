int dfs(int source, vector<int> t_from, vector<int> t_to, vector<int>&counter){
    
    for(int i = 0; i<(int) t_to.size(); i++){
        if(source == t_to[i]){
            counter[source] += dfs(t_from[i], t_from, t_to, counter);
        }
    }
    return counter[source];
}


void dfs(int source , vector<int> t_from, vector<int> t_to, vector<int> &counter, int &answer){
    for(int i = 0; i < (int) t_to.size(); i++){
        if(source == t_to[i]){
            
            dfs(t_from[i], t_from, t_to, counter, answer);
            if(!(counter[t_from[i]] & 1)){
                counter[source] -= counter[t_from[i]];
                ++answer;
            }     
        }
    }
}

// Complete the evenForest function below.
int evenForest(int t_nodes, int t_edges, vector<int> t_from, vector<int> t_to) {
    vector<int> counter(t_nodes+1, 1);
    int answer = 0;
    int source = 1;
    dfs(source, t_from, t_to, counter);
    dfs(source, t_from, t_to, counter, answer);
    return answer;
}
