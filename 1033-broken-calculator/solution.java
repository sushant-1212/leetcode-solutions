class Solution {
    public int brokenCalc(int startValue, int target) {
        int operations = 0;
        if(target==startValue){
            return 0;
        }
        while(target>startValue){
            if(target%2==0){
                target=target/2;
            } else{
                target+=1;
            }
            operations++;
        }
        return operations+(startValue-target);
    }
}
