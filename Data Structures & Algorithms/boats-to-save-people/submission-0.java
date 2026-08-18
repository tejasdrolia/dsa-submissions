class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length-1;
        int countOfBoats = 0;
        while(i<=j)
        {
            int val = people[i] + people[j];
            if(val>limit)
            {
                countOfBoats++;
                j--;
            }
            else
            {
                countOfBoats++;
                i++;
                j--;
            }
        }
        return countOfBoats;
    }
}