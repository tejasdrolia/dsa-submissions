class Solution {
    public boolean isHappy(int n) {

        int k = n;
        HashSet<Integer> set = new HashSet<>();
        while(k!=1)
        {
            System.out.println(k);
            if(set.size()>0 && set.contains(k))
            return false;
            set.add(k);
            int temp = 0;
            String s = Integer.toString(k);
            for(int i = 0;i<s.length();i++)
            {
                temp+= Math.pow(Integer.parseInt(s.charAt(i)+""),2);
            }
            k = temp;
        }
        return true;
    }
}
