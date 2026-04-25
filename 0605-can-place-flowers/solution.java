class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int canPlace = 0;
        int size = flowerbed.length;
        for(int i=0; i<size; i++){
            if(flowerbed[i]==0){
                if(i>0 && flowerbed[i-1]==1) continue;
                if(i<size-1 && flowerbed[i+1]==1) continue;
                flowerbed[i]=1;
                canPlace++;
                i++;
            }
        }
          return canPlace>=n;
    }
}

