class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    
        int n = gas.length;
        int rGas = 0;

        for(int i=0;i<n;i++){
            rGas+=gas[i]-cost[i];
        }

        if(rGas < 0){
                return -1;
            }

        int res = 0;
        int tank = 0;
        for(int i=0;i<n;i++){
            tank = tank + gas[i] - cost[i];
            if(tank < 0){
                tank = 0;
                res=i+1;
            }
        }

        tank=0;
        for(int i=0;i<n;i++){
            int nI = (i+res)%n;
            tank = tank + gas[nI] - cost[nI];
            if(tank < 0){
                return -1;
            }
        }

        return tank < 0 ? -1 : res;

        
    }
}
