#include <vector>
using namespace std;
const int N= 100;

void dfs(int source, vector<vector<int>> deps, vector<bool> &visited, vector<int> &sorted){
   visited[source] = true;
   for(vector<int> next : deps){
     if(next[0] == source){
       if(!visited[next[1]]){
         dfs(next[1], deps, visited, sorted);
       }
     }
   }
  sorted.push_back(source);
}


bool dfs(int source, int &_time , int *low_access_time, int *high_access_time, 
vector<vector<int>> deps, vector<bool> &visited, vector<int> &tracker){
   low_access_time[source] = high_access_time[source] = ++_time;
   visited[source] = true;
   tracker.push_back(source);
   bool isCyclic = false;
   for(vector<int> next : deps){
     if(next[0] == source){
       if(!visited[next[1]]){
         isCyclic |= dfs(next[1], _time, low_access_time, high_access_time, deps, visited, tracker);
         low_access_time[source] = min(low_access_time[source], low_access_time[next[1]]);
       }else{
         low_access_time[source] = min(low_access_time[source], high_access_time[next[1]]);
       }
     }
   }

   if(low_access_time[source] == high_access_time[source]){
     int counter = 0; 
     visited[source] = false;
     while(tracker.back() != source){
       visited[tracker.back()] = false;
       ++counter; 
       tracker.pop_back();
      }
      if(!tracker.empty()) ++counter;
      tracker.pop_back();
     return counter > 1;
   }

  return isCyclic;
}

bool isCyclicGraph(vector<int> jobs ,vector<vector<int>> deps, vector<bool> &visited){

  vector<int> tracker;
  int low_access_time[N], high_access_time[N], _time = 0;
  memset(low_access_time, -1, sizeof(low_access_time));
  memset(high_access_time, -1, sizeof(high_access_time));
  for(int job : jobs){
    if(!visited[job]){
       if(dfs(job, _time, low_access_time, high_access_time, deps, visited, tracker)) return true;
    }
  }
  return false;
}

vector<int> topologicalSort(vector<int> jobs, vector<vector<int>> deps) {
   vector<bool> visited(N, false);
    
   if(isCyclicGraph(jobs, deps, visited)){
      return {};
    }
  
    for(int i = 0; i<N; i++){
      visited[i] = false;
    } 
   vector<int>sorted;
   for(int i = jobs.size() - 1; i >= 0; i--){
     if(!visited[jobs[i]]){
       dfs(jobs[i], deps, visited, sorted);
     }
   }
   reverse(sorted.begin(), sorted.end());
  return sorted;
}
