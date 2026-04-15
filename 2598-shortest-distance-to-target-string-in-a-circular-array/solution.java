class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        if(words[startIndex].equals(target)){
            return 0;
        }
        for(int step = 1; step<n; step++){
            int right = (startIndex+step)%n;
            int left = (startIndex-step+n)%n;
            if(words[right].equals(target)){
                return step;
            } else if(words[left].equals(target)){
                return step;
            }
        }
        return -1;
    }
}
