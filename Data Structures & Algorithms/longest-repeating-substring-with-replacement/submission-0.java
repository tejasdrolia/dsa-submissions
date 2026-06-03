class Solution {
    public int characterReplacement(String s, int k) {
        // brute soln would be to find all subsets and then find the largest possible subset with k
        // replacements
        //  potential candidate = lenght of subset - max freq of characters available <=k
        int freq[] = new int[26];
        int l = 0;
        int r = 0;
        int maxfreq = 0;
        int ans = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            freq[ch - 65]++;
            maxfreq = Math.max(maxfreq, freq[ch - 65]);
            while ((r - l + 1) - maxfreq > k) {
                freq[s.charAt(l)-65]--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}
