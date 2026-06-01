class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> temparr[] = new ArrayList[nums.length+1];
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (temparr[val] == null) {
                temparr[val] = new ArrayList<>();
            }
            temparr[val].add(key);
        }
        int ans[] = new int[k];
        int ci = 0;
        for (int i = temparr.length - 1; i >= 0; i--) {
            if (temparr[i] != null) {
                for (int j = 0; j < temparr[i].size() && ci < k; j++) {
                    ans[ci++] = temparr[i].get(j);
                    if (ci >= k) {
                        return ans;
                    }
                }
            }
        }
        return null;
    }
}
