class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totgas = 0;
        int totcos = 0;
        int st = 0 , CurrGas = 0;
        for(int i = 0; i<gas.length; i++){
            totgas+=gas[i];
            totcos+=cost[i];
            CurrGas +=(gas[i]-cost[i]);
            if(CurrGas<0){
                st = i+1;
                CurrGas = 0;
            }
        }
        if(totgas<totcos){
            return -1;
        }
        return st;
    }
}
