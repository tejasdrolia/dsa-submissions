class Solution {
    public int shipWithinDays(int[] wts, int days) {

        int left = 0, right = 0;

        for(int i : wts) {
            left = Math.max(left, i);
            right += i;
        }

        int ans = right;

        while(left <= right) {

            int mid = left + (right - left) / 2;

            if(isPossible(wts, days, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] ar, int days, int capacity) {

        int d = 1;
        int sum = 0;

        for(int i : ar) {
            if(sum + i > capacity) {
                d++;
                sum = 0;
            }
            sum += i;
        }

        return d <= days;
    }
}