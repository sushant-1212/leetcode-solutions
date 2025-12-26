class Solution {
    public int bestClosingTime(String customers) {
        int pent = 0;
        for(int i = 0; i<customers.length(); i++){
            if(customers.charAt(i)=='Y'){
                pent++;
            }
        }
        int minPent = pent;
        int hour = 0;
        for(int i = 0; i<customers.length(); i++){
            if(customers.charAt(i)=='Y'){
                pent--;
            } else{
                pent++;
            }
            if(pent<minPent){
                minPent = pent;
                hour = i+1;
            }
        }
        return hour;
    }
}
