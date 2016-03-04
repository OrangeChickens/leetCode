/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
        	return res;
        }
        boolean fromRight = true;
        Stack<TreeNode> current = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        current.push(root);
        while(!current.isEmpty()) {
        	List<Integer> levelList = new ArrayList<Integer>();
	        while(!current.isEmpty()) {
	        	TreeNode node = current.pop();
	        	levelList.add(node.val);
	        	if(fromRight) {
	        		if(node.left != null) {
	        			next.push(node.left);
	        		}
	        		if(node.right != null) {
	        			next.push(node.right);
	        		}
	        	} else {
	        		if(node.right != null) {
	        			next.push(node.right);
	        		}
	        		if(node.left != null) {
	        			next.push(node.left);
	        		}
	        	}
	        }
	        res.add(levelList);
	        fromRight = !fromRight;
	        Stack<TreeNode> temp = current;
	        current = next;
	        next = temp;
    	}
    	return res;
    }
}