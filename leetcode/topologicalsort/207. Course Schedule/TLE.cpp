class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> graph(numCourses, vector<int>());
        
        for(auto course : prerequisites){
            if(course[0] == course[1]) return false;
            graph[course[0]].push_back(course[1]);
        }
        return !isCyclic(numCourses, graph);
    }

   bool dfs(int source, vector<vector<int>> graph, vector<int> &low, vector<int>  &high, int &_time, vector<bool> &visited, vector<int> &tracker){
       
       low[source] = high[source] = ++_time;
       visited[source] = true;
       tracker.push_back(source);

       for(int nextCourse : graph[source]){
           if(!visited[nextCourse]){
               if(dfs(nextCourse, graph, low, high, _time, visited, tracker)) return true;
               low[source] = min(low[source], low[nextCourse]);
           }else{
               low[source] = min(low[source], high[nextCourse]);
           }
       }
       
       if(low[source] == high[source]){
           int counter = 1; 
           while(tracker.back() != source){
               visited[tracker.back()]=false;
               tracker.pop_back();
               ++counter;
           }
           visited[source] = false;
           tracker.pop_back();
           return counter > 1;
       }
       return false;
   }

   bool isCyclic(int numCourses,vector<vector<int>> &graph){
       vector<int> low(numCourses, -1), high(numCourses, -1), tracker;
       int _time = 0;
       vector<bool> visited(numCourses, false);
       for(int course = 0; course < numCourses; course++){
           if(!visited[course]){
                if(dfs(course, graph, low, high, _time, visited, tracker)) return true;
           }
       }    
       return false;
   }

};
