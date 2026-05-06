class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        
        for(int i=0;i<numCourses;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] pre : prerequisites){
            adj[pre[1]].add(pre[0]);    
        }

        ArrayList<Integer> res = new ArrayList<>();

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                if(checkCycle(i, visited, recStack, adj, res)){
                    return new int[0];
                }
            }
        }
        
        Collections.reverse(res);

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public boolean checkCycle(int source, boolean[] visited, boolean[] recStack, ArrayList<Integer>[] adj, ArrayList<Integer> res){
        visited[source] = true;
        recStack[source] = true;
        for(int neighbour : adj[source]){
            if(!visited[neighbour]){
                if(checkCycle(neighbour, visited, recStack, adj, res)){
                    return true;
                }
            }else if(recStack[neighbour]){
                return true;
            }
        }
        recStack[source] = false;
        res.add(source);
        return false;
    }
    
}
