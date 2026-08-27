// Last updated: 8/27/2026, 10:12:14 AM
1class Solution {
2    public boolean hasPathSum(TreeNode root, int targetSum) {
3        if (root == null) {
4            return false;
5        }
6
7        if (root.left == null && root.right == null) {
8            return targetSum == root.val;
9        }
10
11        return hasPathSum(root.left, targetSum - root.val) ||
12               hasPathSum(root.right, targetSum - root.val);
13    }
14}