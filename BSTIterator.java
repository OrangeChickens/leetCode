/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BSTIterator {
	Stack<TreeNode> s;
	public BSTIterator(TreeNode root) {
		s = new Stack<TreeNode>();
		while(root != null) {
			s.push(root);
			root = root.left;
		}
	}
	public hasNext() {
		return !s.isEmpty();
	}
	public next() {
		TreeNode next = s.pop();
		int res = next.val;
		if(next.right != null) {
			TreeNode tN = next.right;
			while(tN != null) {
				s.push(tN);
				tN = tN.left;
			}
		}
		return res;
	}
}