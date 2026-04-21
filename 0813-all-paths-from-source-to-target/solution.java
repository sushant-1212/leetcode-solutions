import java.util.*;

class Solution {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currPath = new ArrayList<>();
    int[][] g;   

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        g = graph;          
        currPath.add(0);   

        dfs(0);

        return result;
    }

    void dfs(int node) {

        
        if (node == g.length - 1) {
            result.add(new ArrayList<>(currPath));
            return;
        }

       
        for (int i = 0; i < g[node].length; i++) {

            int next = g[node][i];

            currPath.add(next);   
            dfs(next);            
            currPath.remove(currPath.size() - 1); 
        }
    }
}
