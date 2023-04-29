class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(numCourses == 0 || prerequisites.empty()) return true;
        vector<int> graph[numCourses];
        
        for(auto course : prerequisites){
            if(course[0] == course[1]) return false;
            graph[course[0]].push_back(course[1]);
        }
        return !isCyclic(numCourses, graph);
    }

   bool dfs(int source, vector<int> graph[], vector<bool> &forwardVisited, vector<bool> &backwardVisited){
       forwardVisited[source] = backwardVisited[source]= true;

       for(int nextCourse : graph[source]){
           if(!forwardVisited[nextCourse]){
               if(dfs(nextCourse, graph, forwardVisited, backwardVisited)) return true;
           }else if(forwardVisited[nextCourse] && backwardVisited[nextCourse]) return true;
       }
       backwardVisited[source] = false;
       return false;
   }

   bool isCyclic(int numCourses, vector<int> graph[]){
        vector<bool> forwardVisited(numCourses, false), backwardVisited(numCourses, false);
       for(int course = 0; course < numCourses; course++){
           if(!forwardVisited[course]){
                if(dfs(course, graph, forwardVisited, backwardVisited)) return true;
           }
       }    
       return false;
   }

};
