class Solution {
    public int vowelConsonantScore(String s) {
        int vowel = 0;
        int cons = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {   // sirf letters
                if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                    vowel++;
                } else {
                    cons++;
                }
            }
        }

        if (cons > 0) {
            return vowel / cons; 
        }

        return 0;
    }
}

