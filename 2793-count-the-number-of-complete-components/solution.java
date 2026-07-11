class Solution {

    ArrayList<ArrayList<Integer>> adj;
    int[] vis;

    int nodes;
    int edges;

    public void dfs(int node) {

        vis[node] = 1;

        nodes++;

        edges += adj.get(node).size();

        for (int i = 0; i < adj.get(node).size(); i++) {

            int nei = adj.get(node).get(i);

            if (vis[nei] == 0) {
                dfs(nei);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] graph) {

        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

     
        for (int i = 0; i < graph.length; i++) {

            int u = graph[i][0];
            int v = graph[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        vis = new int[n];

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (vis[i] == 0) {

                nodes = 0;
                edges = 0;

                dfs(i);

                edges = edges / 2;

                if (edges == (nodes * (nodes - 1)) / 2) {
                    count++;
                }
            }
        }

        return count;
    }
}
