 class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') ones++;
        }

        String t = "1" + s + "1";

        ArrayList<Character> ch = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if (ch.size() == 0 || ch.get(ch.size() - 1) != c) {
                ch.add(c);
                len.add(1);
            } else {
                len.set(len.size() - 1, len.get(len.size() - 1) + 1);
            }
        }

        int gain = 0;

        for (int i = 1; i < ch.size() - 1; i++) {
            if (ch.get(i) == '1' &&
                ch.get(i - 1) == '0' &&
                ch.get(i + 1) == '0') {
                gain = Math.max(gain, len.get(i - 1) + len.get(i + 1));
            }
        }

        return ones + gain;
    }
}      
