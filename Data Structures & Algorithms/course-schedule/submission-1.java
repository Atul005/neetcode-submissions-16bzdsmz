class Solution {
    public boolean canFinish(int nums, int[][] prereq) {

        List<Integer>[] adj = new List[nums];
        
        for(int i=0;i<nums;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge :prereq){
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[nums];
        boolean[] path = new boolean[nums];
 
        for(int i=0;i<nums;i++){
            if(!visited[i]){
                if(dfs(i, visited, path, adj)){
                    return !true;
                }
            }
        }

        return !false;
    }

    public boolean dfs(int i, boolean[] visited, boolean[] path, List<Integer>[] adj){
        visited[i] = true;
        path[i] = true;

        for(int neighbour : adj[i]){
            if(!visited[neighbour]){
                if(dfs(neighbour, visited, path, adj)){
                    return true;
                }
            }else if(path[neighbour]){
                return true;
            }
        }
        path[i] = false;
        return false;
    }
}
