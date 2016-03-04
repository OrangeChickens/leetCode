/*Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(new ArrayList<Integer>(), root, 0, sum, res);
        return res;
    }

    private void helper(List<Integer> path, TreeNode root, int val, int sum, List<List<Integer>> res) {
    	if(root == null) {
    		return;
    	}
    	val += root.val;
    	path.add(root.val);
    	if(root.left == null && root.right == null) {
    		if(val == sum) {
    			res.add(path);
    		}
    	}
    	helper(new ArrayList<Integer>(path), root.left, val, sum, res);
    	helper(new ArrayList<Integer>(path), root.right, val, sum, res);

    }

}