// Last updated: 8/11/2026, 2:18:51 PM
class Solution {
    public long maxPairStrength(int[] nums) {
        long m=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                long g=gcd(nums[i],nums[j]);
                long s=(1L*nums[i]*nums[j])/(g*g);
                m=Math.max(m,s);
            }
        }
        return m;
    }
        private long gcd(long a,long b){
            while(b!=0){
                long t=b;
                b=a%b;
                a=t;
            }
            return a;
        }
    }
