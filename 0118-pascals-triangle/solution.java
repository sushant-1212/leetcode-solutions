class Solution {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        ans.add(new ArrayList<>(firstRow));
        int middleElement = 0;
        for(int i = 1;i<numRows; i++){
            List<Integer>currentRow = new ArrayList<>();
            currentRow.add(1);
            for(int j = 1; j<=middleElement; j++){
                int element = ans.get(i-1).get(j) + ans.get(i-1).get(j-1);
                currentRow.add(element);
            }
            currentRow.add(1);
            ans.add(new ArrayList<>(currentRow));
            middleElement++;
        }
        return ans;
    }
}
        
