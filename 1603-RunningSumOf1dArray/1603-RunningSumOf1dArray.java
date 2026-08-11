// Last updated: 8/11/2026, 2:21:53 PM
class Solution {
    public int[] runningSum(int[] nums) {
      int   n=nums.length;
        int i;
        int res[]=new int[n];
        res[0]=nums[0];
        for(i=1;i<n;i++)
       res[i]=res[i-1]+nums[i];
       return res;
    }
}