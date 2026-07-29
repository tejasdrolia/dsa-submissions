class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int psa = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++)
        {
            psa+=nums[i];
            
            if(map.containsKey(psa-k))
            count+=map.get(psa-k);
            map.put(psa,map.getOrDefault(psa,0)+1);
        }
        return count;
    }
}