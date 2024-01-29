/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Stack<Integer> stack = new Stack<>();
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        solve(root, targetSum, 0);
        return result;
    }
    
    public void solve(TreeNode root, int targetSum, int currentSum) {
        if(root == null) {
            return;
        }
        
        stack.push(root.val);
        currentSum += root.val;
        
        if(targetSum == currentSum && root.left == null && root.right == null) {
            save();
            stack.pop();
            return;
        }
        
        solve(root.left, targetSum, currentSum);
        solve(root.right, targetSum, currentSum);
        
        stack.pop();
    }
    
    public void save() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < stack.size(); i++) {
            list.add(stack.elementAt(i));
        }
        result.add(list);
    }
}