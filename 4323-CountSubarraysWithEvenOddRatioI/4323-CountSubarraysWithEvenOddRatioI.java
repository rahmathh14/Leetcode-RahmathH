// Last updated: 8/11/2026, 2:19:02 PM
class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        long ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int e=0;int o=0;
            for(int j=i;j<n;j++){
                if(nums[j]%2==0)
                    e++;
                else
                    o++;
                if(o>0&&(long)e*b<=(long)o*a)
                    ans++;
            }
        }
       return (int)ans; 
    }
}