class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        
        for(int i=0;i<numCourses;i++){
            adj[i] = new ArrayList<Integer>();
        }

        for(int[] pre : prerequisites){
            adj[pre[1]].add(pre[0]);
        }

        // System.out.println(Arrays.toString(adj));

        boolean[]  visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for(int i = 0;i<numCourses; i++){
            if(!visited[i]){
                if(checkCycle(i, visited, recStack, adj)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkCycle(int source, boolean[] visited, boolean[]  recStack, ArrayList<Integer>[] adj){
        visited[source] = true;
        recStack[source] = true;
        for(int neighbour : adj[source]){   
            if(!visited[neighbour]){
                if(checkCycle(neighbour, visited, recStack, adj)){
                    return true;
                }
            }else if(recStack[neighbour]){
                return true;
            }
        }
        recStack[source] = false;
        return false;
    }

}
