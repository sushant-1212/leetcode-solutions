class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            int cur = target.charAt(i) - 'a';

            if (freq[cur] > 0) {
                freq[cur]--;
            } else {

                for (int c = cur + 1; c < 26; c++) {
                    if (freq[c] > 0) {
                        return build(target, i, c, freq);
                    }
                }

                for (int j = i - 1; j >= 0; j--) {
                    int prev = target.charAt(j) - 'a';
                    freq[prev]++;

                    for (int c = prev + 1; c < 26; c++) {
                        if (freq[c] > 0) {
                            return build(target, j, c, freq);
                        }
                    }
                }

                return "";
            }
        }

        for (int j = n - 1; j >= 0; j--) {
            int prev = target.charAt(j) - 'a';
            freq[prev]++;

            for (int c = prev + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    return build(target, j, c, freq);
                }
            }
        }

        return "";
    }

    private String build(String target, int pos, int c, int[] freq) {
        StringBuilder ans = new StringBuilder();

        ans.append(target.substring(0, pos));
        ans.append((char) ('a' + c));

        freq[c]--;

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                ans.append((char) ('a' + i));
                freq[i]--;
            }
        }

        return ans.toString();
    }
}
