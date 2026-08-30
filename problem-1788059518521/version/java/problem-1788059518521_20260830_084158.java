// Last updated: 8/30/2026, 8:41:58 AM
1class Solution {
2    public int countSpecialIntegers(int[] nums) {
3        int a=0;
4        for(int i=0;i<nums.length;i++){
5            boolean s=true;
6            for(int j=0;j<i;j++){
7                if(nums[i]==nums[j]){
8                    s=false;
9                    break;
10                }
11            }
12            if(!s)
13                continue;
14            int l=i;
15            for(int j=i+1;j<nums.length;j++){
16                if(nums[i]==nums[j])
17                   l=j; 
18        }
19        for(int j=i;j<=l;j++){
20            if(nums[j]!=nums[i]){
21                s=false;
22                break;
23            }
24        }
25        if(s)
26            a++;
27    }
28    return a;
29    }
30}