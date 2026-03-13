import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }

       
        int[] indegree = new int[numCourses];

        
        for (int i = 0; i < prerequisites.length; i++) {

            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];

            adj.get(prereq).add(course);
            indegree[course] = indegree[course] + 1;
        }

       
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

       
        int count = 0;

        while (q.isEmpty() == false) {

            int node = q.poll();
            count = count + 1;

            List<Integer> neighbours = adj.get(node);

            for (int i = 0; i < neighbours.size(); i++) {

                int next = neighbours.get(i);

                indegree[next] = indegree[next] - 1;

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        if (count == numCourses) {
            return true;
        }

        return false;
    }
}
