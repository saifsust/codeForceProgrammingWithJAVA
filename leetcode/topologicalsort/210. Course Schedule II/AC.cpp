class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> graph[numCourses];
         for(auto next : prerequisites){
             graph[next[0]].push_back(next[1]);
         }

         if(isCyclic(numCourses, graph)) return {};

         vector<int> sorted;
         bool visited[numCourses];
         memset(visited, false, sizeof(visited));

         for(int course = 0; course < numCourses; course++){
             if(visited[course] == false){
                 dfs(course, graph, visited, sorted);
             }
         }
        // reverse(sorted.begin(), sorted.end());
        return sorted;
    }


   void dfs(int sourceCourse, vector<int> graph[], bool visited[], vector<int> &sorted){
       visited[sourceCourse] = true;
       for(int nextCourse : graph[sourceCourse]){
           if(visited[nextCourse] == false){
               dfs(nextCourse, graph, visited, sorted);
           }
       }
       sorted.push_back(sourceCourse);
   }



    bool dfs(int sourceCourse, vector<int> graph[], int forward[], int backward[]){
        forward[sourceCourse] = backward[sourceCourse] = 1;
        for(int nextCourse : graph[sourceCourse]){
            if(forward[nextCourse] == 0){
                if(dfs(nextCourse, graph, forward, backward)) return true;
            }else if(forward[nextCourse] == backward[nextCourse]) return true;
        }
        backward[sourceCourse] = 0;
        return false;
    }

    bool isCyclic(int numCourses, vector<int> graph[]){
        int forward[numCourses], backward[numCourses];
        memset(forward, 0, sizeof(forward));
        memset(backward, 0, sizeof(backward));
        for(int course = 0; course<numCourses; course++){
            if(forward[course] == 0){
                if(dfs(course, graph, forward, backward)) return true;
            }
        }
        return false;
    }
};
