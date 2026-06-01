class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb1 = new StringBuilder("");
        for(int i = 0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9'))
            sb1.append(ch);
        }
        String sb = sb1.toString().toLowerCase();
        System.out.println(sb);
        int i = 0;
        int j = sb.length()-1;
        while(i<j)
        {
            if(sb.charAt(i) != sb.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
}
