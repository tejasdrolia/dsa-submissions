class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,ArrayList<String>> pmap = new HashMap<>();
        for(String s : strs)
        {
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i = 0;i<s.length();i++)
            {
                char ch = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            if(pmap.containsKey(map))
            {
                ArrayList<String> al = pmap.get(map);
                al.add(s);
                pmap.put(map,al);
            }
            else
            {
                ArrayList<String> al = new ArrayList<>();
                al.add(s);
                pmap.put(map,al);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (HashMap<Character,Integer> temp : pmap.keySet())
        {
            ans.add(pmap.get(temp));
        }
        return ans;
    }
}
