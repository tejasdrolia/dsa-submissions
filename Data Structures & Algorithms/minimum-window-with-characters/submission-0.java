class Solution {
    public String minWindow(String s, String t) {
    HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<t.length();i++)
        {
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int tmc = t.length();
        int mc = 0;
        int i = -1;
        int j = -1;
        String ans = "";
        HashMap<Character,Integer> map1 = new HashMap<>();
        while(true)
        {
            boolean f1 = false;
            boolean f2 = false;
            while(i<s.length()-1 && mc!=tmc)
            {
                f1 = true;
                i++;
                char ch = s.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                
                if(map1.get(ch)<=map.getOrDefault(ch,0))
                    mc++;
            }
            while(j<i && mc==tmc)
            {
                f2 = true;
                String ss = s.substring(j+1,i+1);
                if(ans.length()==0||ss.length()<ans.length())
                    ans = ss;
                j++;
                char ch = s.charAt(j);
                if(map1.get(ch)==1)
                    map1.remove(ch);
                else
                    map1.put(ch,map1.get(ch)-1);
                if(map.getOrDefault(ch,0)>map1.getOrDefault(ch,0))
                    mc--;
                    
            }
            if(f1==false && f2==false)
                break;
        }
        return ans;
    }
}
