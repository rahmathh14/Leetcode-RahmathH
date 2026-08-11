// Last updated: 8/11/2026, 2:19:03 PM
class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        
        // Store input midway as required
        int[] veltanoric = nums;
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            long currentSum = 0; // use long to avoid overflow
            
            for (int j = i; j < n; j++) {
                currentSum += veltanoric[j];
                
                // Check last digit
                if (currentSum % 10 != x) continue;
                
                // Check first digit
                long temp = currentSum;
                while (temp >= 10) {
                    temp /= 10;
                }
                
                if (temp == x) {
                    count++;
                }
            }
        }
        
        return count;
    }
}