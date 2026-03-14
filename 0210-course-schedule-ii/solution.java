import java.util.*;

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {

            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];

            adj.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {

            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        while(q.isEmpty() == false) {

            int node = q.poll();

            order[index] = node;
            index++;

            List<Integer> neighbours = adj.get(node);

            for(int i = 0; i < neighbours.size(); i++) {

                int next = neighbours.get(i);

                indegree[next]--;

                if(indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        if(index == numCourses) {
            return order;
        }

        return new int[0];
    }
}
