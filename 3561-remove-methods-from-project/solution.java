class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < invocations.length; i++) {
            int u = invocations[i][0];
            int v = invocations[i][1];
            graph[u].add(v);
        }

        boolean[] suspicious = new boolean[n];
        dfs(k, graph, suspicious);


        for (int i = 0; i < invocations.length; i++) {
            int u = invocations[i][0];
            int v = invocations[i][1];

            if (!suspicious[u] && suspicious[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    ans.add(j);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    public void dfs(int node, List<Integer>[] graph, boolean[] suspicious) {
        if (suspicious[node]) {
            return;
        }

        suspicious[node] = true;

        for (int i = 0; i < graph[node].size(); i++) {
            int next = graph[node].get(i);
            dfs(next, graph, suspicious);
        }
    }
}
