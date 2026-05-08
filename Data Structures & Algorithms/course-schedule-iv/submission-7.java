class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] pre : prerequisites){
            adj[pre[0]].add(pre[1]);
        }

        // System.out.println(Arrays.toString(adj));

        List<Boolean> res = new ArrayList<>();
        for(int[] query : queries){
            boolean[] visited = new boolean[numCourses];
            res.add(dfs(query[0], query[1], visited, adj));
        }
        return res;
    }

    public boolean dfs(int source, int target, boolean[] visited, ArrayList<Integer>[] adj){
        if(source == target){
            return true;
        }
        visited[source] = true;
        for(int neighbour : adj[source]){
            if(!visited[neighbour]){
                if(dfs(neighbour, target, visited, adj)){
                    return true;
                }
            }           
        }
        return false;
    }

}