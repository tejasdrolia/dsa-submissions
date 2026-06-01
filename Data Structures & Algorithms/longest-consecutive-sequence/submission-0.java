class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, true);
        }
        for (int i : nums) {
            if (map.containsKey(i - 1))
                map.put(i, false);
        }
        int max = 0;
        for (int k : map.keySet()) {
            int x = k;
            if (map.get(k)) {
                int temp = 1;
                while (true) {
                    if (map.containsKey(x + 1)) {
                        x = x + 1;
                        temp++;
                    } else {
                        max = Math.max(max, temp);
                        break;
                    }
                }
            }
        }
        return max;
    }
}
